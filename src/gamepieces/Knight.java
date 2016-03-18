package gamepieces;

import game.*;


public class Knight extends Gamepiece {
	
	/**		CONSTRUCTOR
	 * Constructor for a Knight object, gives the Knight a (x,y) coordinate and assigns its player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Knight(int x, int y, Player player, char type) {
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
		if (isMovementTwoNorthOneWest(newX, newY)
			|| isMovementTwoNorthOneEast(newX, newY) 
			|| isMovementOneNorthTwoWest(newX, newY) 
			|| isMovementOneNorthTwoEast(newX, newY) 
			|| isMovementTwoSouthOneWest(newX, newY) 
			|| isMovementTwoSouthOneEast(newX, newY) 
			|| isMovementOneSouthTwoWest(newX, newY) 
			|| isMovementOneSouthTwoEast(newX, newY)) return false;
		return true;
	}
}