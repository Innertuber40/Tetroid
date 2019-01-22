import com.googlecode.lanterna.terminal.Terminal;
public class Item{
  private int x;
  private int y;
  private Terminal terminal;
  public Item(int startX, int startY,Terminal t){
    x = startX;
    y = startY;
    terminal = t;
    //terminal.moveCursor(x,y);
  }
  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public Terminal getTerminal(){
    return terminal;
  }

  public void clear(){
    terminal.moveCursor(x,y);
    terminal.putCharacter(' ');
  }
}
