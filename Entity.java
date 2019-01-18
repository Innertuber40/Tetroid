public class Entity{
  private int health;
  private boolean exists = true;
  public void takeDamage(int damage){
    health = health - damage;
    if (health <= 0){
      exists = false;
    }
  }

  public void setHealth(int h){
    health = h;
  }
}
