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
				
				for (Gamepiece gamepiece : gamepieces) {
					if (gamepiece.getX() == x && gamepiece.getY() == y) {
						System.out.print(" 0 ");
					} 
					else {
						System.out.print(" X ");
					}
				}
			}
			System.out.println("");
		}
	}
	
	public void addToBoard(Gamepiece gamepiece) {
		gamepieces.add(gamepiece);
	}
}
