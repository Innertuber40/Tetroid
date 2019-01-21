import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import java.util.ArrayList;

public class Tetroid {
  public static void putString(int r, int c, String s, Terminal t, Terminal.Color fore, Terminal.Color back ){
    t.moveCursor(r,c);
    t.applyBackgroundColor(fore);
    t.applyForegroundColor(Terminal.Color.BLACK);

    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
    t.applyBackgroundColor(Terminal.Color.DEFAULT);
    t.applyForegroundColor(Terminal.Color.DEFAULT);
  }

  public static void resetRoom(Room room, Terminal terminal) {
     for(int i = 0; i < 80; i++) {
	     for(int j = 0; j < 20; j++) {
		     putString(i, j, " ", terminal, Terminal.Color.BLACK, Terminal.Color.BLACK);
	     }
     }
     for(int i = 0; i < 80; i++) {
       for(int j = 0; j < 20; j++) {
	 if(room.isAPixel(i, j)) {
     	   putString(i, j, " ", terminal, Terminal.Color.GREEN, Terminal.Color.BLACK);
     }
   }
  }
  }

  public static void main(String[] args) {
    int x = 40;
		int y = 16;
		Room currentRoom;
    boolean drop = true;
	Key lastKeyPressed = new Key('o');

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);
    Player mainCharacter = new Player(terminal, 42, 14);
    boolean running = true;
    terminal.setCursorVisible(false);
    long tStart = System.currentTimeMillis();
    long lastSecond = 0;

    Pixel[][] room0 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room0[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 4; j++) {
        room0[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room0[j][i] = new Pixel(j, i);
      }
    }
    //room0[45][17] = new Pixel(45, 17);  //for testing edge detection
    ArrayList entrances0 = new ArrayList();
    entrances0.add(0);
    entrances0.add(16);
    entrances0.add(79);
    entrances0.add(16);
    Room Room0 = new Room(0, room0, entrances0);

    Pixel[][] room1 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room1[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 76; j < 80; j++) {
        room1[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room1[j][i] = new Pixel(j, i);
      }
    }
    ArrayList entrances1 = new ArrayList();
    entrances1.add(0);
    entrances1.add(16);
    entrances1.add(79);
    entrances1.add(16);
    Room Room1 = new Room(1, room1, entrances1);
    resetRoom(Room0, terminal);
    currentRoom = Room0;

    Bullet myBullet = new Bullet(x, y, mainCharacter, terminal, 0, "horizontal");
    myBullet.gone();
    int wait = 0;
    boolean goRight = false;
    boolean crouched = false;

    Grapple myGrapple = new Grapple(x,y,mainCharacter,terminal,-1,"vertical");
    myGrapple.setExists(false);
    VerticalShootingEnemy duck1 = new VerticalShootingEnemy(50,10,3,terminal);
    Bullet duckpoop = new Bullet(50,12,duck1,terminal,0,"vertical");
    HorizontalShootingEnemy duck2 = new HorizontalShootingEnemy(40,10,3,terminal);

