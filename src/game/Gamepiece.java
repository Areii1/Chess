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

}
