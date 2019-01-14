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
  Boolean right = true;
  Boolean crouches = false;
  Boolean grapples = false;
  Boolean shoots = false;
  Terminal terminal;
  Key key;
  int x;
  int y;

  //constructors
  public Player(Terminal t, int xgvn, int ygvn){
    terminal = t;
    x = xgvn;
    y = ygvn;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00a4');
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u0048');
  }

  //public void fall(){
  //  Terminal.getCharacter(x,y);

  //}

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
      right = false;
      x--;
    }

    if (key.getKind() == Key.Kind.ArrowRight) {
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      right = true;
      x++;
    }

    /*if (key.getKind() == Key.Kind.ArrowUp) {
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      y--;
    }*/

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


//  public void crouch(){

  //  }


  public void grapple(Key input){
    if (key.getCharacter() == 'x'){
    int prevX = x;
    int prevY = y;
    int range = 5;
    y--;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u002A');
    while (range > 0){
      terminal.putCharacter(' ');
      y--;
      terminal.moveCursor(x,y);
      terminal.putCharacter('\u002A');
      range--;
    }
  }
  }

  public void shoot(Key input){
    int prevX = x;
    int prevY = y;
    int range = 20;
    if (key.getCharacter() == 'z'){
    if (right){
      x++;
      terminal.moveCursor(x,y);
      terminal.putCharacter('\u002A');
      terminal.putCharacter(' ');
      while (range > 0){
        terminal.putCharacter(' ');
        x++;
        terminal.moveCursor(x,y);
        terminal.putCharacter('\u002A');
        range--;
      }
    }
    else{
      x--;
      terminal.moveCursor(x,y);
      terminal.putCharacter('\u002A');
      while (range > 0){
        terminal.putCharacter(' ');
        x--;
        terminal.moveCursor(x,y);
        terminal.putCharacter('\u002A');
        range--;
      }
    }
    x = prevX;
    y = prevY;
    }
  }


}

  //private newRoom(int, boolean){

  //}
