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
public class Player{
  Boolean crouches = false;
  Boolean grapples = false;
  Boolean shoots = false;
  Terminal terminal;
  Key key;
  int x = 10;
  int y = 10;

  //constructors
  public Player(Terminal t){
    terminal = t;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00a4');
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u0048');
  }


  //Terminal terminal = TerminalFacade.createTextTerminal();
  public void move(Key k){
    key = k;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00a4');
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u0048');

    if (key.getKind() == Key.Kind.ArrowLeft) {
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      x--;
    }

    if (key.getKind() == Key.Kind.ArrowRight) {
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      x++;
    }

    if (key.getKind() == Key.Kind.ArrowUp) {
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      y--;
    }

  //  if (key.getKind() == Key.Kind.ArrowDown) {
  //    terminal.moveCursor(x,y);
  //    terminal.putCharacter(' ');
  //    terminal.moveCursor(x,y+1);
  //    terminal.putCharacter(' ');
  //    y++;
  //  }
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00a4');
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u0048');
  }
}

//  public void crouch(){

  //  }


  //public boolean grapple(char input){

  //}

  //public void shoot(char input){

  //}

  //private newRoom(int, boolean){

  //}
