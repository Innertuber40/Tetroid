import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import java.util.ArrayList;

public class Room {
  public int roomNumber;
  private ArrayList design;
  public int[][][] entrances;

  public Room(int num, ArrayList des, int[][][] entrs) {
    roomNumber = num;
    design = des;
    entrances = entrs;
  }
}
