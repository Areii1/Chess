package gamepieces;

import game.*;

public class Bishop extends Gamepiece {
	/**		CONSTRUCTOR
	 * Constructor for a Bishop object, gives the bishop an (x,y) coordinate and assigns its player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Bishop(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	
	/**		Method isRetardMove
	 * returns true if an illegal move was made. 
	 * Returns false if the move was legal. 
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	public boolean isRetardMove(int newX, int newY) {
		return !isXAndYEvenChange(newX, newY);
	}
}
