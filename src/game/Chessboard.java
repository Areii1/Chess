package game;
import java.util.ArrayList;

public class Chessboard {
	
	ArrayList<Gamepiece> gamepieces;
	
	
	public Chessboard() {
		gamepieces = new ArrayList<Gamepiece>();
	}

	// Draw a chessboard
	public void render() {
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				System.out.print(" " + renderGamepiece(x,y) + " ");
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
}
