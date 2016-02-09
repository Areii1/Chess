package game;

public class MoveValidation {
	
	public static boolean isBackwards(int y, int newY) { 
		return y - newY < 0;
	}
	
	public static boolean isAtTheEnd(int y) {
		return y == 1;
	}
	
	public static boolean isYDifferenceOne(int y, int newY) {
		return y - newY == 1;
	}
	
	public static boolean isAtStart(int y) {
		return y == 7;
	}
	
	public static boolean isYDifferenceTwoOrLess(int y, int newY) {
		return y - newY <= 2;
	}
	
	public static boolean isSideways(int x, int newX, int y, int newY) {
		return x - newX != 0 && y == newY;
	}
	
	public static boolean isXDifferenceMoreThanOne(int x, int newX) {
		return x - newX > 1;
	}
	
	public static boolean isXAndYChanged(int x, int newX, int y, int newY) {
		return x - newX != 0 && y - newY != 0;
	}
	
	public static boolean isXAndYEvenChange(int x, int newX, int y, int newY) {
		return (x - newX == y - newY) || (x - newX == -(y - newY));
	}

}
