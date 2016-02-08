package tests;

import game.*;
import gamepieces.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Pawn pawn1 = new Pawn(8, 7, player);
		Pawn pawn2 = new Pawn(1, 6, player);
	
		chessboard.addToBoard(pawn1);
		chessboard.addToBoard(pawn2);
		
		chessboard.render();
		System.out.println();
		pawn1.move(2, 7);
		pawn2.move(3, 4);
		
		chessboard.render();
	}

}
