package game;

import java.io.Serializable;

public class Gamepiece implements Serializable {
	/**
	 * 
	 */
	protected int x;
	
	protected int y;
	
	public Player player;
	
	protected char type;
	
	/**		CONSTRUCTOR
	 * Constructor for gamepiece class. Every subclass constructor of Gamepiece (Pawn, Bishop, etc...) inherits the parameters from this constructor.
	 * No gamepiece object should be actually constructed, define the type of a Gamepiece by using the subclass's constructors (Pawn, Bishop, etc...)
	 * @param x
	 * @param y
	 * @param player
	 * @param type
	 */
	public Gamepiece(int x, int y, Player player, char type) {
		this.y = y;
		this.x = x;
		this.player = player;
		this.type = type;
	}
	
	
	/** GETTERS AND SETTERS
	 * getters and setters for the x coordinate, y coordinate, and Player object
	 * @return
	 */
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	/**		Method move
	 * Changes the (x,y) coordinate to a new coordinate, no questions asked. Unlike the moveGamepiece method in the chessboard class which 
	 * checks if various conditions are met
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	} 
	
	
	
	
//	MOVEVALIDATION METHODS	
	
	
	
	
	/**		Method isAtTheEnd
	 * returns true if a gamepiece is at the last row of the chessboard, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	protected boolean isAtTheEndPlayer1() {
		return y == 8;
	}
	
	
	/**		Method isAtTheEnd
	 * returns true if a gamepiece is at the last row of the chessboard, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	protected boolean isAtTheEndPlayer2() {
		return y == 1;
	}
	
	
	/**		Method isPawnAtStartPlayer1
	 * returns true if a Pawn is at the start row y = 2, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	protected boolean isPawnAtStartPlayer1() {
		return y == 2;
	}
	/**		Method isPawnAtStartPlayer2
	 * returns true if a Pawn is at the start row y = 7, returns false if not.
	 * Useful for pawn class
	 * 
	 * @param y
	 * @return
	 */
	
	protected boolean isPawnAtStartPlayer2() {
		return y == 7;
	}
	
