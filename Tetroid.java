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
     for(int i = 0; i < room.design.size(); i += 2) {
     putString((int)room.design.get(i), (int)room.design.get(i+1), " ", terminal, Terminal.Color.GREEN, Terminal.Color.BLACK);
     }
  }

  public static void main(String[] args) {
    int x = 40;
		int y = 16;
		int roomNumber = 0;
		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);
    Player mainCharacter = new Player(terminal, 40, 16);
    boolean running = true;
    terminal.setCursorVisible(false);
    long tStart = System.currentTimeMillis();
    long lastSecond = 0;

    ArrayList room0 = new ArrayList();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 4; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    ArrayList entrances0 = new ArrayList();
    entrances0.add(0);
    entrances0.add(16);
    entrances0.add(79);
    entrances0.add(16);
    Room Room0 = new Room(0, room0, entrances0);

    ArrayList room1 = new ArrayList();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 80; j++) {
        room1.add(j);
        room1.add(i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 76; j < 80; j++) {
        room1.add(j);
        room1.add(i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 80; j++) {
        room1.add(j);
        room1.add(i);
      }
    }
    ArrayList entrances1 = new ArrayList();
    entrances1.add(0);
    entrances1.add(16);
    entrances1.add(79);
    entrances1.add(16);
    Room Room1 = new Room(1, room1, entrances1);
    resetRoom(Room0, terminal);

    while(running){
      	Key key = terminal.readInput();
        //mainCharacter.fall();
        if (key != null){
	  if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }
          mainCharacter.move(key);
	   
	  if (roomNumber == 0 && mainCharacter.getX() == (int)Room0.entrances.get(2) && mainCharacter.getY() == (int)Room0.entrances.get(3)) {
	        resetRoom(Room1, terminal);
		x = (int)Room1.entrances.get(0);
		y = (int)Room1.entrances.get(1);
		mainCharacter.resetRoom(x, y);
		roomNumber = 1;
	  }
          mainCharacter.shoot(key);
          mainCharacter.grapple(key);
        }
      }
    }
}
