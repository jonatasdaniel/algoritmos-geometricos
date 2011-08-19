package bcc.ag;

public class Point implements Comparable<Point> {

	private String orderBy;
	private Integer x;
	private Integer y;

	public Point(Integer x, Integer y) {
		this(x, y, "x");
	}
	
	public Point(Integer x, Integer y, String orderBy) {
		this.x = x;
		this.y = y;
		this.orderBy = orderBy;
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
	public int compareTo(Point o) {
		if(orderBy != null) {
			if(orderBy.equals("x")) {
				if(x > o.getX()) {
					return 1;
				} else if(x < o.getX()) {
					return -1;
				} else {
					return 0;
				}
			} else if(orderBy.equals("y")) {
				if(y > o.getY()) {
					return 1;
				} else if(y < o.getY()) {
					return -1;
				} else {
					return 0;
				}
			}
			return 0;
		} else {
			return 0;
		}
	}

}