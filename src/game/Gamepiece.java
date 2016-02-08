package game;

public class Gamepiece {
	protected int x;
	protected int y;
	protected Type type;
	public Player player;
	
	
	/*
	 * constructor for a piece
	 * 1. parameter row
	 * 2. parameter column
	 * 3. parameter Player
	 */
	public Gamepiece(int x, int y, Player player) {
		this.y = y;
		this.x = x;
		this.player = player;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
