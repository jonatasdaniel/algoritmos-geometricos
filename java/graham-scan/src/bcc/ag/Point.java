package bcc.ag;

import java.text.MessageFormat;

public class Point implements Comparable<Point> {

	private Integer x;
	private Integer y;
	
	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return MessageFormat.format("x: {0} , y: {1}", x, y);
	}
	
	@Override
	public int compareTo(Point o) {
		if(x > o.getX()) {
			return 1;
		} else if(x < o.getX()) {
			return -1;
		} else {
			if(y > o.getY()) {
				return 1;
			} else if(y < o.getY()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}