package game;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import pieces.*;


public class Chessboard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean gameOver;
	
	ArrayList<Piece> pieces;

	/** 	
	 * Default constructor for Chessboard class, creates an empty ArrayList of piece type objects.
	 */
	public Chessboard() {
		pieces = new ArrayList<Piece>();
		gameOver = false;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	/** 	
	 * Draws a chessboard 
	*/
	public void render() {
		int rowCounter = 8;
		
		for (int y = 8; y >= 1; y--) {
			System.out.print(rowCounter + "  |");
			rowCounter--;
			for (int x = 1; x <= 8; x++) {
				System.out.print(" " + renderPiece(x, y) + " ");
			}
			System.out.println("");
		}
		System.out.println("   ________________________");
		System.out.println("     1  2  3  4  5  6  7  8");
		System.out.println("");
	}
	
	/**		
	 * adds a piece to pieces ArrayList
	 * @param piece
	 */
	public void addToBoard(Piece piece) {
		pieces.add(piece);
	}
	
	/**		
	 * If the given (x,y) coordinate matches, any of the pieces (x,y) coordinates it prints out the type of the piece on the board (for example 'A').
	 * @param x
	 * @param y
	 * @return char
	 */
	private char renderPiece(int x, int y) {
		for (Piece piece : pieces) {
			if (piece.getX() == x && piece.getY() == y) {
				return piece.getType();
			}
		}
		return 'o';
	}
	
	/**		
	 * Changes the (x,y) coordinate of a piece to a new coordinate (x,y), if and only if there are no existing pieces on that new coordinate
	 * or on the path to that new coordinate. The condition varies between pieces (a rook moves with a different path than a bishop for example).
	 * @param pieceX
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	public boolean movePiece(int pieceX, int pieceY, int newX, int newY) {
		Piece piece = findPiece(pieceX, pieceY);
		
		if (piece instanceof Pawn) {
			Pawn pawn = (Pawn) piece;
			if (!pawn.isRetardMove(newX, newY) && !isPawnMovementBlocked(pawn, newX, newY)) {
				return captureOrIgnoreOrMove(pawn, newX, newY);
			}
		}
		else if (piece instanceof Rook) {
			Rook rook = (Rook) piece;
			if (!rook.isRetardMove(newX, newY) && !isRookMovementBlocked(rook, newX, newY)) {
				return captureOrIgnoreOrMove(rook, newX, newY);
			}
		}
		else if (piece instanceof Bishop) {
			Bishop bishop = (Bishop) piece;
			if (!bishop.isRetardMove(newX, newY) && !isBishopMovementBlocked(bishop, newX, newY)) {
				return captureOrIgnoreOrMove(bishop, newX, newY);
			}
		}
		else if (piece instanceof Knight) {
			Knight knight = (Knight) piece;
			if (!knight.isRetardMove(newX, newY)) {
				return captureOrIgnoreOrMove(piece, newX, newY);
			}
		}
		else if (piece instanceof Queen) {
			Queen queen = (Queen) piece;
			if (!queen.isRetardMove(newX, newY) && !isQueenMovementBlocked(piece, newX, newY)) {
				return captureOrIgnoreOrMove(piece, newX, newY);
			}
		}
		else if (piece instanceof King) {
			King king = (King) piece;
			if (!king.isRetardMove(newX, newY)) {
				return captureOrIgnoreOrMove(piece, newX, newY);
			}
		}
		return false;
	}
	/** 
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isPawnMovementBlocked(Piece piece, int newX, int newY) {
		if (!piece.isMovementNorth(newX, newY) && !piece.isMovementSouth(newX, newY)) return false;
		if ((piece.isMovementOneOrTwoNorth(newX, newY) && !isNorthMovementBlocked(piece, newX, newY))
			|| (piece.isMovementOneOrTwoSouth(newX, newY) && !isSouthMovementBlocked(piece, newX, newY))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isRookMovementBlocked(Piece piece, int newX, int newY) {
		if ((piece.isMovementNorth(newX, newY) && !isNorthMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementSouth(newX, newY) && !isSouthMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementEast(newX, newY) && !isEastMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementWest(newX, newY) && !isWestMovementBlocked(piece, newX, newY))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isBishopMovementBlocked(Piece piece, int newX, int newY) {
		if 	((piece.isMovementNortheast(newX, newY) && !isNorthEastMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementSouthwest(newX, newY) && !isSouthWestMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementNorthwest(newX, newY) && !isNorthWestMovementBlocked(piece, newX, newY) 
			|| (piece.isMovementSoutheast(newX, newY) && !isSouthEastMovementBlocked(piece, newX, newY)))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isQueenMovementBlocked(Piece piece, int newX, int newY) {
		if (piece.isMovementNortheast(newX, newY) && !isNorthEastMovementBlocked(piece, newX, newY) 
			|| (piece.isMovementSouthwest(newX, newY) && !isSouthWestMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementNorthwest(newX, newY) && !isNorthWestMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementSoutheast(newX, newY) && !isSouthEastMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementNorth(newX, newY) && !isNorthMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementSouth(newX, newY) && !isSouthMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementEast(newX, newY) && !isEastMovementBlocked(piece, newX, newY)) 
			|| (piece.isMovementWest(newX, newY) && !isWestMovementBlocked(piece, newX, newY))) return false;
		return true;
	}
	
	/**		Method tileHaspiece
	 * Loops through the pieces ArraList (which includes every piece) and checks if any piece's coordinate matches the parameter coordinate.
	 * returns true if any coordinates match, returns false if none match.
	 * @param x
	 * @param y
	 * @return boolean
	 */
	private boolean tileHasPiece(int x, int y) {
		for (Piece piece : pieces) {
			if (piece.getX() == x && piece.getY() == y) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method tests are there an opponent in the new coordinates.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean hasTileOpponent(Piece piece, int newX, int newY) {
		Piece possibleEnemy = findPiece(newX, newY);
		
		if (piece.getPlayer().getId() != possibleEnemy.getPlayer().getId()) return true;
		return false;
	}
	/**
	 * Method tests diagonal movements of the pawn.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isPawnMovingDiagonally(Piece piece, int newX, int newY) {
		return piece instanceof Pawn
			&& ((piece.isMovementNortheast(newX, newY))
			|| (piece.isMovementNorthwest(newX, newY))
			|| (piece.isMovementSoutheast(newX, newY))
			|| (piece.isMovementSouthwest(newX, newY)));
	}
	/**
	 * Method tests is the tile empty and if there is an opponent and is the piece pawn.
	 * If the piece is pawn it can remove opponent from tile if pawn rules allow it.
	 * If the piece is not pawn it can remove the opponent right away.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean captureOrIgnoreOrMove(Piece piece, int newX, int newY) {
		if (isTileEmpty(newX, newY)) {
			if (isPawnMovingDiagonally(piece, newX, newY)) {
				return false;
			}
			piece.move(newX, newY);
			render();
			return true;
		}
		else if (hasTileOpponent(piece, newX, newY)) {
			if (piece instanceof Pawn) {
				if (!piece.isMovementOneOrTwoNorth(newX, newY) 
					&& !piece.isMovementOneOrTwoSouth(newX, newY)
					&& (!(((piece.getPlayer().getId() == 1 && piece.isMovementOneSouthOneEast(newX, newY)) 
					|| (piece.getPlayer().getId() == 1 && piece.isMovementOneSouthOneWest(newX, newY)))
					|| ((piece.getPlayer().getId() == 2 && piece.isMovementOneNorthOneEast(newX, newY)) 
					|| (piece.getPlayer().getId() == 2 && piece.isMovementOneNorthOneWest(newX, newY)))))) {
					
					deletePiece(newX, newY);
					piece.move(newX, newY);
					render();
					return true;
				}
			}
			else {
				deletePiece(newX, newY);
				piece.move(newX, newY);
				render();
				return true;
			}
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthMovementBlocked(Piece piece, int newX, int newY) {
		for (int i = piece.getY() + 1; i < newY; i++) { 
			if (tileHasPiece(newX, i)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthMovementBlocked(Piece piece, int newX, int newY) {
		for (int i = piece.getY() - 1; i > newY; i--) {
			if (tileHasPiece(newX, i)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isWestMovementBlocked(Piece piece, int newX, int newY) {
		for (int i = piece.getX() - 1; i > newX; i--) {
			if (tileHasPiece(i, newY)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isEastMovementBlocked(Piece piece, int newX, int newY) {
		for (int i = piece.getX() + 1; i < newX; i++) {
			if (tileHasPiece(i, newY)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthEastMovementBlocked(Piece piece, int newX, int newY) {
		int moveCounter = 1;
		for (int i = piece.getY() + 1; i < newY; i++) {
			if (tileHasPiece(piece.getX() + moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthWestMovementBlocked(Piece piece, int newX, int newY) {
		int moveCounter = 1;
		for (int i = piece.getY() + 1; i < newY; i++) {
			if (tileHasPiece(piece.getX() - moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthWestMovementBlocked(Piece piece, int newX, int newY) {
		int moveCounter = 1;
		for (int i = piece.getY() - 1; i > newY; i--) {
			if (tileHasPiece(piece.getX() - moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthEastMovementBlocked(Piece piece, int newX, int newY) {
		int moveCounter = 1;
		for (int i = piece.getY() - 1; i > newY; i--) {
			if (tileHasPiece(piece.getX() + moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/** 	
	 * Loops through the pieces' ArrayList (which includes every piece) 
	 * and checks if any piece coordinates matches with the coordinates in the parameter.
	 * returns the found piece, if not found then return null
	 * @param x
	 * @param y
	 * @return
	 */
	public Piece findPiece(int x, int y) {
		for (Piece piece : pieces) {
			if (piece.getX() == x && piece.getY() == y) {
				return piece;
			}
		}
		return null;
	}
	/**
	 * Method tests is the tile empty.
	 * @param tileX
	 * @param tileY
	 * @return boolean
	 */
	private boolean isTileEmpty(int tileX, int tileY) {
		return findPiece(tileX, tileY) == null;
	}
	/**
	 * Checks the pieces' ArrayList if there are the same coordinates than the parameter coordinates.
	 * If the coordinates are the same it will remove object from the list.
	 * @param x
	 * @param y
	 */
	public void deletePiece(int x, int y) {
		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				if (isPieceKing(pieces.get(i))) {
					gameOver = true;
				}
				pieces.remove(i);
			}
		}
	}
	/**
	 * Method deletes the ArrayList.
	 */
	public void deleteAllPieces() {
		for (Piece piece : pieces) {
			pieces.remove(piece);
		}
	}
	/**
	 * Method tests is the piece a king.
	 * @param piece
	 * @return
	 */
	private boolean isPieceKing(Piece piece) {
		return piece instanceof King;
	}
	
	/**		Method startNewGame
	 * Method starts a new game and creates objects for the players and the pieces.
	 * Method adds the pieces to the chessboard.
	 */
	public void startNewGame() {
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
		Queen queen = new Queen(5, 1, player1, 'Q');
		Knight knight1 = new Knight(2, 1, player1, 'N');
		Knight knight2 = new Knight(7, 1, player1, 'N'); 
	
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
		Queen queenp = new Queen(5, 8, player2, 'q');
		Knight knight1p = new Knight(2, 8, player2, 'n');
		Knight knight2p = new Knight(7, 8, player2, 'n');
		
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
	
	public void save() {
		saveGame(pieces);
	}
	/**
	 * Method gets a parameter from the driver class and uses the startNewGame or load methods.
	 * @param a
	 */
	public void newGame(int a) {
		if (a == 1) {
			startNewGame();
		}
		if (a == 2) {
			load();
		}
	}
	
	public void load() {
		pieces = loadGame();
	}
	/**
	 * Method uses a serializable interface to save the pieces from the ArrayList to file.
	 * Method has an IOException.
	 * @param object
	 */
	public static void saveGame(ArrayList<Piece> object) {
		try {
			FileOutputStream fos = new FileOutputStream("Test.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println("Chessboard is saved in Test.ser");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/**
	 * Method uses a serializable interface to load the pieces from the file.
	 * Method has an IOException and a ClassNotFoundException. 
	 * @return object
	 */
	public static ArrayList<Piece> loadGame() {
		ArrayList<Piece> object = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("Test.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = (ArrayList<Piece>) ois.readObject();
			ois.close();
			fis.close();
			return object;
		}
		catch (IOException i) {
			i.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}	
}
