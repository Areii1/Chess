package gamepieces;

import game.*;
import static game.MoveValidation.*;

public class Knight extends Gamepiece {
	
	/**		CONSTRUCTOR
	 * Constructor for a Knight object, gives the Knight a (x,y) coordinate and assigns its player.
	 * @param x
	 * @param y
	 * @param player
	 */
	public Knight(int x, int y, Player player) {
		super(x, y, player, 'N');
	}
	
	
	public void move(int newX, int newY) {
		if (isRetardMove(x, y, newX, newY)) return;
		
		super.move(newX, newY);
	}
	
	public boolean isRetardMove(int x, int y, int newX, int newY) {
		if (isMovementTwoNorthOneWest(x, y, newX, newY)	|| 
			isMovementTwoNorthOneEast(x, y, newX, newY) ||
			isMovementOneNorthTwoWest(x, y, newX, newY) ||
			isMovementOneNorthTwoEast(x, y, newX, newY) ||
			isMovementTwoSouthOneWest(x, y, newX, newY) ||
			isMovementTwoSouthOneEast(x, y, newX, newY) ||
			isMovementOneSouthTwoWest(x, y, newX, newY) ||
			isMovementOneSouthTwoEast(x, y, newX, newY)) return false;
		return true;
	}
}