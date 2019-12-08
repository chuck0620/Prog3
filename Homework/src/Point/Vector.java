package Point;

public class Vector {
	/*
	 * Egy egyedi vektor oszaly, ami tartalmaz 
	 * x: az x koordinata
	 * y: az y koordinata
	 * limit: a limit fole nem mehet x és y erteke
	 */
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
	public void setY(int newy) {
		if(newy <= limit) {
		y = newy;
		}
		else {
			y = limit;
		}
	}
	public void setX(int newx) {
		if(newx <= limit) {
			x = newx;
			}
			else {
				x = limit;
			}
	}
	public void setXY(int newx, int newy) {
		setX(newx);
		setY(newy);
	}
	public void fromAngle(double angle) {
		/*
		 * A brain vektorainak generalasara hasznalt fuggveny, ami egy random szamot kap
		 * 0-tol 9-ig, es megvizsgalja a kapott szam egeszreszet
		 * igy vegul 8 irany kozul allitja be az egyiket (+ a (0, 0), azaz egyik irany sem 
		 */
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
