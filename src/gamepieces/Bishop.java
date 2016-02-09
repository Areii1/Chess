package gamepieces;

import static game.MoveValidation.*;
import game.*;

public class Bishop extends Gamepiece {
	
	
	/**		CONSTRUCTOR
	 * Constructor for a Bishop object, gives the bishop an (x,y) coordinate and assigns its player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Bishop(int x, int y, Player player) {
		super(x, y, player, 'D');
	}
	
	
	/**		Method move
	 * Changes the (x,y) coordinate of the bishop if the move is not retarded.
	 */
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		super.move(newX, newY);
	}
	
	
	/**		Method isRetardMove
	 * returns true if an illegal move was made, a bishop can only move diagonally. Returns false if the move was legal. 
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return !isXAndYEvenChange(x, newX, y, newY);
	}
}
