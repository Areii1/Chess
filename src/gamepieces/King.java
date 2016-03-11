package gamepieces;

import game.*;


public class King extends Gamepiece {
	
	/**		Constructor
	 * Constructs a new King object.
	 * @param x
	 * @param y
	 * @param player
	 */
	public King(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	
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

