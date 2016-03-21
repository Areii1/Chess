package pieces;

import game.*;


public class King extends Piece {
	
	/**		Constructor
	 * Constructs a new King object.
	 * @param x
	 * @param y
	 * @param player
	 */
	public King(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	/**		Method isRetardMove
	 * Returns true if an illegal move is made.
	 * Returns false if it is a legal move.
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	public boolean isRetardMove(int newX, int newY) {
			if (isMovementOneNorth(newX, newY)
				|| isMovementOneSouth(newX, newY)
				|| isMovementOneWest(newX, newY)
				|| isMovementOneEast(newX, newY)
				|| isMovementOneNorthOneEast(newX, newY)
				|| isMovementOneNorthOneWest(newX, newY)
				|| isMovementOneSouthOneEast(newX, newY) 
				|| isMovementOneSouthOneWest(newX, newY)) return false;
		return true;
	}



	
	
}

