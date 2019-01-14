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
  public static void main(String[] args) {
    int x = 10;
		int y = 10;
		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(true);
    Player mainCharacter = new Player(terminal);
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
    entrances0.add(79);
    entrances0.add(17);
    entrances0.add(0);
    entrances0.add(17);
    Room Room0 = new Room(0, room0, entrances0);

    for(int i = 0; i < Room0.design.size(); i += 2) {
      putString((int)Room0.design.get(i), (int)Room0.design.get(i+1), " ", terminal, Terminal.Color.GREEN, Terminal.Color.BLACK);
    }
    while(running){
      	Key key = terminal.readInput();
        //mainCharacter.fall();
        if (key != null){
          if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }
          mainCharacter.move(key);
          mainCharacter.shoot(key);
          mainCharacter.grapple(key);
        }
        mainCharacter.move(key);
      }
    }
  }
}
