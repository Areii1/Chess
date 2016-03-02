package gamepieces;

import game.*;

public class Queen extends Gamepiece{
	
	public Queen(int x, int y, Player player, char type) {
		super(x, y, player, type);
	}
	public void move(int newX, int newY) {
		if (isRetardMove(newX, newY)) return;
		
		super.move(newX, newY);
		
	}
	private boolean isRetardMove(int newX, int newY){
		return (!isXAndYEvenChange(newX, newY)&&
				isXAndYChanged(newX, newY));
	}

}
