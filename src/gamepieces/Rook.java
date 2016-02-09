package gamepieces;

import static game.MoveValidation.*;
import game.*;

public class Rook extends Gamepiece {
	
	public Rook(int x, int y, Player player) {
		super(x, y, player, 'B');
	}
	
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		super.move(newX, newY);
	}
	
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return isXAndYChanged(x, newX, y, newY);
	}
}
