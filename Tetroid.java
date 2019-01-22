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
    ArrayList<Integer> entrances0 = new ArrayList<Integer>();
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
    ArrayList<Integer> entrances1 = new ArrayList<Integer>();
    entrances1.add(0);
    entrances1.add(16);
    entrances1.add(79);
    entrances1.add(16);
    Room Room1 = new Room(1, room1, entrances1);

    Pixel[][] room2 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room2[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 4; j++) {
        room2[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 35; j++) {
        room2[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 45; j < 80; j++) {
        room2[j][i] = new Pixel(j, i);
      }
    }
    ArrayList<Integer> entrances2 = new ArrayList<Integer>();
    entrances2.add(0);
    entrances2.add(16);
    entrances2.add(79);
    entrances2.add(16);
    entrances2.add(35);
    entrances2.add(19);
    entrances2.add(44);
    entrances2.add(19);
    Room Room2 = new Room(2, room2, entrances2);

    Pixel[][] room3 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 35; j++) {
        room3[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 45; j < 80; j++) {
        room3[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 18; i++) {
      for (int j = 76; j < 80; j++) {
        room3[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room3[j][i] = new Pixel(j, i);
      }
    }
    ArrayList<Integer> entrances3 = new ArrayList<Integer>();
    entrances3.add(0);
    entrances3.add(16);
    entrances3.add(36);
    entrances3.add(0);
    entrances3.add(44);
    entrances3.add(0);
    Room Room3 = new Room(3, room3, entrances3);

    Pixel[][] room4 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room4[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 10; j++) {
        room4[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 20; j < 80; j++) {
        room4[j][i] = new Pixel(j, i);
      }
    }
    ArrayList<Integer> entrances4 = new ArrayList<Integer>();
    entrances4.add(0);
    entrances4.add(16);
    entrances4.add(79);
    entrances4.add(16);
    entrances4.add(11);
    entrances4.add(19);
    entrances4.add(19);
    entrances4.add(19);
    Room Room4 = new Room (4, room4, entrances4);

    Pixel[][] room5 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 10; j++) {
        room5[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 20; j < 80; j++) {
        room5[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room5[j][i] = new Pixel(j, i);
      }
    }
    ArrayList<Integer> entrances5 = new ArrayList<Integer>();
    entrances5.add(0);
    entrances5.add(16);
    entrances5.add(79);
    entrances5.add(16);
    entrances5.add(11);
    entrances5.add(0);
    entrances5.add(19);
    entrances5.add(0);
    Room Room5 = new Room(5, room5, entrances5);

    Pixel[][] room6 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room6[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 76; j < 80; j++) {
        room6[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room6[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 10; i < 12; i++) {
       for (int j = 20; j < 61; j++) {
         room6[j][i] = new Pixel(j, i);
       }
    }
    ArrayList<Integer> entrances6 = new ArrayList<Integer>();
    entrances6.add(0);
    entrances6.add(16);
    entrances6.add(79);
    entrances6.add(16);
    Room Room6 = new Room(6, room6, entrances6);
    
    Pixel[][] room7 = new Pixel[80][20];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room7[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 0; i < 20; i++) {
      for (int j = 76; j < 80; j++) {
        room7[j][i] = new Pixel(j, i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 65; j++) {
        room7[j][i] = new Pixel(j, i);
      }
    }
    ArrayList<Integer> entrances7 = new ArrayList<Integer>();
    entrances7.add(0);
    entrances7.add(16);
    entrances7.add(66);
    entrances7.add(19);
    Room Room7 = new Room(7, room7, entrances7);

    resetRoom(Room0, terminal);
    currentRoom = Room0;
    Bullet myBullet = new Bullet(x, y, mainCharacter, terminal, 0, "horizontal");
    myBullet.gone();
    int wait = 0;
    boolean goRight = false;
    boolean crouched = false;

    Grapple myGrapple = new Grapple(x,y,mainCharacter,terminal,-1,"vertical");
    myGrapple.gone();
    VerticalShootingEnemy vduck1 = null;
    VerticalShootingEnemy vduck2 = null;
    VerticalShootingEnemy vduck3 = null;
    HorizontalShootingEnemy hduck1 = null;
    HorizontalShootingEnemy hduck2 = null;
    HorizontalShootingEnemy hduck3 = null;
    CrouchOrb orb = null;
    boolean canCrouch = false;
    Gun pistel = null;
    boolean canShoot = false;
    GrappleGun grappler = null;
    boolean canGrapple = false;

    Bullet duckpoop = null;//new Bullet(50,12,duck1,terminal,0,"vertical");
    boolean loaded = false;
    boolean falling = false;
    boolean top = false;
    int waitd = 0;
    int lastEnteredX = 40;
    int lastEnteredY = 16;
    while(running){
      	Key key = terminal.readInput();
	  if (currentRoom == Room0 && mainCharacter.getX() == (int)Room0.entrances.get(2)) {
	        resetRoom(Room1, terminal);
		x = (int)Room1.entrances.get(0) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room1;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }

	  if (currentRoom == Room1 && mainCharacter.getX() == (int)Room1.entrances.get(0) + 1) {
	        resetRoom(Room0, terminal);
		x = (int)Room0.entrances.get(2) - 1;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room0;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room1 && mainCharacter.getX() == (int)Room1.entrances.get(2)) {
	        resetRoom(Room2, terminal);
		x = (int)Room2.entrances.get(0) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room2;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room2 && mainCharacter.getX() == (int)Room2.entrances.get(0) + 1) {
	        resetRoom(Room1, terminal);
		x = (int)Room1.entrances.get(2) - 1;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room1;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
		vduck3 = null;
	  }
	  if (currentRoom == Room2 && mainCharacter.getX() - 1 == (int)Room2.entrances.get(4) && ((!crouched && mainCharacter.getY() == (int)Room2.entrances.get(5)-3) || (crouched && mainCharacter.getY() == (int) Room2.entrances.get(5) - 1))) {
	        resetRoom(Room3, terminal);
		x = (int)Room3.entrances.get(2);
		y = (int)Room3.entrances.get(3) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room3;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room2 && mainCharacter.getX() == (int)Room2.entrances.get(6) && ((!crouched && mainCharacter.getY() == (int)Room2.entrances.get(7)-3) || (crouched && mainCharacter.getY() == (int) Room2.entrances.get(7) - 1))) {
	        resetRoom(Room3, terminal);
		x = (int)Room3.entrances.get(4);
		y = (int)Room3.entrances.get(5) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room3;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room3 && mainCharacter.getX() == (int)Room3.entrances.get(2) && mainCharacter.getY() == (int)Room3.entrances.get(3) + 1) {
	        resetRoom(Room2, terminal);
		x = (int)Room2.entrances.get(4) - 2;
		y = (int)Room2.entrances.get(5) - 5;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room2;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room3 && mainCharacter.getX() == (int)Room3.entrances.get(4) && mainCharacter.getY() == (int)Room3.entrances.get(5) + 1) {
	        resetRoom(Room2, terminal);
		x = (int)Room2.entrances.get(6) + 2;
		y = (int)Room2.entrances.get(7) - 5;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room2;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room3 && mainCharacter.getX() == (int)Room3.entrances.get(0) + 1) {
	        resetRoom(Room4, terminal);
		x = (int)Room4.entrances.get(2) - 1;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room4;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room4 && mainCharacter.getX() == (int)Room4.entrances.get(2)) {
	        resetRoom(Room3, terminal);
		x = (int)Room3.entrances.get(0) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room3;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room4 && mainCharacter.getX() == (int)Room4.entrances.get(4) && ((!crouched && mainCharacter.getY() == (int)Room4.entrances.get(5)-3) || (crouched && mainCharacter.getY() == (int) Room4.entrances.get(5) - 1))) {
	        resetRoom(Room5, terminal);
		x = (int)Room5.entrances.get(4);
		y = (int)Room5.entrances.get(5) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room5;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room4 && mainCharacter.getX() == (int)Room4.entrances.get(6) && ((!crouched && mainCharacter.getY() == (int)Room4.entrances.get(7)-3) || (crouched && mainCharacter.getY() == (int) Room4.entrances.get(7) - 1))) {
	        resetRoom(Room5, terminal);
		x = (int)Room5.entrances.get(6);
		y = (int)Room5.entrances.get(7) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room5;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room5 && mainCharacter.getX() == (int)Room5.entrances.get(4) && mainCharacter.getY() == (int)Room3.entrances.get(5) + 1) {
	        resetRoom(Room4, terminal);
		x = (int)Room4.entrances.get(4) - 2;
		y = (int)Room4.entrances.get(5) - 5;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room4;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room5 && mainCharacter.getX() == (int)Room5.entrances.get(6) && mainCharacter.getY() == (int)Room5.entrances.get(7) + 1) {
	        resetRoom(Room4, terminal);
		x = (int)Room4.entrances.get(6) + 2;
		y = (int)Room4.entrances.get(7) - 5;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room4;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
	  }
	  if (currentRoom == Room5 && mainCharacter.getX() == (int)Room5.entrances.get(2)) {
	        resetRoom(Room6, terminal);
		x = (int)Room6.entrances.get(0) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room6;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room6 && mainCharacter.getX() == (int)Room6.entrances.get(0) + 1) {
	        resetRoom(Room5, terminal);
		x = (int)Room5.entrances.get(2) - 1;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room5;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room2 && mainCharacter.getX() == (int)Room2.entrances.get(2)) {
	        resetRoom(Room7, terminal);
		x = (int)Room7.entrances.get(0) + 2;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room7;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
	  if (currentRoom == Room7 && mainCharacter.getX() == (int)Room7.entrances.get(0) + 1) {
	        resetRoom(Room2, terminal);
		x = (int)Room2.entrances.get(2) - 1;
		mainCharacter.resetRoom(x, y);
		currentRoom = Room2;
    loaded = false;
    		lastEnteredX = x;
		lastEnteredY = y;
		if (crouched) {
			lastEnteredY = y - 2;
		}
	  }
        if (currentRoom == Room1 && loaded == false){
          //vduck3 = new VerticalShootingEnemy(50,10,3,terminal);
          //duckpoop = new Bullet(50,12,vduck1,terminal,0,"vertical");
          vduck1 = null;
          vduck2 = null;
          hduck1 = null; //new HorizontalShootingEnemy(30,14,3,terminal);
          hduck2 = null;
          hduck3 = null;
          orb = new CrouchOrb(43, 16, terminal);
          loaded = true;
	}
        if (currentRoom == Room0 && loaded == false){
          vduck2 = null;
          vduck3 = null;
          hduck1 = null;
          hduck3 = null;
          pistel = new Gun(45,16,terminal);
          //grappler = new GrappleGun(43,16,terminal);
          loaded = true;
          //vduck1 = new VerticalShootingEnemy(50,10,3,terminal);
          //hduck2 = new HorizontalShootingEnemy(40,10,3,terminal);
        }
        if (currentRoom == Room2 && loaded == false){
          vduck3 = new VerticalShootingEnemy(50,10,3,terminal);
          duckpoop = new Bullet(50,12,vduck3,terminal,0,"vertical");
	  loaded = true;
        }
	if (currentRoom != Room2) {
		vduck3 = null;
		duckpoop = null;
	}
        if (currentRoom == Room6 && loaded == false){
          grappler = new GrappleGun(43,16,terminal);
        }
        if (grappler != null){
          if (mainCharacter.touch(grappler.getX(),grappler.getY())){
            canGrapple = true;
            grappler.clear();
            grappler = null;
          }
        }

        if (pistel != null){
          if (mainCharacter.touch(pistel.getX(),pistel.getY())){
            canShoot = true;
            pistel.clear();
            pistel = null;
          }
        }

        if (orb != null){
          if (mainCharacter.touch(orb.getX(),orb.getY())){
            canCrouch = true;
            orb.clear();
            orb = null;
          }
        }
        if (duckpoop != null && duckpoop.getExists()){
	  if (waitd % 250 == 0){
            if (duckpoop.getX() == mainCharacter.getX() && duckpoop.getY() == mainCharacter.getY()){
              mainCharacter.takeDamage(1);
            }
            duckpoop.move("down", terminal,false);
            if (currentRoom.isAPixel(duckpoop.getX(),duckpoop.getY()+1)){
              duckpoop.setY(12);
            }
            //x = mainCharacter.getX();
          }
	  waitd++;
        }

      if (myBullet != null && myGrapple != null && vduck3 != null &&
      vduck3.hit(myBullet.getX(), myBullet.getY()) ){ //||
      //vduck3.hit(myGrapple.getX(),myGrapple.getY())){
          myBullet.setExists(false);
          vduck3.takeDamage(1);
        }
        if (myGrapple != null && vduck3 != null &&
        vduck3.hit(myGrapple.getX(),myGrapple.getY())){
            myGrapple.setExists(false);
            vduck3.takeDamage(1);
            //duckpoop.setExists(false);
          }



        if (vduck3 != null && vduck3.getHealth() <= 0){
          vduck3.clear();
          vduck3 = null;
          duckpoop = null;
        }

        if (mainCharacter.getAlive() == false){
	  if (crouched) {
		mainCharacter.crouch();
		crouched = false;
	  }
          mainCharacter.clear();
          mainCharacter.resetRoom(lastEnteredX, lastEnteredY);
          mainCharacter.setHealth(3);
          mainCharacter.setAlive(true);
        }

        if (key != null){

        if (canGrapple == true && drop == true && key.getCharacter() == 'x' && !myGrapple.getExists() && !myBullet.getExists() && mainCharacter.crouched() == false){
          myGrapple = new Grapple(x,y-1,mainCharacter,terminal,-1,"vertical");
          myGrapple.setExists(true);
          //terminal.putCharacter('\u2038');
        }
	  if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }

    if (canCrouch == true && key.getCharacter() == 'c' && !top && (!crouched || (!currentRoom.isAPixel(mainCharacter.getX(), mainCharacter.getY() - 1) && !currentRoom.isAPixel(mainCharacter.getX() - 1, mainCharacter.getY() - 1)))){
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

	  if (key.getCharacter() == 'z' && !myBullet.getExists() && !myGrapple.getExists() && mainCharacter.crouched() == false && canShoot == true) {
		  int direction = -1;
		  if (goRight) {
			  direction = 1;

		  myBullet = new Bullet(x+1, y + 2, mainCharacter, terminal, direction,"horizontal");
    }
      else{
        myBullet = new Bullet(x-2, y + 2, mainCharacter, terminal,direction,"horizontal");
      }
	  }
	  if (!myBullet.getExists() && !myGrapple.getExists() && !falling && ((goRight && !(currentRoom.isAPixel(x+1, y) || currentRoom.isAPixel(x+1, y+1) )) || (!goRight && !(currentRoom.isAPixel(x-2, y+1) || (currentRoom.isAPixel(x-2, y)))))) {
	      x= mainCharacter.getX();
	      y = mainCharacter.getY();
		  if(crouched){
		  mainCharacter.move(key);
      drop = !currentRoom.isAPixel(mainCharacter.getX(), mainCharacter.getY() + 1);
	      }
	      else if (((goRight && !(currentRoom.isAPixel(x+1, y+2) || currentRoom.isAPixel(x+1, y+3))) || (!goRight && !(currentRoom.isAPixel(x-2, y+2) || currentRoom.isAPixel(x-2, y+3))))) {
		  mainCharacter.move(key);
      drop = !currentRoom.isAPixel(mainCharacter.getX(), mainCharacter.getY() + 1);
	      }
	  x = mainCharacter.getX();
  y = mainCharacter.getY();
  	  top = false;
	  }
	}
          if (myBullet.getExists()) {
		  if (wait % 100 == 0) {
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
      if ( wait % 500 == 0){
        myGrapple.move("up", terminal, false);
      //  if (currentRoom.isAPixel(myGrapple.getX(), myGrapple.getY() + 1){
      //    mainCharacter.place(myGrapple.getX(), myGrapple.getY() + 1);
        //}
      if (myGrapple.getY() == 0)
	      myGrapple.gone();
      	      terminal.moveCursor(myGrapple.getX(), myGrapple.getY());
	      terminal.putCharacter(' ');
      }
      else if ((currentRoom.entrances.contains(myGrapple.getX()) && myGrapple.getY() == 1) || currentRoom.isAPixel(myGrapple.getX(), myGrapple.getY() - 1)){
        myGrapple.gone();
        mainCharacter.clear();
        terminal.moveCursor(myGrapple.getX(), myGrapple.getY());
        x = myGrapple.getX();
        y = myGrapple.getY();
        mainCharacter.place(x,y);
        drop = false;
	top = true;
        //terminal.putCharacter(' ');
      }
      wait++;
    }

    if (((crouched && mainCharacter.getY() < 18) || (!crouched && mainCharacter.getY() < 16)) && ((!crouched && !(currentRoom.isAPixel(mainCharacter.getX(),mainCharacter.getY()+4))&& !(currentRoom.isAPixel(mainCharacter.getX() -1,mainCharacter.getY()+4))) || (crouched && !(currentRoom.isAPixel(mainCharacter.getX(),mainCharacter.getY()+2))&& !(currentRoom.isAPixel(mainCharacter.getX() -1,mainCharacter.getY()+2))))
     && drop == true){
      //mainCharacter.fall();
      if (wait % 125 == 0) {
      x = mainCharacter.getX();
      y = mainCharacter.getY() + 1;
      mainCharacter.clear();
      mainCharacter.place(x,y);
      }
      wait++;
      falling = true;
    } else {
	    falling = false;
    }
	//if ((crouched && currentRoom.isAPixel(x, y+2)) || (!crouched && currentRoom.isAPixel(x, y+4))){
        //mainCharacter.fall();
	//}
      }
}
}
