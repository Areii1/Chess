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

}
