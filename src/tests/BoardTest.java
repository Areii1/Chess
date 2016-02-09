package tests;

import game.*;
import gamepieces.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Pawn pawn1 = new Pawn(1, 2, player);
		Pawn pawn2 = new Pawn(2, 2, player);
		Pawn pawn3 = new Pawn(3, 2, player);
		Pawn pawn4 = new Pawn(4, 2, player);
		Pawn pawn5 = new Pawn(5, 2, player);
		Pawn pawn6 = new Pawn(6, 2, player);
		Pawn pawn7 = new Pawn(7, 2, player);
		Pawn pawn8 = new Pawn(8, 2, player);
		
		Rook rook1 = new Rook(1, 1, player);
		Rook rook2 = new Rook(8, 1, player);
		
		Bishop bishop1 = new Bishop(3, 1, player);
		Bishop bishop2 = new Bishop(6, 1, player);
	
		chessboard.addToBoard(pawn1);
		chessboard.addToBoard(pawn2);
		chessboard.addToBoard(pawn3);
		chessboard.addToBoard(pawn4);
		chessboard.addToBoard(pawn5);
		chessboard.addToBoard(pawn6);
		chessboard.addToBoard(pawn7);
		chessboard.addToBoard(pawn8);
		
		chessboard.addToBoard(rook1);
		chessboard.addToBoard(rook2);
		
		chessboard.addToBoard(bishop1);
		chessboard.addToBoard(bishop2);
		
		chessboard.render();
		System.out.println();
//		chessboard.moveGamepiece(pawn1, 1, 3);			OK
//		chessboard.moveGamepiece(bishop2, 3, 4);		OK
		chessboard.moveGamepiece(rook1, 4, 1);
		
		
		chessboard.render();
		
		//jou
	}

}
