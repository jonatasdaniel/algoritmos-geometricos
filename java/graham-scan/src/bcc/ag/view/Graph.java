package bcc.ag.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;

import bcc.ag.Point;

public class Graph extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final List<Point> points;
	private final int scale; 
	
	public Graph(List<Point> points) {
		this.points = points;
		scale = 4;

		initialize();
	}
	
	private void initialize() {
		setSize(500, 500);
		setLayout(null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		
		for (Point p : points) {
			g.fillOval((p.getX()*scale)+20, (p.getY()*scale)+80, 5, 5);
		}
	}

}
