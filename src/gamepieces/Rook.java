package gamepieces;

import game.*;

public class Rook extends Gamepiece {
	
	
	/**		CONSTRUCTOR
	 * Constructor for a Rook object, gives the rook an (x,y) coordinate and assigns its player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Rook(int x, int y, Player player, char type) {
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
		return isXAndYChanged(newX, newY);
	}
}
