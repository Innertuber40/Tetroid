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
public class Player extends Entity{
  private Boolean right = true;
  private Boolean crouches = false;
  private Boolean grapples = false;
  private Boolean shoots = false;
  private Terminal terminal;
  private Key key;
  private Boolean alive = true;

  int x;
  int y;

  //constructors
  public Player(Terminal t, int xgvn, int ygvn){
    super.setHealth(3);
    terminal = t;
    x = xgvn;
    y = ygvn;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
    terminal.moveCursor(x-1,y);
    terminal.putCharacter('\u00F2'); //left eyebrow
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u00AF'); //right mouth
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter('\u00AF'); //left mouth
    terminal.moveCursor(x,y+2);
    terminal.putCharacter('\u2518'); //right chest
    terminal.moveCursor(x-1,y+2);
    terminal.putCharacter('\u2514');  //left chest
    terminal.moveCursor(x,y+3);
    terminal.putCharacter('\u007C'); //right leg
    terminal.moveCursor(x-1,y+3);
    terminal.putCharacter('\u007C'); //left leg
  }
  public void takeDamage(int damage){
    super.setHealth(super.getHealth() - damage);
    if (super.getHealth() <= 0){
      alive = false;
    }
  }

  public Boolean crouched(){
    return crouches;
  }

  public Boolean getAlive(){
    return alive;
  }

  public void setAlive(Boolean respawn){
    alive = respawn;
  }

  public int getX() {
	  return x;
  }
  public int getY() {
	  return y;
  }

  //public void fall(){
  //  Terminal.getCharacter(x,y);

  //}
  public void clear(){
    terminal.moveCursor(x,y);
    terminal.putCharacter(' ');
    terminal.moveCursor(x-1,y);
    terminal.putCharacter(' ');
    terminal.moveCursor(x,y+1);
    terminal.putCharacter(' ');
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter(' ');
    terminal.moveCursor(x,y+2);
    terminal.putCharacter(' ');
    terminal.moveCursor(x-1,y+2);
    terminal.putCharacter(' ');
    terminal.moveCursor(x,y+3);
    terminal.putCharacter(' ');
    terminal.moveCursor(x-1,y+3);
    terminal.putCharacter(' ');
  }
  public void place(int newX, int newY){
    x = newX;
    y = newY;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
    terminal.moveCursor(x-1,y);
    terminal.putCharacter('\u00F2'); //left eyebrow
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u00AF'); //right mouth
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter('\u00AF'); //left mouth
    terminal.moveCursor(x,y+2);
    terminal.putCharacter('\u2518'); //right chest
    terminal.moveCursor(x-1,y+2);
    terminal.putCharacter('\u2514');  //left chest
    terminal.moveCursor(x,y+3);
    terminal.putCharacter('\u007C'); //right leg
    terminal.moveCursor(x-1,y+3);
    terminal.putCharacter('\u007C'); //left leg
  }

