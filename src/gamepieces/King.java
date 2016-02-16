package gamepieces;

import static game.MoveValidation.*;
import game.*;


public class King extends Gamepiece {
	
	/**		Constructor
	 * Constructs a new King object.
	 * @param x
	 * @param y
	 * @param player
	 */
	public King(int x, int y, Player player) {
		super(x, y, player, 'K');
	}

	
	public void move(int newX, int newY) {
		if (isRetardMove(x, y, newX, newY)) return;
		
		super.move(newX, newY);
		
	}
	
	private boolean isRetardMove(int x, int y, int newX, int newY) {
			if (isMovementOneNorth(x, y, newX, newY)) return false;
		return true;
	}



	
	
}

