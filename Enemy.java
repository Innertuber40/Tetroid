public class Enemy extends Entity{
  private int health;
  private boolean exists;
  private int x;
  private int y;

  public enemy(int srartX, int startY, int h){
    health = h;
    x = startX;
    y = startY;
    exists = true;
  }
}
