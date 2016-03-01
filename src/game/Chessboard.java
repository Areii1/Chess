package game;
import java.util.ArrayList;
import gamepieces.*;

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
	public void moveGamepiece(int gamepieceX,int gamepieceY, int newX, int newY) {
		Gamepiece gamepiece = findGamepiece(gamepieceX, gamepieceY);
		
//PAWN
		if (gamepiece instanceof Pawn) {
			if (gamepiece.isMovementOneOrTwoNorth(gamepiece.getX(),gamepiece.getY(), newX, newY)){
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			if (gamepiece.isMovementOneOrTwoSouth(gamepiece.getX(),gamepiece.getY(), newX, newY)){
				System.out.println("etelä");
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
		}
//ROOK
		else if (gamepiece instanceof Rook) {
			// North
			if (gamepiece.isMovementNorth(newX, newY)) {
				for (int i = gamepiece.getY() + 1; i <= newY; i++) { 
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			
			// South
			if (gamepiece.isMovementSouth(newX, newY)) {
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			
			// West
			if (gamepiece.isMovementEast(newX, newY)) {
				for (int i = gamepiece.getX() + 1; i <= newX; i++) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
			
			// East
			if (gamepiece.isMovementWest(newX, newY)) {
				for (int i = gamepiece.getX() - 1; i >= newX; i--) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
		}
		
		
// BISHOP
		else if (gamepiece instanceof Bishop) {
			// northwest
			// detect if movement is northwest
			if (gamepiece.isMovementNortheast(newX, newY)) {
				// check every position in the northwest path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southeast
			// detect if movement is southeast
			if (gamepiece.isMovementSouthwest(newX, newY)) {
				// check every position in the southeast path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// northeast
			// detect if movement is northeast
			if (gamepiece.isMovementNorthwest(newX, newY)) {
				// check every position in the northeast path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southwest
			// detect if movement is southwest
			if (gamepiece.isMovementSoutheast(newX, newY)) {
				// check every position in the southwest path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
		// else, move the gamepiece to new coordinate
		}
// Knight		
		else if (gamepiece instanceof Knight) {
			// twoNorthOneEast
			// detect if movement is twoNorthOneEast
			if (gamepiece.isMovementTwoNorthOneEast(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoNorthOneWest
			// detect if movement is TwoNorthOneWest
			if (gamepiece.isMovementTwoNorthOneWest(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneNorthTwoEast
			// detect if movement is OneNorthTwoEast
			if (gamepiece.isMovementOneNorthTwoEast(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneNorthTwoEast
			// detect if movement is OneNorthTwoEast
			if (gamepiece.isMovementOneNorthTwoWest(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoSouthOneEast
			// detect if movement is TwoSouthOneEast
			if (gamepiece.isMovementTwoSouthOneEast(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoSouthOneWest
			// detect if movement is TwoSouthOneWest
			if (gamepiece.isMovementTwoSouthOneWest(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneSouthTwoEast
			// detect if movement is OneSouthTwoEast
			if (gamepiece.isMovementOneSouthTwoEast(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneSouthTwoWest
			// detect if movement is OneSouthTwoWest
			if (gamepiece.isMovementOneSouthTwoWest(newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
		}
		

// Queen or King	
		else if (gamepiece instanceof Queen || gamepiece instanceof King){
			// northwest
			// detect if movement is northwest
			if (gamepiece.isMovementNortheast(newX, newY)) {
				// check every position in the northwest path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}

			// southeast
			// detect if movement is southeast
			if (gamepiece.isMovementSouthwest(newX, newY)) {
				// check every position in the southeast path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}

			// northeast
			// detect if movement is northeast
			if (gamepiece.isMovementNorthwest(newX, newY)) {
				// check every position in the northeast path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}

			// southwest
			// detect if movement is southwest
			if (gamepiece.isMovementSoutheast(newX, newY)) {
				// check every position in the southwest path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
			// else, move the gamepiece to new coordinate
			// North
			if (gamepiece.isMovementNorth(newX, newY)) {
				for (int i = gamepiece.getY() + 1; i <= newY; i++) { 
					if (tileHasGamepiece(newX, i)) return;
				}
			}

			// South
			if (gamepiece.isMovementSouth(newX, newY)) {
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}

			// West
			if (gamepiece.isMovementEast(newX, newY)) {
				for (int i = gamepiece.getX() + 1; i <= newX; i++) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}

			// East
			if (gamepiece.isMovementWest(newX, newY)) {
				for (int i = gamepiece.getX() - 1; i >= newX; i--) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
		}
		
		gamepiece.move(newX, newY);
		render();
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
	
	
	
	/** 	Method findGamepiece
	 * Loops through the gamepieces ArraList (which includes every gamepiece) and checks if any gamepiece's coordinate matches the parameter coordinate.
	 * returns the found gamepiece, if not found then return null
	 * @param x
	 * @param y
	 * @return
	 */
	public Gamepiece findGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return gamepiece;
			}
		}
		return null;
	}
	
	/**		Method startNewGame
	 * 
	 */
	public void startNewGame(){
		
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		Pawn pawn1 = new Pawn(1, 2, player1, 'P');
		Pawn pawn2 = new Pawn(2, 2, player1, 'P');
		Pawn pawn3 = new Pawn(3, 2, player1, 'P');
		Pawn pawn4 = new Pawn(4, 2, player1, 'P');
		Pawn pawn5 = new Pawn(5, 2, player1, 'P');
		Pawn pawn6 = new Pawn(6, 2, player1, 'P');
		Pawn pawn7 = new Pawn(7, 2, player1, 'P');
		Pawn pawn8 = new Pawn(8, 2, player1, 'P');
		Rook rook1 = new Rook(1, 1, player1, 'T');
		Rook rook2 = new Rook(8, 1, player1, 'T');
		King king = new King(4, 1, player1, 'K');
		Bishop bishop1 = new Bishop(3, 1, player1, 'B');
		Bishop bishop2 = new Bishop(6, 1, player1, 'B');
		Queen queen = new Queen(5,1,player1, 'Q');
		Knight knight1 = new Knight(2,1,player1, 'N');
		Knight knight2 = new Knight(7,1,player1, 'N'); 
	
		addToBoard(pawn1);
		addToBoard(pawn2);
		addToBoard(pawn3);
		addToBoard(pawn4);
		addToBoard(pawn5);
		addToBoard(pawn6);
		addToBoard(pawn7);
		addToBoard(pawn8);
		addToBoard(king);
		addToBoard(rook1);
		addToBoard(rook2);
		addToBoard(bishop1);
		addToBoard(bishop2);
		addToBoard(queen);
		addToBoard(knight1);
		addToBoard(knight2);
		
		Pawn pawn1p = new Pawn(1, 7, player2, 'p');
		Pawn pawn2p = new Pawn(2, 7, player2, 'p');
		Pawn pawn3p = new Pawn(3, 7, player2, 'p');
		Pawn pawn4p = new Pawn(4, 7, player2, 'p');
		Pawn pawn5p = new Pawn(5, 7, player2, 'p');
		Pawn pawn6p = new Pawn(6, 7, player2, 'p');
		Pawn pawn7p = new Pawn(7, 7, player2, 'p');
		Pawn pawn8p = new Pawn(8, 7, player2, 'p');
		Rook rook1p = new Rook(1, 8, player2, 't');
		Rook rook2p = new Rook(8, 8, player2, 't');
		King kingp = new King(4, 8, player2, 'k');
		Bishop bishop1p = new Bishop(3, 8, player2, 'b');
		Bishop bishop2p = new Bishop(6, 8, player2, 'b');
		Queen queenp = new Queen(5,8,player2, 'q');
		Knight knight1p = new Knight(2,8,player2, 'n');
		Knight knight2p = new Knight(7,8,player2, 'n');
		
		addToBoard(pawn1p);
		addToBoard(pawn2p);
		addToBoard(pawn3p);
		addToBoard(pawn4p);
		addToBoard(pawn5p);
		addToBoard(pawn6p);
		addToBoard(pawn7p);
		addToBoard(pawn8p);
		addToBoard(kingp);
		addToBoard(rook1p);
		addToBoard(rook2p);
		addToBoard(bishop1p);
		addToBoard(bishop2p);
		addToBoard(queenp);
		addToBoard(knight1p);
		addToBoard(knight2p);
		
		render();
	}
}
