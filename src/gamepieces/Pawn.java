package gamepieces;

import game.*;

public class Pawn extends Gamepiece {
	
	public Pawn(int x, int y, Player player) {
		super(x, y, player, 'a');
	}
	
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		if (isAtStart(y) && isYDifferenceTwoOrLess(y, newY)) {
			super.move(newX, newY);
		}
		else if (isYDifferenceOne(y, newY)) {
			super.move(newX, newY);
		}
		
	}
	
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return isAtTheEnd(y) || 
				isBackwards(y, newY) || 
				isSideways(x, newX, y, newY) || 
				isXDifferenceMoreThanOne(x, newX);
	}
	
	private boolean isBackwards(int y, int newY) { 
		return y - newY < 0;
	}
	
	private boolean isAtTheEnd(int y) {
		return y == 1;
	}
	
	private boolean isYDifferenceOne(int y, int newY) {
		return y - newY == 1;
	}
	
	private boolean isAtStart(int y) {
		return y == 7;
	}
	
	private boolean isYDifferenceTwoOrLess(int y, int newY) {
		return y - newY <= 2;
	}
	
	private boolean isSideways(int x, int newX, int y, int newY) {
		return x - newX != 0 && y == newY;
	}
	
	private boolean isXDifferenceMoreThanOne(int x, int newX) {
		return x - newX > 1;
	}
}
