import com.googlecode.lanterna.terminal.Terminal;
public class GrappleGun extends Item{
  public GrappleGun(int startX, int startY, Terminal t){
    super(startX,startY,t);
    super.getTerminal().moveCursor(super.getX(), super.getY());
    super.getTerminal().putCharacter('\u003C');
  }
}
