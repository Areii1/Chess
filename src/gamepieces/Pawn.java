package gamepieces;

import game.*;
import static game.MoveValidation.*;

public class Pawn extends Gamepiece {
	
	/**		CONSTRUCTOR
	 * Constructor for a Pawn object, gives the pawn an (x,y) coordinate and defines the player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Pawn(int x, int y, Player player) {
		super(x, y, player, 'P');
	}	
	
	
	/**		Method move
	 * Changes the (x, y) coordinate of the Pawn if the move is not retarded.
	 */
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		if (isPawnAtStart(y) && isYDifferenceTwoOrLess(y, newY)) {
			super.move(newX, newY);
		}
		else if (isYDifferenceOne(y, newY)) {
			super.move(newX, newY);
		}
		
	}
	
	/**		Method isRetardMove
	 * returns true if an illegal move is made, pawn can not move sideways, backwards etc. Returns false if it is a legal move. 
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return isAtTheEnd(y) || 
				isBackwards(y, newY) || 
				isSideways(x, newX, y, newY) || 
				isXDifferenceMoreThanOne(x, newX);
	}
	
	
}
