package agario;

import java.util.*;

import apcs.*;

public class AgarGame {

	public static void main(String[] args) {
		Window.size(1366, 768);
		Window.frame();
		
		// Every object in the game
		ArrayList <Agar> list = new ArrayList <Agar>();
		
		// Add myself
		list.add(new Agar());
		for (int i = 0 ; i < 100 ; i++) {
			list.add(new AgarCPU());
		}
		for (int i = 0 ; i < 1000 ; i++) {
			list.add(new AgarFood());
		}
		
		while (true) {
			Window.out.background("white");
			
			if (Window.rollDice(3) == 1){
				list.add(new AgarFood());
			}
			
			//For every agar, call it a
			for (Agar a : list) {
				if (a.isAlive()) {
					//Draw and move it
					a.draw();
					a.move();
					
					for (Agar other : list) {
						if (a != other && other.isAlive()) {
							if (a.touching(other)) {
								a.touch(other);
								other.touch(a);
							}
						}
					}
				}
			}
			Window.frame();
			
		}
		
	}

}
