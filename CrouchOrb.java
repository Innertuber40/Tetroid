import com.googlecode.lanterna.terminal.Terminal;
public class CrouchOrb extends Item{
  public CrouchOrb(int startX, int startY, Terminal t){
    super(startX,startY,t);
    super.getTerminal().moveCursor(super.getX(), super.getY());
    super.getTerminal().putCharacter('\u262F');
  }
}
