package Point;

public class Vector {
	private int x;
	private int y;
	int limit;
	Vector(){
		x = 0;
		y = 0;
		limit = 99999;
	}
	public Vector(int newx, int newy){
		x = newx;
		y = newy;
		limit = 99999;
	}
	public Vector copy() {
		Vector copy = new Vector(x, y);
		copy.limit = limit;
		return copy;
	}
	public void setLimit(int l) {
		limit = l;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void modifyY(int newy) {
		if(newy <= limit) {
		y = newy;
		}
		else {
			y = limit;
		}
	}
	public void modifyX(int newx) {
		if(newx <= limit) {
			x = newx;
			}
			else {
				x = limit;
			}
	}
	public void modifyXY(int newx, int newy) {
		modifyX(newx);
		modifyY(newy);
	}
	public void fromAngle(double angle) {
		switch ((int)angle) {
		case 0:
			x = 0;
			y = 1;
			break;
		case 1:
			x = 1;
			y = 0;
			break;
		case 2:
			x = 1;
			y = 1;
			break;
		case 3:
			x = 0;
			y = 0;
			break;
		case 4:
			x = -1;
			y = 1;
			break;
		case 5:
			x = -1;
			y = 0;
			break;
		case 6:
			x = -1;
			y = -1;
			break;
		case 7:
			x = 0;
			y = -1;
			break;
		case 8:
			x = 1;
			y = -1;
			break;
		default:
			x = 1;
			y = 1;
			break;
			
		}
		
		
		/*if(Math.sin(angle) <= 1 && Math.sin(angle) > 0.7071) {
			y = -1;
		}
		else if(Math.sin(angle) <= 0.7071 && Math.sin(angle) > -0.7071) {
			y = 0;
		}
		else if(Math.sin(angle) <= -0.7071 && Math.sin(angle) >= -1) {
			y = 1;
		}
		if(Math.cos(angle) <= 0.7071 && Math.cos(angle) > -0.7071) {
			x = 0;
		}
		else if(Math.cos(angle) <= 1 && Math.cos(angle) > 0.7071) {
			x = 1;
		}
		else if(Math.cos(angle) <= -0.7071 && Math.cos(angle) >= -1) {
			x = -1;
		}*/
	}
}
