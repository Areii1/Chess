package gamepieces;

import game.*;

public class Pawn extends Gamepiece {
	
	public Pawn(int x, int y, Player player) {
		super(x, y, player, 'a');
	}
	
	public void move(int newX, int newY) {
		
		if (y > 1 && y - newY == 1 && x - newX == 0) {
			x = newX;
			y = newY;
		}
		
		if (y == 7 && y - newY <= 2 && x - newX == 0) {
			x = newX;
			y = newY;
		}
	}
}
