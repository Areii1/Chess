package tests;

import game.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Gamepiece pawn = new Gamepiece(1, 1 , player);
	
		chessboard.addToBoard(pawn);
		
		chessboard.render();
	}

}