	/**		Method isSideways
	 * returns true if horizontal movement is detected, but no vertical movement is present, returns false if not.
	 * Useful for Pawn and Rook class.
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	protected boolean isMovementWestOrEast(int newX, int newY) {
		return x - newX != 0 && y == newY;
	}
	
	/**		Method isXAndYChanged
	 * returns true if both vertical or horizontal movement is present, returns false if not.
	 * Useful for Bishop class.
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	protected boolean isXAndYChanged(int newX, int newY) {
		return x - newX != 0 && y - newY != 0;
	}
	
	
	/**		Method isXAndYEvenChange
	 * returns true if the movement is diagonal, returns false if not.
	 * Useful for Bishop class.
	 * @param x
	 * @param newX
	 * @param y
	 * @param newY
	 * @return
	 */
	protected boolean isXAndYEvenChange(int newX, int newY) {
		return (x - newX == y - newY) || (x - newX == -(y - newY));
	}

	
	/**		Method isMovementNorthwest
	 * 		
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return 
	 */
	protected boolean isMovementNortheast(int newX, int newY) {
		if (newY - y == newX - x && (newY - y > 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementSoutheast
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementSouthwest(int newX, int newY) {
		if (newY - y == newX - x && (newY - y < 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementNortheast
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementNorthwest(int newX, int newY) {
		if ((newY - y) + (newX - x) == 0 && (newY - y > 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementSouthwest
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementSoutheast(int newX, int newY) {
		if ((newY - y) + (newX - x) == 0 && (newY - y < 0)) return true;
		return false;
	}
	
	
	
	/**		Method isMovementNorth
	 * 
	 * Useful for rook class
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementNorth(int newX, int newY) {
		if ((((newY - y) > 0) && ((newX - x) == 0))) {
			return true;
		}
		return false;
	}
	
	
	
	/**		Method isMovementSouth
	 * 
	 * Useful for rook class
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementSouth(int newX, int newY) {
		if ((((newY - y) < 0) && ((newX - x) == 0))) {
			return true;
		}
		return false;
	}
	
	
	/**		Method isMovementEast
	 * 
	 * Useful for rook class
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementWest(int newX, int newY) {
		if ((((newY - y) == 0) && ((newX - x) < 0))) {
			return true;
		}
		return false;
	}
	
	
	
	/**		Method isMovementWest
	 * 
	 * Useful for rook class
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	protected boolean isMovementEast(int newX, int newY) {
		if ((((newY - y) == 0) && ((newX - x) > 0))) {
			return true;
		}
		return false;
	}
	
	
	/**		Method isMovement
	 * 
	 * Useful for knight class
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	
	protected boolean isMovementTwoNorthOneEast(int newX, int newY) {
		if ((((newY - y) == 2) && ((newX - x) == 1))) return true;
		return false;
	}
	
	protected boolean isMovementTwoNorthOneWest(int newX, int newY) {
		if (((newY - y) == 2) && ((newX - x) == -1)) return true;
		return false;
	}
	
	protected boolean isMovementOneNorthTwoWest(int newX, int newY) {
		if (((newY - y) == 1) && ((newX - x) == -2)) return true;
		return false;
	}
	
	protected boolean isMovementOneNorthTwoEast(int newX, int newY) {
		if (((newY - y) == 1) && ((newX - x) == 2)) return true;
		return false;
	}
	
	protected boolean isMovementTwoSouthOneEast(int newX, int newY) {
		if (((newY - y) == -2) && ((newX - x) == 1)) return true;
		return false;
	}
	
	protected boolean isMovementTwoSouthOneWest(int newX, int newY) {
		if (((newY - y) == -2) && ((newX - x) == -1)) return true;
		return false;
	}
	
	protected boolean isMovementOneSouthTwoEast(int newX, int newY) {
		if (((newY - y) == -1) && ((newX - x) == 2)) return true;
		return false;
	}
	
	protected boolean isMovementOneSouthTwoWest(int newX, int newY) {
		if (((newY - y) == -1) && ((newX - x) == -2)) return true;
		return false;
	}
	
	//
	
	
	
	protected boolean isMovementOneNorth(int newX, int newY) {
		if ((newY - y == 1) && ((newX - x) == 0)) return true;
		return false;
	}
	
	protected boolean isMovementOneSouth(int newX, int newY) {
		if (newY - y == -1 && newX - x == 0) return true;
		return false;
	}
	
	protected boolean isMovementOneWest(int newX, int newY) {
		if (newY - y == 0 && newX - x == 1) return true;
		return false;
	}
	
	protected boolean isMovementOneEast(int newX, int newY) {
		if (newY - y == 0 && newX - x == -1) return true;
		return false;
	}
	
	protected boolean isMovementOneNorthOneEast(int newX, int newY) {
		if (newY - y == 1 && newX - x == 1) return true;
		return false;
	}
	
	protected boolean isMovementOneNorthOneWest(int newX, int newY) {
		if (newY - y == 1 && newX - x == -1) return true;
		return false;
	}
	
	protected boolean isMovementOneSouthOneEast(int newX, int newY) {
		if (newY - y == -1 && newX - x == 1) return true;
		return false;
	}
	
	protected boolean isMovementOneSouthOneWest(int newX, int newY) {
		if (newY - y == -1 && newX - x == -1) return true;
		return false;
	}
	
	protected boolean isMovementOneOrTwoNorth(int newX, int newY) {
		if ((newY - y == 1 || newY - y == 2) && (newX - x == 0)) return true;
		return false;
	}
	
	protected boolean isMovementOneOrTwoSouth(int newX, int newY) {
		if ((newY - y == -1 || newY - y == -2) && (newX - x == 0)) return true;
		return false;
	}
	
	protected boolean isSouthMovementOverTwo(int newX, int newY) {
		return newX - x == 0 && newY - y < -2;
	}
	
	protected boolean isNorthMovementOverTwo(int newX, int newY) {
		return newX - x == 0 && newY - y > 2;
	}
	
	protected boolean isMovementOverOneNorthOneEast(int newX, int newY) {
		if (newY - y > 1 && newX - x > 1) return true;
		return false;
	}
	
	protected boolean isMovementOverOneNorthOneWest(int newX, int newY) {
		if (newY - y > 1 && newX - x < -1) return true;
		return false;
	}
	
	protected boolean isMovementOverOneSouthOneEast(int newX, int newY) {
		if (newY - y < -1 && newX - x > 1) return true;
		return false;
	}
	
	protected boolean isMovementOverOneSouthOneWest(int newX, int newY) {
		if (newY - y < -1 && newX - x < -1) return true;
		return false;
	}

}
