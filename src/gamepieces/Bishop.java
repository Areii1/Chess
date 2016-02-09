package gamepieces;

import static game.MoveValidation.*;
import game.*;

public class Bishop extends Gamepiece {
	
	public Bishop(int x, int y, Player player) {
		super(x, y, player, 'D');
	}
	
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		super.move(newX, newY);
	}
	
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return !isXAndYEvenChange(x, newX, y, newY);
	}
}
