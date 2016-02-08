package gamepieces;

import game.*;

public class Bishop extends Gamepiece {
	
	Type type;
	
	/* Constructor for a bishop gamepiece
	 * 1. parameter row
	 * 2. parameter column
	 * 3. parameter Player
	 */
	
	public Bishop(int x, int y, Player player) {
		super(x, y, player);
		type = Type.BISHOP;
	}
}
