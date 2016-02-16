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
		if (player.getId() == 1){
			if (isRetardMovePlayer1(x, newX, y, newY)) return;

			if (isPawnAtStartPlayer1(y) && isMovementOneOrTwoNorth(x, y, newX, newY)) {
				super.move(newX, newY);
			}
			else if (isMovementOneNorth(x, y, newX, newY)) {
				super.move(newX, newY);
			}
		}
		if (player.getId() == 2){
			if (isRetardMovePlayer2(x, newX, y, newY)) return;

			if (isPawnAtStartPlayer2(y) && isMovementOneOrTwoSouth(x, y, newX, newY)) {
				super.move(newX, newY);
			}
			else if (isMovementOneSouth(x, y, newX, newY)) {
				super.move(newX, newY);
			}
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
	private boolean isRetardMovePlayer1(int x, int newX, int y, int newY) {
		return isAtTheEndPlayer1(y) || 
				isBackwards(y, newY) || 
				isSideways(x, newX, y, newY) || 
				isXDifferenceMoreThanOne(x, newX);
	}
	private boolean isRetardMovePlayer2(int x, int newX, int y, int newY) {
		return isAtTheEndPlayer2(y) || 
				!isBackwards(y, newY) || 
				isSideways(x, newX, y, newY) || 
				isXDifferenceMoreThanOne(x, newX);
	}
	
	
}
