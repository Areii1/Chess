package game;

public class Chessboard {
	
//protected Square[] tiles = new Square[];
	
	public void render() {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(" X ");
			}
			System.out.println("");
		}
	}
}
