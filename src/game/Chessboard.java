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
				if (tileHasGamepiece(x, y)) {
					System.out.print(" X ");
				}
				else {
					System.out.print(" O ");
				}
			}
			System.out.println("");
		}
	}
	
	public void addToBoard(Gamepiece gamepiece) {
		gamepieces.add(gamepiece);
	}
	
	private boolean tileHasGamepiece(int x, int y) {
		boolean tilehasGamepiece = false;
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				tilehasGamepiece = true;
			}
		}
		return tilehasGamepiece;
	}
}
