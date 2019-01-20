import com.googlecode.lanterna.terminal.Terminal;
public class Grapple extends Bullet{
/**
  public Grapple(int startX, int startY, Player owner, Terminal terminal, int direction){
    x = startX;
    y = startY;
    terminal.moveCursor(x,y++);
    terminal.putCharacter('U+00A5'); // replace space with ^
  }
  **/
  public Grapple(int startX, int startY, Entity owner, Terminal t,int direction,String HV){
    super(startX,startY,owner,t,direction,HV);
  }


  
}
