package pieces;

import game.*;

public class Queen extends Piece  {
	
	public Queen(int x, int y, Player player, char type) {
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
		return !isXAndYEvenChange(newX, newY) 
				&& isXAndYChanged(newX, newY);
	}

}
