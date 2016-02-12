package game;
import java.util.ArrayList;
import gamepieces.*;
import static game.MoveValidation.*;

public class Chessboard {
	
	ArrayList<Gamepiece> gamepieces;
	
	
	/** 	Default constructor
	 * Default constructor for Chessboard class, creates an empty ArrayList of Gamepiece type objects.
	 */
	public Chessboard() {
		gamepieces = new ArrayList<Gamepiece>();
	}

	
	/** 	Method render
	 * Draws a chessboard, searches every (x, y) coordinate (from 1 to 8) for a gamepiece. If the gamepieces ArrayList has a gamepiece on a given (x, y) coordinate,
	 * it prints out the type of the gamepiece on the given coordinate. If no gamepiece is present on a given coordinate, the method prints an empty 'o' on the spot.
	 * A = PAWN, B = ROOK, C = KNIGHT, D = BISHOP, E = KING, F = QUEEN.
	 * no parameters
	*/
	public void render() {
		int rowCounter = 8;
		
		
		for (int y = 8; y >= 1; y--) {
			System.out.print(rowCounter + "  |");
			rowCounter--;
			for (int x = 1; x <= 8; x++) {
				
				System.out.print(" " + renderGamepiece(x, y) + " ");
				
			}
			System.out.println("");
		}
		System.out.println("   ________________________");
		System.out.println("     1  2  3  4  5  6  7  8");
		System.out.println("");
	}
	
	/**		Method addToBoard
	 * adds a gamepiece to gamepieces ArrayList
	 * @param gamepiece
	 */
	public void addToBoard(Gamepiece gamepiece) {
		gamepieces.add(gamepiece);
	}
	
	
	/**		Method renderGamepiece
	 * If the given (x,y) coordinate matches, any of the gamepieces (x,y) coordinates it prints out the type of the gamepiece on the board (for example 'A').
	 * @param x
	 * @param y
	 * @return
	 */
	private char renderGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return gamepiece.getType();
			}
		}
		return 'o';
	}
	
	/**		Method moveGamepiece
	 * Changes the (x,y) coordinate of a gamepiece to a new coordinate (x,y), if and only if there are no existing gamepieces on that new coordinate
	 * or on the path to that new coordinate. The condition varies between gamepieces (a rook moves with a different path than a bishop for example).
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 */
	public void moveGamepiece(Gamepiece gamepiece, int newX, int newY) {
//		PAWN
		if (gamepiece instanceof Pawn) {
			for (int i = gamepiece.getY() + 1; i <= newY; i++) {
				if (tileHasGamepiece(newX, i)) return;
			}
		}
//		ROOK
		if (gamepiece instanceof Rook) {
			
			// upwards
			for (int i = gamepiece.getY() + 1; i <= newY; i++) { 
				if (tileHasGamepiece(newX, i)) return;
			}
			
			// downwards
			for (int i = gamepiece.getY() - 1; i >= newY; i--) {
				if (tileHasGamepiece(newX, i)) return;
			}
			
			// rightwards
			for (int i = gamepiece.getX() + 1; i <= newX; i++) {
				if (tileHasGamepiece(i, newY)) return;
			}
			
			// leftwards
			for (int i = gamepiece.getX() - 1; i >= newX; i--) {
				if (tileHasGamepiece(i, newY)) return;
			}
		}
		// BISHOP
		else if (gamepiece instanceof Bishop) {
			// northwest
			// detect if movement is northwest
			if (isMovementNorthwest(gamepiece, newX, newY)) {
				// check every position in the northwest path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southeast
			// detect if movement is southeast
			if (isMovementSoutheast(gamepiece, newX, newY)) {
				// check every position in the southeast path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// northeast
			// detect if movement is northeast
			if (isMovementNortheast(gamepiece, newX, newY)) {
				// check every position in the northeast path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southwest
			// detect if movement is southwest
			if (isMovementSouthwest(gamepiece, newX, newY)) {
				// check every position in the southwest path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
		// else, move the gamepiece to new coordinate
		gamepiece.move(newX, newY);
	}
}
	
	/**		Method tileHasGamepiece
	 * Loops through the gamepieces ArraList (which includes every gamepiece) and checks if any gamepiece's coordinate matches the parameter coordinate.
	 * returns true if any coordinates match, returns false if none match.
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean tileHasGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
}
