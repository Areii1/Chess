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
	
	
	/**		Method move
	 * Changes the (x,y) coordinate of the rook if the move is not retarded.
	 */
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		super.move(newX, newY);
	}
	
	
	/**		Method isRetardMove
	 * returns true if an illegal move was made, a rook can only move horizontally and vertically. Returns false if the move was legal.
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return isXAndYChanged(x, newX, y, newY);
	}
}
