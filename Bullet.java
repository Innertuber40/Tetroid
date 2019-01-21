import com.googlecode.lanterna.terminal.Terminal;

public class Bullet {
	private int x;
	private int y;
	private Entity owns;
	private boolean exists;
	private Terminal terminal;


	public Bullet(int startX, int startY, Entity owner, Terminal t, int direction,String HorV) {

		x = startX;
		y = startY;
		owns = owner;
		terminal  = t;
		exists = true;
		if (HorV.equals("horizontal")){
      		terminal.moveCursor(x + direction,y);
      		terminal.putCharacter('\u002A');
				}
				else{
					terminal.moveCursor(x,y + direction);
      		terminal.putCharacter('\u002A');
				}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int newX){
		x = newX;
	}

	public void setY(int newy){
		y = newy;
	}

	public Terminal getTerminal(){
		return terminal;
	}
	public boolean getExists() {
		return exists;
	}
	public void setExists(boolean tf){
		exists = tf;
	}

	public void move(String direction, Terminal terminal,boolean grap) {
		terminal.moveCursor(x,y);
		if (direction.equals("right")) {
			x++;
		}
		if (direction.equals("left")) {
			x--;
		}
		if (direction.equals("up")) {
			y--;
		}
		if (direction.equals("down")){
			y++;
		}
		terminal.putCharacter(' ');
      		terminal.moveCursor(x,y);
					if (grap){
						terminal.putCharacter('\u2038');
					}
					else{
      		terminal.putCharacter('\u002A');
				}
	}
	public void gone() {
		exists = false;
	}
}
