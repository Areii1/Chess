package gamepieces;

import static game.MoveValidation.isXAndYChanged;
import static game.MoveValidation.isXAndYEvenChange;

import game.*;

public class Queen extends Gamepiece{
	
	public Queen(int x, int y, Player player) {
		super(x, y, player, 'Q');
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
