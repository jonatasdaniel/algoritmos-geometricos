package bcc.ag.grahamscan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bcc.ag.Point;

public class GrahamScan {

	private final List<Point> points;

	public GrahamScan(List<Point> points) {
		this.points = points;
	}
	
	public List<Point> start() {
		Collections.sort(points);
		
		List<Point> pontosSuperiores = new ArrayList<Point>();
		List<Point> pontosInferiores = new ArrayList<Point>();
		
		pontosSuperiores.add(points.get(0));
		pontosSuperiores.add(points.get(1));
		
		for (int i = 3; i < points.size(); i++) {
			Point point = points.get(i);
			pontosSuperiores.add(point);
			
			while(pontosSuperiores.size() > 2 && direction(pontosSuperiores.get(pontosSuperiores.size()-1), pontosSuperiores.get(pontosSuperiores.size()-2), pontosSuperiores.get(pontosSuperiores.size()-3)) >= 0) {
				pontosSuperiores.remove(pontosSuperiores.size()-2);
			}
		}
		
		pontosInferiores.add(points.get(points.size()-1));
		pontosInferiores.add(points.get(points.size()-2));
		
		for (int j = points.size()-1; j >= 0; j--) {
			Point point = points.get(j);
			pontosInferiores.add(point);
			
			while(pontosInferiores.size() > 2 && direction(pontosInferiores.get(pontosInferiores.size()-1), pontosInferiores.get(pontosInferiores.size()-2), pontosInferiores.get(pontosInferiores.size()-3)) >= 0) {
				pontosInferiores.remove(pontosInferiores.size()-2);
			}
		}
		
		/*pontosInferiores.remove(0);
		pontosInferiores.remove(pontosInferiores.size()-1);*/
		pontosSuperiores.remove(0);
		pontosSuperiores.remove(pontosSuperiores.size()-1);
		
		List<Point> returned = new ArrayList<Point>();
		returned.addAll(pontosSuperiores);
		returned.addAll(pontosInferiores);
		return returned;
	}
	
	private int direction(Point p1, Point p2, Point p3) {
		int result = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
		
		return result;
	}
	
}