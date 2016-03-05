package agario;

import apcs.Window;

public class Agar {
	
	int x;
	int y;
	double radius;
	String color;
	boolean alive = true;
	
	public Agar() {
		x = Window.rollDice( Window.width() );
		y = Window.rollDice( Window.height() );
		radius = 10;
		
		int c = Window.rollDice(6);
		if (c==1) color = "red";
		if (c==2) color = "green";
		if (c==3) color = "orange";
		if (c==4) color = "yellow";
		if (c==5) color = "blue";
		if (c==6) color = "purple";
		
		
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void touch(Agar other) {
		if (radius > other.radius) {
			radius = Math.sqrt(Math.pow(radius, 2) + Math.pow(other.radius, 2));
		}
		
		if (radius < other.radius) {
			alive = false;
		}
	}
	
	public boolean touching(Agar other) {
		if (Math.sqrt( 
				Math.pow(x - other.x, 2) + 
				Math.pow(y - other.y, 2)
				) 
				<= radius + other.radius) {
			return true;
		}
		return false;
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, (int) radius);
	}
	
	public void move() {
		int dx = Window.mouse.getX() - x;
		int dy = Window.mouse.getY() - y;
		
		x += dx/10;
		y += dy/10;
		
		if (dx > 10) {
			dx = 10;
		}
		if (dx < -10) {
			dx = -10;
		}
		if (dy > 10) {
			dy = 10;
		}
		if (dy < -10) {
			dy = -10;
		}
	}
}
