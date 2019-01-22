public class ShootBlock {
	private Pixel[][] design;
	private Room owner;
	private int x;
	private int y;
	private boolean exists;

	public ShootBlock(int xgivn, int ygivn, Room owns) {
		x = xgivn;
		y = ygivn;
		design = new Pixel[4][2];
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

	public boolean isAShootBlock(int xgivn, int ygivn) {
		return (design[0][0].getX() == xgivn && design[0][0].getY() == ygivn) || (design[1][0].getX() == xgivn && design[1][0].getY() == ygivn) || (design[0][1].getX() == xgivn && design[0][1].getY() == ygivn) || (design[1][1].getX() == xgivn && design[1][1].getY() == ygivn) || (design[2][0].getX() == xgivn && design[2][0].getY() == ygivn) || (design[3][0].getX() == xgivn && design[3][0].getY() == ygivn) || (design[2][1].getX() == xgivn && design[2][1].getY() == ygivn) || (design[3][1].getX() == xgivn && design[3][1].getY() == ygivn);
	}
	public boolean exists(){
		return exists;
	}

	public void gone() {
		exists = false;
	}
}
