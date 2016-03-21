package pieces;

import game.*;

public class Pawn extends Piece {
	
	/**		CONSTRUCTOR
	 * Constructor for a Pawn object, gives the pawn an (x,y) coordinate and defines the player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Pawn(int x, int y, Player player, char type) {
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
		if (player.getId() == 1) {
			return isAtTheEndPlayer1() 
					|| isMovementSouth(newX, newY)
					|| isMovementWestOrEast(newX, newY)
					|| isNorthMovementOverTwo(newX, newY)
					|| isMovementOverOneNorthOneEast(newX, newY)
					|| isMovementOverOneNorthOneWest(newX, newY);
		}
		else {
			return isAtTheEndPlayer2()
					|| isMovementNorth(newX, newY)
					|| isMovementWestOrEast(newX, newY)
					|| isSouthMovementOverTwo(newX, newY)
					|| isMovementOverOneSouthOneEast(newX, newY)
					|| isMovementOverOneSouthOneWest(newX, newY);
		} 

	}
}