  public void move(Key k){
    key = k;
    if (key.getKind() == Key.Kind.ArrowLeft) {
      if (crouches){
        //y= y +2;
        terminal.moveCursor(x,y);
        terminal.putCharacter(' '); //right eye with eyebrow looking thing
        terminal.moveCursor(x-1,y);
        terminal.putCharacter(' '); //left eyebrow
        terminal.moveCursor(x,y+1);
        terminal.putCharacter(' '); //right mouth
        terminal.moveCursor(x-1,y+1);
        terminal.putCharacter(' '); //left mouth

      }
      else{
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+1);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+2);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+2);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+3);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+3);
      terminal.putCharacter(' ');
    }
    x--;
    right = false;
    }

    if (key.getKind() == Key.Kind.ArrowRight) {
      if (crouches){
        terminal.moveCursor(x,y);
        terminal.putCharacter(' '); //right eye with eyebrow looking thing
        terminal.moveCursor(x-1,y);
        terminal.putCharacter(' '); //left eyebrow
        terminal.moveCursor(x,y+1);
        terminal.putCharacter(' '); //right mouth
        terminal.moveCursor(x-1,y+1);
        terminal.putCharacter(' '); //left mouth
      }
      else{
      terminal.moveCursor(x,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+1);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+1);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+2);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+2);
      terminal.putCharacter(' ');
      terminal.moveCursor(x,y+3);
      terminal.putCharacter(' ');
      terminal.moveCursor(x-1,y+3);
      terminal.putCharacter(' ');
    }
    x++;
    right = true;
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
  if (crouches){
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
    terminal.moveCursor(x-1,y);
    terminal.putCharacter('\u00F2'); //left eyebrow
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u00AF'); //right mouth
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter('\u00AF'); //left mouth
  }
  else{
  terminal.moveCursor(x,y);
  terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
  terminal.moveCursor(x-1,y);
  terminal.putCharacter('\u00F2'); //left eyebrow
  terminal.moveCursor(x,y+1);
  terminal.putCharacter('\u00AF'); //right mouth
  terminal.moveCursor(x-1,y+1);
  terminal.putCharacter('\u00AF'); //left mouth
  terminal.moveCursor(x,y+2);
  terminal.putCharacter('\u2518'); //right chest
  terminal.moveCursor(x-1,y+2);
  terminal.putCharacter('\u2514');  //left chest
  terminal.moveCursor(x,y+3);
  terminal.putCharacter('\u007C'); //right leg
  terminal.moveCursor(x-1,y+3);
  terminal.putCharacter('\u007C'); //left leg
}
  }


  public boolean crouch(){ //c button
      if (crouches){
        crouches = false;
        y = y - 2;
  terminal.moveCursor(x,y);
  terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
  terminal.moveCursor(x-1,y);
  terminal.putCharacter('\u00F2'); //left eyebrow
  terminal.moveCursor(x,y+1);
  terminal.putCharacter('\u00AF'); //right mouth
  terminal.moveCursor(x-1,y+1);
  terminal.putCharacter('\u00AF'); //left mouth
  terminal.moveCursor(x,y+2);
  terminal.putCharacter('\u2518'); //right chest
  terminal.moveCursor(x-1,y+2);
  terminal.putCharacter('\u2514');  //left chest
  terminal.moveCursor(x,y+3);
  terminal.putCharacter('\u007C'); //right leg
  terminal.moveCursor(x-1,y+3);
  terminal.putCharacter('\u007C'); //left leg
	return true;
      }
      else{
        terminal.moveCursor(x,y);
        terminal.putCharacter(' ');
        terminal.moveCursor(x-1,y);
        terminal.putCharacter(' ');
        terminal.moveCursor(x,y+1);
        terminal.putCharacter(' ');
        terminal.moveCursor(x-1,y+1);
        terminal.putCharacter(' ');
        crouches = true;
        y = y + 2;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
    terminal.moveCursor(x-1,y);
    terminal.putCharacter('\u00F2'); //left eyebrow
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u00AF'); //right mouth
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter('\u00AF'); //left mouth
	return crouches;
      }
    }


  /*public void grapple(Key input){
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
  }*/

  /*public void shoot(Key input){
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
  }*/

  public void resetRoom(int xgvn, int ygvn){
    x = xgvn;
    y = ygvn;
    terminal.moveCursor(x,y);
    terminal.putCharacter('\u00F3'); //right eye with eyebrow looking thing
    terminal.moveCursor(x-1,y);
    terminal.putCharacter('\u00F2'); //left eyebrow
    terminal.moveCursor(x,y+1);
    terminal.putCharacter('\u00AF'); //right mouth
    terminal.moveCursor(x-1,y+1);
    terminal.putCharacter('\u00AF'); //left mouth
    terminal.moveCursor(x,y+2);
    terminal.putCharacter('\u2518'); //right chest
    terminal.moveCursor(x-1,y+2);
    terminal.putCharacter('\u2514');  //left chest
    terminal.moveCursor(x,y+3);
    terminal.putCharacter('\u007C'); //right leg
    terminal.moveCursor(x-1,y+3);
    terminal.putCharacter('\u007C'); //left leg
    }
  }
