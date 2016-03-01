package gamepieces;

import static game.Gamepiece.isXAndYChanged;
import static game.Gamepiece.isXAndYEvenChange;

import game.*;

public class Queen extends Gamepiece{
	
	public Queen(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	public void move(int newX, int newY) {
		if (isRetardMove(x, y, newX, newY)) return;
		
		super.move(newX, newY);
		
	}
	private boolean isRetardMove(int x, int y, int newX, int newY){
		return (!isXAndYEvenChange(x, newX, y, newY)&&
				isXAndYChanged(x, newX, y, newY));
	}

}
