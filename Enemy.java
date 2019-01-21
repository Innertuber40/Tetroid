import com.googlecode.lanterna.terminal.Terminal;
public class Enemy extends Entity{
  private int health;
  private boolean exists;
  private int x;
  private int y;
  private Terminal terminal;

  public Enemy(int startX, int startY, int h, Terminal t){
    health = h;
    x = startX;
    y = startY;
    exists = true;
    terminal = t;
  }

  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getHealth(){
    return health;
  }
  public Terminal getTerminal(){
    return terminal;
  }
  public void setHealth(int h){
    health = h;
  }
  public void takeDamage(int damage){
    health = health - damage;
  }

  public Boolean hit(int bulletX, int bulletY){
    if ((bulletX == x && bulletY == y) ||
        (bulletX == x - 1 && bulletY == y) ||
        (bulletX == x - 2 && bulletY == y) ||
        (bulletX == x && bulletY == y + 1) ||
        (bulletX == x - 1 && bulletY == y + 1) ||
        (bulletX == x - 2 && bulletY == y + 1) ||
        (bulletX == x + 1 && bulletY == y + 1) ||
        (bulletX == x + 2 && bulletY == y + 1)
    ){
      return true;
    }

      return false;
    
  }
}
