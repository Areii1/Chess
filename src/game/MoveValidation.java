package game;

public class MoveValidation {
	
	/**		Method isBackwards
	 * returns true if the detected vertical movement is backwards, returns false if it is upward.
	 * Useful for pawn class
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isBackwards(int y, int newY) { 
		return y - newY > 0;
	}
	
	
	/**		Method isAtTheEnd
	 * returns true if a gamepiece is at the last row of the chessboard, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	public static boolean isAtTheEnd(int y) {
		return y == 8;
	}
	
	
	/**		Method isPawnAtStart
	 * returns true if a Pawn is at the start row y = 2, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @return
	 */
	public static boolean isPawnAtStart(int y) {
		return y == 2;
	}
	
	/**		Method isYDifferenceOne
	 * returns true if the upward movement equals 1, returns false if not.
	 * Useful for pawn class
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isYDifferenceOne(int y, int newY) {
		return y - newY == -1;
	}
	
	
	/**		Method isYDifferenceTwoOrLess
	 * returns true if the upward movement is two or less, returns false if not.
	 * Useful for pawn class.
	 * @param y
	 * @param newY
	 * @return
	 */
	public static boolean isYDifferenceTwoOrLess(int y, int newY) {
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
	public static boolean isSideways(int x, int newX, int y, int newY) {
		return x - newX != 0 && y == newY;
	}
	
	
	/**		Method isXDifferenceMoreThanOne
	 * returns true if detected rightward or leftward movement is greater than one.
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
	public static boolean isMovementNorthwest(Gamepiece gamepiece, int newX, int newY) {
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
	public static boolean isMovementSoutheast(Gamepiece gamepiece, int newX, int newY) {
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
	public static boolean isMovementNortheast(Gamepiece gamepiece, int newX, int newY) {
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
	public static boolean isMovementSouthwest(Gamepiece gamepiece, int newX, int newY) {
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
	public static boolean isMovementEast(Gamepiece gamepiece, int newX, int newY) {
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
	public static boolean isMovementWest(Gamepiece gamepiece, int newX, int newY) {
		if ((((newY - gamepiece.getY()) == 0) && ((newX - gamepiece.getX()) > 0))) {
			System.out.println("movement is westward");
			return true;
		}
		return false;
	}
	
	

	
	public static boolean isMovementTwoNorthOneEast(int x, int y, int newX, int newY) {
		if ((((newY - y) == 2) && ((newX - x) == 1))) return true;
		return false;
	}
	
	public static boolean isMovementTwoNorthOneWest(int x, int y, int newX, int newY) {
		if (((newY - y == 2) && ((newX - x) == -1))) return true;
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
}

