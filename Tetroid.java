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
  public static void main(String[] args) {
    ArrayList room0 = new ArrayList();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 30; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 2; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 30; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    ArrayList entrances0 = new ArrayList();
    entrances0.add(29);
    entrances0.add(17);
    entrances0.add(0);
    entrances0.add(17);
    Room0 = new Room(0, room0, entrances0);

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);

    for(int i = 0; i < Room0.design.size(); i += 2) {
      putString(Room0.design.get(i), Room0.design.get(i+1), " ", Terminal.Color.GREEN, Terminal.Color.BLACK);
    }
  }
}