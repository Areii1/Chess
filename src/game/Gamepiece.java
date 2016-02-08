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
}
