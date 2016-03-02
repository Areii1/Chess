package gamepieces;

import game.*;

public class Pawn extends Gamepiece {
	
	/**		CONSTRUCTOR
	 * Constructor for a Pawn object, gives the pawn an (x,y) coordinate and defines the player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Pawn(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}	
	
	
	/**		Method move
	 * Changes the (x, y) coordinate of the Pawn if the move is not retarded.
	 */
	public void move(int newX, int newY) {
		if (player.getId() == 1){
			if (isRetardMovePlayer1(newX, newY)) return;

			if (isPawnAtStartPlayer1() && isMovementOneOrTwoNorth(newX, newY)) {
				super.move(newX, newY);
			}
			else if (isMovementOneNorth(newX, newY)) {
				super.move(newX, newY);
			}
		}
		if (player.getId() == 2){
			if (isRetardMovePlayer2(newX, newY)) return;

			if (isPawnAtStartPlayer2() && isMovementOneOrTwoSouth(newX, newY)) {
				super.move(newX, newY);
			}
			else if (isMovementOneSouth(newX, newY)) {
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
	private boolean isRetardMovePlayer1(int newX, int newY) {
		return isAtTheEndPlayer1() || 
				isMovementSouth(newX, newY) || 
				isMovementWestOrEast(newX, newY) || 
				isXDifferenceMoreThanOne(newX);
	}
	private boolean isRetardMovePlayer2(int newX, int newY) {
		return isAtTheEndPlayer2() || 
				!isMovementSouth(newX, newY) || 
				isMovementWestOrEast(newX, newY) || 
				isXDifferenceMoreThanOne(newX);
	}
	
	
}
