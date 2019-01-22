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

public class Room {
  private int roomNumber; // useless, just helps keep track when initializing
  private Pixel[][] design; // how the room looks
  private ArrayList<Integer> entrances; // the places that lead to other rooms

  public Room(int num, Pixel[][] des, ArrayList<Integer> entrs) {
    roomNumber = num;
    design = des;
    entrances = entrs;
  }

  public boolean isAPixel(int x, int y) { // tells whatever is asking whether a given part of the room can be interacted with
    if (design[x][y] != null) {
      return true;
    } else {
      return false;
    }
  }
  public ArrayList<Integer> entrances() { // enables the entrances list to be accessed
	  return entrances;
  }
}
