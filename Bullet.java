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

	public Terminal getTerminal(){
		return terminal;
	}
	public boolean getExists() {
		return exists;
	}
	public void move(String direction, Terminal terminal) {
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
      		terminal.putCharacter('\u002A');
	}
	public void gone() {
		exists = false;
	}
}