    while(running){
      	Key key = terminal.readInput();
        if (key != null){

        if (key.getCharacter() == 'x' && !myGrapple.getExists() && !myBullet.getExists() && mainCharacter.crouched() == false){
          myGrapple = new Grapple(x,y-1,mainCharacter,terminal,-1,"vertical");
          myGrapple.setExists(true);
          //terminal.putCharacter('\u2038');
        }
	  if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }

    if (key.getCharacter() == 'c'){
      crouched = mainCharacter.crouch();
      y = mainCharacter.getY();
    }

	  if (!myBullet.getExists() && !myGrapple.getExists()){
	  	if (key.getKind() == Key.Kind.ArrowRight) {
			  goRight = true;
	  	}
	  	if (key.getKind() == Key.Kind.ArrowLeft) {
			  goRight = false;
		}
	  }

	  if (key.getCharacter() == 'z' && !myBullet.getExists() && !myGrapple.getExists() && mainCharacter.crouched() == false) {
		  int direction = -1;
		  if (goRight) {
			  direction = 1;

		  myBullet = new Bullet(x+1, y, mainCharacter, terminal, direction,"horizontal");
    }
      else{
        myBullet = new Bullet(x-2, y, mainCharacter, terminal,direction,"horizontal");
      }
	  }
	  if (currentRoom == Room0 && mainCharacter.getX() == (int)Room0.entrances.get(2)) {
	        resetRoom(Room1, terminal);
		x = (int)Room1.entrances.get(0) + 2;
		y = (int)Room1.entrances.get(1) - 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room1;
	  }

	  if (currentRoom == Room1 && mainCharacter.getX() == (int)Room1.entrances.get(0) + 1) {
	        resetRoom(Room0, terminal);
		x = (int)Room1.entrances.get(2) - 1;
		y = (int)Room1.entrances.get(3) - 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room0;
	  }
	  if (!myBullet.getExists() && !myGrapple.getExists() && ((goRight && !(currentRoom.isAPixel(x+1, y) || currentRoom.isAPixel(x+1, y+1) )) || (!goRight && !(currentRoom.isAPixel(x-2, y+1) || (currentRoom.isAPixel(x-2, y)))))) {
	      x= mainCharacter.getX();
	      y = mainCharacter.getY();
		  if(crouched){
		  mainCharacter.move(key);
      drop = true;
	      }
	      else if (((goRight && !(currentRoom.isAPixel(x+1, y+2) || currentRoom.isAPixel(x+1, y+3))) || (!goRight && !(currentRoom.isAPixel(x-2, y+2) || currentRoom.isAPixel(x-2, y+3))))) {
		  mainCharacter.move(key);
      drop = true;
	      }
	  x = mainCharacter.getX();
  y = mainCharacter.getY();
	  }
	}
          if (myBullet.getExists()) {
		  if (wait % 10000 == 0) {
			if (goRight) {
				myBullet.move("right", terminal,false);
				x = mainCharacter.getX();
			} else {
				myBullet.move("left", terminal,false);
				x = mainCharacter.getX();
			}
			int direction = -1;
			if(goRight) {
				direction = 1;
			}
		if ((myBullet.getX() <= 0 || myBullet.getX() >= 79) || currentRoom.isAPixel(myBullet.getX()+direction, myBullet.getY() + direction)) {
				myBullet.gone();
				terminal.moveCursor(myBullet.getX(), myBullet.getY());
				terminal.putCharacter(' ');
			}
		  }
		  wait++;
	  }

    /*if (!duckpoop.getExists()){
      if (wait % 10000 == 0){
        duckpoop.move("down", terminal,false);
        x = mainCharacter.getX();
      }
    }*/


    if (myGrapple.getExists()){
      if ( wait % 50000 == 0){
        myGrapple.move("up", terminal, false);
      //  if (currentRoom.isAPixel(myGrapple.getX(), myGrapple.getY() + 1){
      //    mainCharacter.place(myGrapple.getX(), myGrapple.getY() + 1);
        //}

      if (currentRoom.isAPixel(myGrapple.getX(), myGrapple.getY() - 1)){
        myGrapple.gone();
        mainCharacter.clear();
        terminal.moveCursor(myGrapple.getX(), myGrapple.getY());
        x = myGrapple.getX();
        y = myGrapple.getY();
        mainCharacter.place(x,y);
        drop = false;
        //terminal.putCharacter(' ');
      }
      }
      wait++;
    }

    if (!(currentRoom.isAPixel(mainCharacter.getX(),mainCharacter.getY()+4)) && drop == true){
      //mainCharacter.fall();
      x = mainCharacter.getX();
      y = mainCharacter.getY() + 1;
      mainCharacter.clear();
      mainCharacter.place(x,y);

    }
	//if ((crouched && currentRoom.isAPixel(x, y+2)) || (!crouched && currentRoom.isAPixel(x, y+4))){
        //mainCharacter.fall();
	//}
  }
}
}
