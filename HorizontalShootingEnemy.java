import com.googlecode.lanterna.terminal.Terminal;
public class HorizontalShootingEnemy extends Enemy{
  public HorizontalShootingEnemy(int startX, int startY, int h, Terminal t){
    super(startX,startY,h,t);
    super.getTerminal().moveCursor(super.getX(),super.getY());
    super.getTerminal().putCharacter('\u0029'); //back of head
    super.getTerminal().moveCursor(super.getX()-1,super.getY());
    super.getTerminal().putCharacter('\u002A'); //eye
    super.getTerminal().moveCursor(super.getX()-2,super.getY());
    super.getTerminal().putCharacter('\u003E'); //opened beak
    super.getTerminal().moveCursor(super.getX(),super.getY()+1);
    super.getTerminal().putCharacter('\u005F'); //stomach
    super.getTerminal().moveCursor(super.getX()-1,super.getY()+1);
    super.getTerminal().putCharacter('\u004C'); //wing
    super.getTerminal().moveCursor(super.getX()-2,super.getY()+1);
    super.getTerminal().putCharacter('\u0028'); //chest
    super.getTerminal().moveCursor(super.getX()+1,super.getY()+1);
    super.getTerminal().putCharacter('\u0029'); //butt
    super.getTerminal().moveCursor(super.getX()+2,super.getY()+1);
    super.getTerminal().putCharacter('\u2215'); //tail
  }
    //>*)
    //(L_)/
    public void clear(){
      super.getTerminal().moveCursor(super.getX(),super.getY());
      super.getTerminal().putCharacter(' '); //back of the head
      super.getTerminal().moveCursor(super.getX()-1,super.getY());
      super.getTerminal().putCharacter(' '); //eye
      super.getTerminal().moveCursor(super.getX()-2,super.getY());
      super.getTerminal().putCharacter(' '); //beak
      super.getTerminal().moveCursor(super.getX(),super.getY()+1);
      super.getTerminal().putCharacter(' '); //wing
      super.getTerminal().moveCursor(super.getX()-1,super.getY()+1);
      super.getTerminal().putCharacter(' '); //stomach
      super.getTerminal().moveCursor(super.getX()-2,super.getY()+1);
      super.getTerminal().putCharacter(' '); //chest
      super.getTerminal().moveCursor(super.getX()+1,super.getY()+1);
      super.getTerminal().putCharacter(' '); //butt
      super.getTerminal().moveCursor(super.getX()+2,super.getY()+1);
      super.getTerminal().putCharacter(' '); //tail
    }


}
