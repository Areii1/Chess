package game;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import gamepieces.*;


public class Chessboard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean gameOver;
	
	ArrayList<Gamepiece> gamepieces;

	/** 	
	 * Default constructor for Chessboard class, creates an empty ArrayList of Gamepiece type objects.
	 */
	public Chessboard() {
		gamepieces = new ArrayList<Gamepiece>();
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
				System.out.print(" " + renderGamepiece(x, y) + " ");
			}
			System.out.println("");
		}
		System.out.println("   ________________________");
		System.out.println("     1  2  3  4  5  6  7  8");
		System.out.println("");
	}
	
	/**		
	 * adds a gamepiece to gamepieces ArrayList
	 * @param gamepiece
	 */
	public void addToBoard(Gamepiece gamepiece) {
		gamepieces.add(gamepiece);
	}
	
	/**		
	 * If the given (x,y) coordinate matches, any of the gamepieces (x,y) coordinates it prints out the type of the gamepiece on the board (for example 'A').
	 * @param x
	 * @param y
	 * @return char
	 */
	private char renderGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return gamepiece.getType();
			}
		}
		return 'o';
	}
	
	/**		
	 * Changes the (x,y) coordinate of a gamepiece to a new coordinate (x,y), if and only if there are no existing gamepieces on that new coordinate
	 * or on the path to that new coordinate. The condition varies between gamepieces (a rook moves with a different path than a bishop for example).
	 * @param gamepieceX
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	public boolean moveGamepiece(int gamepieceX, int gamepieceY, int newX, int newY) {
		Gamepiece gamepiece = findGamepiece(gamepieceX, gamepieceY);
		
		if (gamepiece instanceof Pawn) {
			Pawn pawn = (Pawn) gamepiece;
			if (!pawn.isRetardMove(newX, newY) && !isPawnMovementBlocked(pawn, newX, newY)) {
				return captureOrIgnoreOrMove(pawn, newX, newY);
			}
		}
		else if (gamepiece instanceof Rook) {
			Rook rook = (Rook) gamepiece;
			if (!rook.isRetardMove(newX, newY) && !isRookMovementBlocked(rook, newX, newY)) {
				return captureOrIgnoreOrMove(rook, newX, newY);
			}
		}
		else if (gamepiece instanceof Bishop) {
			Bishop bishop = (Bishop) gamepiece;
			if (!bishop.isRetardMove(newX, newY) && !isBishopMovementBlocked(bishop, newX, newY)) {
				return captureOrIgnoreOrMove(bishop, newX, newY);
			}
		}
		else if (gamepiece instanceof Knight) {
			Knight knight = (Knight) gamepiece;
			if (!knight.isRetardMove(newX, newY)) {
				return captureOrIgnoreOrMove(gamepiece, newX, newY);
			}
		}
		else if (gamepiece instanceof Queen) {
			Queen queen = (Queen) gamepiece;
			if (!queen.isRetardMove(newX, newY) && !isQueenMovementBlocked(gamepiece, newX, newY)) {
				return captureOrIgnoreOrMove(gamepiece, newX, newY);
			}
		}
		else if (gamepiece instanceof King) {
			King king = (King) gamepiece;
			if (!king.isRetardMove(newX, newY)) {
				return captureOrIgnoreOrMove(gamepiece, newX, newY);
			}
		}
		return false;
	}
	/** 
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isPawnMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		if (!gamepiece.isMovementNorth(newX, newY) && !gamepiece.isMovementSouth(newX, newY)) return false;
		if ((gamepiece.isMovementOneOrTwoNorth(newX, newY) && !isNorthMovementBlocked(gamepiece, newX, newY))
			|| (gamepiece.isMovementOneOrTwoSouth(newX, newY) && !isSouthMovementBlocked(gamepiece, newX, newY))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isRookMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		if ((gamepiece.isMovementNorth(newX, newY) && !isNorthMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementSouth(newX, newY) && !isSouthMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementEast(newX, newY) && !isEastMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementWest(newX, newY) && !isWestMovementBlocked(gamepiece, newX, newY))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isBishopMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		if ((gamepiece.isMovementNortheast(newX, newY) && !isNorthEastMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementSouthwest(newX, newY) && !isSouthWestMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementNorthwest(newX, newY) && !isNorthWestMovementBlocked(gamepiece, newX, newY) 
			|| (gamepiece.isMovementSoutheast(newX, newY) && !isSouthEastMovementBlocked(gamepiece, newX, newY)))) return false;
		return true;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isQueenMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		if (gamepiece.isMovementNortheast(newX, newY) && !isNorthEastMovementBlocked(gamepiece, newX, newY) 
			|| (gamepiece.isMovementSouthwest(newX, newY) && !isSouthWestMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementNorthwest(newX, newY) && !isNorthWestMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementSoutheast(newX, newY) && !isSouthEastMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementNorth(newX, newY) && !isNorthMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementSouth(newX, newY) && !isSouthMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementEast(newX, newY) && !isEastMovementBlocked(gamepiece, newX, newY)) 
			|| (gamepiece.isMovementWest(newX, newY) && !isWestMovementBlocked(gamepiece, newX, newY))) return false;
		return true;
	}
	
	/**		Method tileHasGamepiece
	 * Loops through the gamepieces ArraList (which includes every gamepiece) and checks if any gamepiece's coordinate matches the parameter coordinate.
	 * returns true if any coordinates match, returns false if none match.
	 * @param x
	 * @param y
	 * @return boolean
	 */
	private boolean tileHasGamepiece(int x, int y) {
		for (Gamepiece gamepiece : gamepieces) {
			if (gamepiece.getX() == x && gamepiece.getY() == y) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method tests are there an opponent in the new coordinates.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean hasTileOpponent(Gamepiece gamepiece, int newX, int newY) {
		Gamepiece possibleEnemy = findGamepiece(newX, newY);
		
		if (gamepiece.getPlayer().getId() != possibleEnemy.getPlayer().getId()) return true;
		return false;
	}
	/**
	 * Method tests diagonal movements of the pawn.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isPawnMovingDiagonally(Gamepiece gamepiece, int newX, int newY) {
		return gamepiece instanceof Pawn
			&& ((gamepiece.isMovementNortheast(newX, newY))
			|| (gamepiece.isMovementNorthwest(newX, newY))
			|| (gamepiece.isMovementSoutheast(newX, newY))
			|| (gamepiece.isMovementSouthwest(newX, newY)));
	}
	/**
	 * Method tests is the tile empty and if there is an opponent and is the gamepiece pawn.
	 * If the gamepiece is pawn it can remove opponent from tile if pawn rules allow it.
	 * If the gamepiece is not pawn it can remove the opponent right away.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean captureOrIgnoreOrMove(Gamepiece gamepiece, int newX, int newY) {
		if (isTileEmpty(newX, newY)) {
			if (isPawnMovingDiagonally(gamepiece, newX, newY)) {
				return false;
			}
			gamepiece.move(newX, newY);
			render();
			return true;
		}
		else if (hasTileOpponent(gamepiece, newX, newY)) {
			if (gamepiece instanceof Pawn) {
				if (!gamepiece.isMovementOneOrTwoNorth(newX, newY) && !gamepiece.isMovementOneOrTwoSouth(newX, newY)) {
					deleteGamepiece(newX, newY);
					gamepiece.move(newX, newY);
					render();
					return true;
				}
			}
			else {
				deleteGamepiece(newX, newY);
				gamepiece.move(newX, newY);
				render();
				return true;
			}
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() + 1; i < newY; i++) { 
			if (tileHasGamepiece(newX, i)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() - 1; i > newY; i--) {
			if (tileHasGamepiece(newX, i)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isWestMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getX() - 1; i > newX; i--) {
			if (tileHasGamepiece(i, newY)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isEastMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getX() + 1; i < newX; i++) {
			if (tileHasGamepiece(i, newY)) return true;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthEastMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() + 1; i < newY; i++) {
			int moveCounter = 1;
			if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isNorthWestMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() + 1; i < newY; i++) {
			int moveCounter = 1;
			if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthWestMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() - 1; i > newY; i--) {
			int moveCounter = 1;
			if (tileHasGamepiece(gamepiece.getX() - moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/**
	 * Method tests are the new coordinates blocked.
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return boolean
	 */
	private boolean isSouthEastMovementBlocked(Gamepiece gamepiece, int newX, int newY) {
		for (int i = gamepiece.getY() - 1; i > newY; i--) {
			int moveCounter = 1;
			if (tileHasGamepiece(gamepiece.getX() + moveCounter, i)) return true;
			moveCounter++;
		}
		return false;
	}
	/** 	
	 * Loops through the gamepieces' ArrayList (which includes every gamepiece) 
	 * and checks if any gamepiece coordinates matches with the coordinates in the parameter.
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
	/**
	 * Method tests is the tile empty.
	 * @param tileX
	 * @param tileY
	 * @return boolean
	 */
	private boolean isTileEmpty(int tileX, int tileY) {
		return findGamepiece(tileX, tileY) == null;
	}
	/**
	 * Checks the gamepieces' ArrayList if there are the same coordinates than the parameter coordinates.
	 * If the coordinates are the same it will remove object from the list.
	 * @param x
	 * @param y
	 */
	public void deleteGamepiece(int x, int y) {
		for (int i = 0; i < gamepieces.size(); i++) {
			if (gamepieces.get(i).getX() == x && gamepieces.get(i).getY() == y) {
				if (isGamepieceKing(gamepieces.get(i))) {
					gameOver = true;
				}
				gamepieces.remove(i);
			}
		}
	}
	/**
	 * Method deletes the ArrayList.
	 */
	public void deleteAllGamepieces() {
		for (Gamepiece gamepiece : gamepieces) {
			gamepieces.remove(gamepiece);
		}
	}
	/**
	 * Method tests is the gamepiece a king.
	 * @param gamepiece
	 * @return
	 */
	private boolean isGamepieceKing(Gamepiece gamepiece) {
		return gamepiece instanceof King;
	}
	
	/**		Method startNewGame
	 * Method starts a new game and creates objects for the players and the gamepieces.
	 * Method adds the gamepieces to the chessboard.
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
		saveGame(gamepieces);
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
		gamepieces = loadGame();
	}
	/**
	 * Method uses a serializable interface to save the gampieces from the ArrayList to file.
	 * Method has an IOException.
	 * @param object
	 */
	public static void saveGame(ArrayList<Gamepiece> object) {
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
	 * Method uses a serializable interface to load the gamepieces from the file.
	 * Method has an IOException and a ClassNotFoundException. 
	 * @return object
	 */
	public static ArrayList<Gamepiece> loadGame() {
		ArrayList<Gamepiece> object = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("Test.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = (ArrayList<Gamepiece>) ois.readObject();
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
