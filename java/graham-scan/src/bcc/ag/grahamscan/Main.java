package bcc.ag.grahamscan;

import java.util.ArrayList;
import java.util.List;

import bcc.ag.Point;
import bcc.ag.view.Graph;

public class Main {

	public static void main(String[] args) {
		List<Point> points = createPoints();
		
		Graph g = new Graph(points);
		g.setVisible(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		GrahamScan grahamScan = new GrahamScan(points);
		
		List<Point> returned = grahamScan.start();
		
		g = new Graph(returned);
		g.setVisible(true);
	}

	private static List<Point> createPoints() {
		List<Point> points = new ArrayList<Point>();
		
		Point p = new Point(5, 5);
		points.add(p);
		p = new Point(2, 20);
		points.add(p);
		p = new Point(7, 40);
		points.add(p);
		p = new Point(10, 10);
		points.add(p);
		p = new Point(15, 30);
		points.add(p);
		p = new Point(20, 7);
		points.add(p);
		p = new Point(22, 2);
		points.add(p);
		p = new Point(30, 25);
		points.add(p);
		p = new Point(28, 38);
		points.add(p);
		p = new Point(50, 27);
		points.add(p);
		p = new Point(5, 5);
		points.add(p);
		
		return points;
	}

}