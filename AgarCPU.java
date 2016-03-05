package agario;

import apcs.Window;

public class AgarCPU extends Agar {
	
		int dx;
		int dy;
		
		public AgarCPU() {
			dx = Window.rollDice(11) - 6;
			dy = Window.rollDice(11) - 6;
		}

		public void move() {
			if (x > Window.width() - radius) {
				x = Window.width() - (int) radius;
				dx = -dx;
			}
			if (x < radius) {
				x = (int) radius;
				dx = -dx;
			}
			if (y > Window.height() - radius) {
				y = Window.height();
				dy = -dy;
			}
			if (y < radius) {
				y = (int) radius;
				dy = -dy;
			}
			x += dx;
			y += dy;
		}
}
