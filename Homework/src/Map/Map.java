package Map;

import java.util.ArrayList;

import Point.Vector;

public class Map {
	/*
	 * A palya
	 * obstacles: Obstacle tipusokat tarolo ArrayList
	 * A 0. eleme mindig a cel
	 */
	ArrayList<Obstacle> obstacles;
	public Map(Vector a, Vector b){
		obstacles = new ArrayList<Obstacle>();
		obstacles.add(new Obstacle(a, b));
	}
	public void addObstacle(Obstacle ob) {
		obstacles.add(ob);
	}
	public Obstacle getObstacle(int i) {
		return obstacles.get(i);
	}
	public int getSize() {
		return obstacles.size();
	}
}
