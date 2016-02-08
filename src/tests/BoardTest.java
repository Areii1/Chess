package tests;

import game.*;
import gamepieces.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Bishop bishop1 = new Bishop(3, 3, player);
		Bishop bishop2 = new Bishop(5, 7, player);
		Pawn pawn1 = new Pawn(8, 7, player);
	
		chessboard.addToBoard(bishop1);
		chessboard.addToBoard(bishop2);
		chessboard.addToBoard(pawn1);
		
		chessboard.render();
		System.out.println();
		pawn1.move(2, 1);
		pawn1.move(7, 7);
		chessboard.render();
	}

}
