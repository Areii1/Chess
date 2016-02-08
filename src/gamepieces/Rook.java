package gamepieces;

import game.*;

public class Rook extends Gamepiece {
	
	public Rook(int x, int y, Player player) {
		super(x, y, player, 'b');
	}
	
	public void move(int newX, int newY) {
		if (isRetardMove(x, newX, y, newY)) return;
		
		super.move(newX, newY);
	}
	
	private boolean isXAndYChanged(int x, int newX, int y, int newY) {
		return x - newX != 0 && y - newY != 0;
	}
	
	private boolean isRetardMove(int x, int newX, int y, int newY) {
		return isXAndYChanged(x, newX, y, newY);
	}
}
