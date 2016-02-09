package game;
import java.util.ArrayList;
import gamepieces.*;

public class Chessboard {
	
	ArrayList<Gamepiece> gamepieces;
	
	
	public Chessboard() {
		gamepieces = new ArrayList<Gamepiece>();
	}

	// Draw a chessboard
	public void render() {
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				System.out.print(" " + renderGamepiece(x, y) + " ");
			}
			System.out.println("");
		}
	}
	
	public void addToBoard(Gamepiece gamepiece) {
		gamepieces.add(gamepiece);
	}
	
	private char renderGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return gamepiece.getType();
			}
		}
		return 'O';
	}
	
	public void moveGamepiece(Gamepiece gamepiece, int newX, int newY) {
		if (gamepiece instanceof Rook) {
			for (int i = gamepiece.getY() - 1; i >= newY; i--) { 
				if (tileHasGamepiece(newX, i)) {
					return;
				}
			}
		}
		
		if (tileHasGamepiece(newX, newY)) {
			
		}
		else {
			gamepiece.move(newX, newY);
		}
	}
	
	
	private boolean tileHasGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return true;
			}
		}
		return false;
	}
}
