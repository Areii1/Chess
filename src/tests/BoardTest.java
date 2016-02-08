package tests;

import game.*;
import gamepieces.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player = new Player();
		
		Pawn pawn1 = new Pawn(1, 7, player);
		Pawn pawn2 = new Pawn(2, 7, player);
		Pawn pawn3 = new Pawn(3, 7, player);
		Pawn pawn4 = new Pawn(4, 7, player);
		Pawn pawn5 = new Pawn(5, 7, player);
		Pawn pawn6 = new Pawn(6, 7, player);
		Pawn pawn7 = new Pawn(7, 7, player);
		Pawn pawn8 = new Pawn(8, 7, player);
		
		Rook rook1 = new Rook(1, 8, player);
		Rook rook2 = new Rook(8, 8, player);
	
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
		
		chessboard.render();
		System.out.println();
		
		chessboard.moveGamepiece(rook2, 8, 6);
		
		chessboard.render();
	}

}
