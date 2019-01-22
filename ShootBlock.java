public class ShootBlock {
	private Pixel[][] design; // how it looks
	private Room owner; // where it belongs; see Room.java, line : 2
	private int x; // where to start it
	private int y;
	private boolean exists; // whether it should manifest
	private ShootBlock link; // if it is linked to a ShootBlock at the entrance of the next room

	public ShootBlock(int xgivn, int ygivn, Room owns, ShootBlock links) {
		x = xgivn;
		y = ygivn;
		link = links;
		design = new Pixel[4][2]; // a 4*2 block
		design[0][0] = new Pixel(x,y);
		design[0][1] = new Pixel(x, y + 1);
		design[1][0] = new Pixel(x + 1, y);
		design[1][1] = new Pixel(x + 1, y + 1);
		design[2][0] = new Pixel(x + 2, y);
		design[2][1] = new Pixel(x + 2, y + 1);
		design[3][0] = new Pixel(x + 3, y);
		design[3][1] = new Pixel(x + 3, y + 1);
		exists = true;
		owner = owns;
	}

	public boolean isAShootBlock(int xgivn, int ygivn) { // enables interacting parties to tell if they are touching a ShootBlock
		return (design[0][0].getX() == xgivn && design[0][0].getY() == ygivn) || (design[1][0].getX() == xgivn && design[1][0].getY() == ygivn) || (design[0][1].getX() == xgivn && design[0][1].getY() == ygivn) || (design[1][1].getX() == xgivn && design[1][1].getY() == ygivn) || (design[2][0].getX() == xgivn && design[2][0].getY() == ygivn) || (design[3][0].getX() == xgivn && design[3][0].getY() == ygivn) || (design[2][1].getX() == xgivn && design[2][1].getY() == ygivn) || (design[3][1].getX() == xgivn && design[3][1].getY() == ygivn); // basically checks if the pixel given matches any of the entries in the array
	}
	
	public ShootBlock linked() {
		return link;
	}
	public void setLink(ShootBlock shoot) { // for linking to ShootBlocks that didn't exist when this was initialized
		link = shoot;
	}	

	public boolean exists(){
		return exists;
	}
	public void gone() { // makes it dissapear forever
		exists = false;
	}
}
