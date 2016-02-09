package gamepieces;

import game.*;
import static game.MoveValidation.*;

public class Pawn extends Gamepiece {
	
	public Pawn(int x, int y, Player player) {
		super(x, y, player, 'A');
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
	
	
}
