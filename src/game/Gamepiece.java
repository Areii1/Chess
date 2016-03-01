package game;

public class Gamepiece {
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
	
	

	
	
	/**		Method isBackwards
	 * returns true if the detected vertical movement is backwards, returns false if it is upward.
	 * Useful for pawn class
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isMovementSouth(int y, int newY) { 
		return y - newY > 0;
	}
	
	
	/**		Method isAtTheEnd
	 * returns true if a gamepiece is at the last row of the chessboard, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	public static boolean isAtTheEndPlayer1(int y) {
		return y == 8;
	}
	
	
	/**		Method isAtTheEnd
	 * returns true if a gamepiece is at the last row of the chessboard, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	public static boolean isAtTheEndPlayer2(int y) {
		return y == 1;
	}
	
	
	/**		Method isPawnAtStartPlayer1
	 * returns true if a Pawn is at the start row y = 2, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	public static boolean isPawnAtStartPlayer1(int y) {
		return y == 2;
	}
	/**		Method isPawnAtStartPlayer2
	 * returns true if a Pawn is at the start row y = 7, returns false if not.
	 * Useful for pawn class
	 * 
	 * @param y
	 * @return
	 */
	public static boolean isPawnAtStartPlayer2(int y) {
		return y == 7;
	}
	
	/**		Method isYDifferenceOne
	 * returns true if the upward movement equals 1, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isMovementOneNorth(int y, int newY) {
		return y - newY == -1;
	}
	
	
	/**		Method isYDifferenceTwoOrLess
	 * returns true if the upward movement is two or less, returns false if not.
	 * Useful for pawn class.
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isMovementOneOrTwoNorth(int y, int newY) {
		return y - newY >= -2;
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
	public static boolean isMovementWestOrEast(int x, int newX, int y, int newY) {
		return x - newX != 0 && y == newY;
	}
	
	
	/**		Method isXDifferenceMoreThanOne
	 * returns true if detected Eastward or westward movement is greater than one.
	 * Useful for Rook class.
	 * @param x
	 * @param newX
	 * @return
	 */
	public static boolean isXDifferenceMoreThanOne(int x, int newX) {
		return x - newX > 1 || x - newX < -1; 				
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
	public static boolean isXAndYChanged(int x, int newX, int y, int newY) {
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
	public static boolean isXAndYEvenChange(int x, int newX, int y, int newY) {
		return (x - newX == y - newY) || (x - newX == -(y - newY));
	}

	
	/**		Method isMovementNorthwest
	 * 		
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return 
	 */
	public static boolean isMovementNortheast(Gamepiece gamepiece, int newX, int newY) {
		if (newY - gamepiece.getY() == newX - gamepiece.getX() && (newY - gamepiece.getY() > 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementSoutheast
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	public static boolean isMovementSouthwest(Gamepiece gamepiece, int newX, int newY) {
		if (newY - gamepiece.getY() == newX - gamepiece.getX() && (newY - gamepiece.getY() < 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementNortheast
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	public static boolean isMovementNorthwest(Gamepiece gamepiece, int newX, int newY) {
		if ((newY - gamepiece.getY()) + (newX - gamepiece.getX()) == 0 && (newY - gamepiece.getY() > 0)) return true;
		return false;
	}
	
	
	/**		Method isMovementSouthwest
	 * 
	 * @param gamepiece
	 * @param newX
	 * @param newY
	 * @return
	 */
	public static boolean isMovementSoutheast(Gamepiece gamepiece, int newX, int newY) {
		if ((newY - gamepiece.getY()) + (newX - gamepiece.getX()) == 0 && (newY - gamepiece.getY() < 0)) return true;
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
	public static boolean isMovementNorth(Gamepiece gamepiece, int newX, int newY) {
		if ((((newY - gamepiece.getY()) > 0) && ((newX - gamepiece.getX()) == 0))) {
			System.out.println("movement is northward");
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
	public static boolean isMovementSouth(Gamepiece gamepiece, int newX, int newY) {
		if ((((newY - gamepiece.getY()) < 0) && ((newX - gamepiece.getX()) == 0))) {
			System.out.println("movement is southward");
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
	public static boolean isMovementWest(Gamepiece gamepiece, int newX, int newY) {
		if ((((newY - gamepiece.getY()) == 0) && ((newX - gamepiece.getX()) < 0))) {
			System.out.println("movement is Eastward");
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
	public static boolean isMovementEast(Gamepiece gamepiece, int newX, int newY) {
		if ((((newY - gamepiece.getY()) == 0) && ((newX - gamepiece.getX()) > 0))) {
			System.out.println("movement is westward");
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
	
	public static boolean isMovementTwoNorthOneEast(int x, int y, int newX, int newY) {
		if ((((newY - y) == 2) && ((newX - x) == 1))) return true;
		return false;
	}
	
	public static boolean isMovementTwoNorthOneWest(int x, int y, int newX, int newY) {
		if (((newY - y) == 2) && ((newX - x) == -1)) return true;
		return false;
	}
	
	public static boolean isMovementOneNorthTwoWest(int x, int y, int newX, int newY) {
		if (((newY - y) == 1) && ((newX - x) == -2)) return true;
		return false;
	}
	
	public static boolean isMovementOneNorthTwoEast(int x, int y, int newX, int newY) {
		if (((newY - y) == 1) && ((newX - x) == 2)) return true;
		return false;
	}
	
	public static boolean isMovementTwoSouthOneEast(int x, int y, int newX, int newY) {
		if (((newY - y) == -2) && ((newX - x) == 1)) return true;
		return false;
	}
	
	public static boolean isMovementTwoSouthOneWest(int x, int y, int newX, int newY) {
		if (((newY - y) == -2) && ((newX - x) == -1)) return true;
		return false;
	}
	
	public static boolean isMovementOneSouthTwoEast(int x, int y, int newX, int newY) {
		if (((newY - y) == -1) && ((newX - x) == 2)) return true;
		return false;
	}
	
	public static boolean isMovementOneSouthTwoWest(int x, int y, int newX, int newY) {
		if (((newY - y) == -1) && ((newX - x) == -2)) return true;
		return false;
	}
	
	//
	
	
	
	public static boolean isMovementOneNorth(int x, int y, int newX, int newY) {
		if ((newY - y == 1) && ((newX - x) == 0)) return true;
		return false;
	}
	public static boolean isMovementOneSouth(int x, int y, int newX, int newY){
		if (newY - y == -1 && newX - x == 0) return true;
		return false;
	}
	public static boolean isMovementOneWest(int x, int y, int newX, int newY){
		if (newY - y == 0 && newX - x == 1) return true;
		return false;
	}
	public static boolean isMovementOneEast(int x, int y, int newX, int newY){
		if (newY - y == 0 && newX - x == -1) return true;
		return false;
	}
	public static boolean isMovementOneNorthOneEast(int x, int y, int newX, int newY){
		if (newY - y == 1 && newX - x == 1) return true;
		return false;
	}
	public static boolean isMovementOneNorthOneWest(int x, int y, int newX, int newY){
		if (newY - y == 1 && newX - x == -1) return true;
		return false;
	}
	public static boolean isMovementOneSouthOneEast(int x, int y, int newX, int newY){
		if (newY - y == -1 && newX - x == 1) return true;
		return false;
	}
	public static boolean isMovementOneSouthOneWest(int x, int y, int newX, int newY){
		if (newY - y == -1 && newX - x == -1) return true;
		return false;
	}
	
	public static boolean isMovementOneOrTwoNorth(int x, int y, int newX, int newY){
		if ((newY - y == 1 || newY - y == 2) && (newX - x == 0)) return true;
		return false;
	}
	public static boolean isMovementOneOrTwoSouth(int x, int y, int newX, int newY){
		if ((newY - y == -1 || newY - y == -2) && (newX - x == 0)) return true;
		return false;
	}

}
