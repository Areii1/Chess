package game;
import java.util.ArrayList;
import gamepieces.*;
import static game.Gamepiece.*;

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
//PAWN
		if (gamepiece instanceof Pawn) {
			System.out.println("moving a pawn");
			if (isMovementOneOrTwoNorth(gamepiece.getX(),gamepiece.getY(), newX, newY)){
				System.out.println("pohjoinen");
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			if (isMovementOneOrTwoSouth(gamepiece.getX(),gamepiece.getY(), newX, newY)){
				System.out.println("etelä");
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
		}
//ROOK
		else if (gamepiece instanceof Rook) {
			System.out.println("moving a rook");
			// North
			if (isMovementNorth(gamepiece, newX, newY)) {
				for (int i = gamepiece.getY() + 1; i <= newY; i++) { 
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			
			// South
			if (isMovementSouth(gamepiece, newX, newY)) {
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}
			
			// West
			if (isMovementEast(gamepiece, newX, newY)) {
				for (int i = gamepiece.getX() + 1; i <= newX; i++) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
			
			// East
			if (isMovementWest(gamepiece, newX, newY)) {
				for (int i = gamepiece.getX() - 1; i >= newX; i--) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
		}
		
		
// BISHOP
		else if (gamepiece instanceof Bishop) {
			System.out.println("moving a bishop");
			// northwest
			// detect if movement is northwest
			if (isMovementNortheast(gamepiece, newX, newY)) {
				// check every position in the northwest path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southeast
			// detect if movement is southeast
			if (isMovementSouthwest(gamepiece, newX, newY)) {
				// check every position in the southeast path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// northeast
			// detect if movement is northeast
			if (isMovementNorthwest(gamepiece, newX, newY)) {
				// check every position in the northeast path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}
			
			// southwest
			// detect if movement is southwest
			if (isMovementSoutheast(gamepiece, newX, newY)) {
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
			System.out.println("moving a knight");
			// twoNorthOneEast
			// detect if movement is twoNorthOneEast
			if (isMovementTwoNorthOneEast(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoNorthOneWest
			// detect if movement is TwoNorthOneWest
			if (isMovementTwoNorthOneWest(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneNorthTwoEast
			// detect if movement is OneNorthTwoEast
			if (isMovementOneNorthTwoEast(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneNorthTwoEast
			// detect if movement is OneNorthTwoEast
			if (isMovementOneNorthTwoWest(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoSouthOneEast
			// detect if movement is TwoSouthOneEast
			if (isMovementTwoSouthOneEast(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// TwoSouthOneWest
			// detect if movement is TwoSouthOneWest
			if (isMovementTwoSouthOneWest(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneSouthTwoEast
			// detect if movement is OneSouthTwoEast
			if (isMovementOneSouthTwoEast(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
			// OneSouthTwoWest
			// detect if movement is OneSouthTwoWest
			if (isMovementOneSouthTwoWest(gamepiece.getX() ,gamepiece.getY() , newX, newY)){
				if (tileHasGamepiece(newX, newY))return;
			}
		}
		

// Queen or King	
		else if (gamepiece instanceof Queen || gamepiece instanceof King){
			// northwest
			// detect if movement is northwest
			if (isMovementNortheast(gamepiece, newX, newY)) {
				// check every position in the northwest path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}

			// southeast
			// detect if movement is southeast
			if (isMovementSouthwest(gamepiece, newX, newY)) {
				// check every position in the southeast path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}

			// northeast
			// detect if movement is northeast
			if (isMovementNorthwest(gamepiece, newX, newY)) {
				// check every position in the northeast path for an existing gamepiece.
				for (int i = gamepiece.getY() + 1; i <= newY; i++) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return;
					moveCounter++;
				}
			}

			// southwest
			// detect if movement is southwest
			if (isMovementSoutheast(gamepiece, newX, newY)) {
				// check every position in the southwest path for an existing gamepiece.
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					int moveCounter = 1;
					if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return;
					moveCounter++;
				}
			}
			// else, move the gamepiece to new coordinate
			// North
			if (isMovementNorth(gamepiece, newX, newY)) {
				for (int i = gamepiece.getY() + 1; i <= newY; i++) { 
					if (tileHasGamepiece(newX, i)) return;
				}
			}

			// South
			if (isMovementSouth(gamepiece, newX, newY)) {
				for (int i = gamepiece.getY() - 1; i >= newY; i--) {
					if (tileHasGamepiece(newX, i)) return;
				}
			}

			// West
			if (isMovementEast(gamepiece, newX, newY)) {
				for (int i = gamepiece.getX() + 1; i <= newX; i++) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}

			// East
			if (isMovementWest(gamepiece, newX, newY)) {
				for (int i = gamepiece.getX() - 1; i >= newX; i--) {
					if (tileHasGamepiece(i, newY)) return;
				}
			}
		}
		
		gamepiece.move(newX, newY);
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
	
	/**		Method startNewGame
	 * 
	 */
	public static void startNewGame(Chessboard chessboard){
		
		
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
	
		chessboard.addToBoard(pawn1);
		chessboard.addToBoard(pawn2);
		chessboard.addToBoard(pawn3);
		chessboard.addToBoard(pawn4);
		chessboard.addToBoard(pawn5);
		chessboard.addToBoard(pawn6);
		chessboard.addToBoard(pawn7);
		chessboard.addToBoard(pawn8);
		chessboard.addToBoard(king);
		chessboard.addToBoard(rook1);
		chessboard.addToBoard(rook2);
		chessboard.addToBoard(bishop1);
		chessboard.addToBoard(bishop2);
		chessboard.addToBoard(queen);
		chessboard.addToBoard(knight1);
		chessboard.addToBoard(knight2);
		
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
		
		chessboard.addToBoard(pawn1p);
		chessboard.addToBoard(pawn2p);
		chessboard.addToBoard(pawn3p);
		chessboard.addToBoard(pawn4p);
		chessboard.addToBoard(pawn5p);
		chessboard.addToBoard(pawn6p);
		chessboard.addToBoard(pawn7p);
		chessboard.addToBoard(pawn8p);
		chessboard.addToBoard(kingp);
		chessboard.addToBoard(rook1p);
		chessboard.addToBoard(rook2p);
		chessboard.addToBoard(bishop1p);
		chessboard.addToBoard(bishop2p);
		chessboard.addToBoard(queenp);
		chessboard.addToBoard(knight1p);
		chessboard.addToBoard(knight2p);
		
		chessboard.render();
	}
}
