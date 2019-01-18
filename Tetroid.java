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

    Bullet myBullet = new Bullet(x, y, mainCharacter, terminal, 0);
    myBullet.gone();
    int wait = 0;
    boolean goRight = false;

    //Grapple myGrapple = new Grapple(x, y, mainCharacter, terminal, -1);
    VerticalShootingEnemy duck1 = new VerticalShootingEnemy(50,10,3,terminal);

    while(running){
      	Key key = terminal.readInput();
        //mainCharacter.fall();
        if (key != null){
	  if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }

    if (key.getCharacter() == 'c'){
      mainCharacter.crouch();
    }

	  if (!myBullet.getExists()){
	  	if (key.getKind() == Key.Kind.ArrowRight) {
			  goRight = true;
	  	}
	  	if (key.getKind() == Key.Kind.ArrowLeft) {
			  goRight = false;
		}
	  }
	  if (key.getCharacter() == 'z' && !myBullet.getExists() && mainCharacter.crouched() == false) {
		  int direction = -1;
		  if (goRight) {
			  direction = 1;

		  myBullet = new Bullet(x+1, y, mainCharacter, terminal, direction);
    }
      else{
        myBullet = new Bullet(x-2, y, mainCharacter, terminal,direction);
      }
	  }
	  if (currentRoom == Room0 && mainCharacter.getX() == (int)Room0.entrances.get(2)) {
	        resetRoom(Room1, terminal);
		x = (int)Room1.entrances.get(0) + 1;
		y = (int)Room1.entrances.get(1) - 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room1;
	  }

	  if (currentRoom == Room1 && mainCharacter.getX() == (int)Room1.entrances.get(0)) {
	        resetRoom(Room0, terminal);
		x = (int)Room1.entrances.get(2) - 1;
		y = (int)Room1.entrances.get(3) - 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room0;
	  }
          //mainCharacter.grapple(key);
	  if (!myBullet.getExists()) {
	  	  mainCharacter.move(key);
	  }
	  x = mainCharacter.getX();
	  y = mainCharacter.getY();
        }
          if (myBullet.getExists()) {
		  if (wait % 10000 == 0) {
			if (goRight) {
				myBullet.move("right", terminal);
				x = mainCharacter.getX();
			} else {
				myBullet.move("left", terminal);
				x = mainCharacter.getX();
			}
		if (myBullet.getX() <= 0 || myBullet.getX() >= 79) {
				myBullet.gone();
				terminal.moveCursor(myBullet.getX(), myBullet.getY());
				terminal.putCharacter(' ');
			}
		  }
		  wait++;
	  }
/**
    if (myGrapple.getExists()){
      if ( wait % 10000 == 0){
        myGrapple.move("up", terminal);
        y = mainCharacter.getY();
      if (myBullet.getY() >= 0){
        myGrapple.gone();
        terminal.moveCursor(myGrapple.getX(), myGrapple.getY());
        terminal.putCharacter(' ');
      }
      }
      wait++;
    }
    **/
    }
  }
}
