import com.googlecode.lanterna.terminal.Terminal;
public class Gun extends Item{
  public Gun(int startX, int startY, Terminal t){
    super(startX,startY,t);
    super.getTerminal().moveCursor(super.getX(), super.getY());
    super.getTerminal().putCharacter('\u3030');
  }
}
