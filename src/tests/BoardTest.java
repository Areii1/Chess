package tests;

import game.*;
import gamepieces.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Bishop bishop1 = new Bishop(3, 3, player);
		Bishop bishop2 = new Bishop(5, 7, player);
	
		chessboard.addToBoard(bishop1);
		chessboard.addToBoard(bishop2);
		
		chessboard.render();
	}

}
