package game;

import java.io.Serializable;

public class Player implements Serializable {
	
	private int id;

	public Player(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

}
