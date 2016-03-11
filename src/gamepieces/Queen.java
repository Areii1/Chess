package gamepieces;

import game.*;

public class Queen extends Gamepiece  {
	
	public Queen(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	
	public boolean isRetardMove(int newX, int newY) {
		return !isXAndYEvenChange(newX, newY) 
				&& isXAndYChanged(newX, newY);
	}

}
