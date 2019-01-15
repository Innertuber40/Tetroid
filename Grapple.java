public class Grapple{
  private int x;
  private int y;
  private boolean exists;

  public Grapple(int startX, int startY, Terminal terminal){
    x = startX;
    y = startY;
    terminal.moveCursor(x,y++);
    terminal.putCharacter(' '); // replace space with ^
  }
}
