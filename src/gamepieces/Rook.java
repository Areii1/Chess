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
	 * returns true if an illegal move was made, a rook can only move horizontally and vertically. Returns false if the move was legal.
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	public boolean isRetardMove(int newX, int newY) {
		return isXAndYChanged(newX, newY);
	}
}
