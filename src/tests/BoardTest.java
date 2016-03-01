package tests;

import javax.swing.JOptionPane;

import game.*;
import gamepieces.*;
import userDialog.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		Pawn pawn1 = new Pawn(1, 2, player1, 'P');
		Pawn pawn2 = new Pawn(2, 2, player1, 'P');
		Pawn pawn3 = new Pawn(3, 2, player1, 'P');
		Pawn pawn4 = new Pawn(4, 2, player1, 'P');
		Pawn pawn5 = new Pawn(5, 2, player1, 'P');
		Pawn pawn6 = new Pawn(6, 2, player1, 'P');
		Pawn pawn7 = new Pawn(7, 2, player1, 'P');
		Pawn pawn8 = new Pawn(8, 2, player1, 'P');
		Rook rook1 = new Rook(1, 1, player1, 'T');
		Rook rook2 = new Rook(8, 1, player1, 'T');
		King king = new King(4, 1, player1, 'K');
		Bishop bishop1 = new Bishop(3, 1, player1, 'B');
		Bishop bishop2 = new Bishop(6, 1, player1, 'B');
		Queen queen = new Queen(5,1,player1, 'Q');
		Knight knight1 = new Knight(2,1,player1, 'N');
		Knight knight2 = new Knight(7,1,player1, 'N'); 
	
		chessboard.addToBoard(pawn1);
		chessboard.addToBoard(pawn2);
		chessboard.addToBoard(pawn3);
		chessboard.addToBoard(pawn4);
		chessboard.addToBoard(pawn5);
		chessboard.addToBoard(pawn6);
		chessboard.addToBoard(pawn7);
		chessboard.addToBoard(pawn8);
		chessboard.addToBoard(king);
		chessboard.addToBoard(rook1);
		chessboard.addToBoard(rook2);
		chessboard.addToBoard(bishop1);
		chessboard.addToBoard(bishop2);
		chessboard.addToBoard(queen);
		chessboard.addToBoard(knight1);
		chessboard.addToBoard(knight2);
		
		Pawn pawn1p = new Pawn(1, 7, player2, 'p');
		Pawn pawn2p = new Pawn(2, 7, player2, 'p');
		Pawn pawn3p = new Pawn(3, 7, player2, 'p');
		Pawn pawn4p = new Pawn(4, 7, player2, 'p');
		Pawn pawn5p = new Pawn(5, 7, player2, 'p');
		Pawn pawn6p = new Pawn(6, 7, player2, 'p');
		Pawn pawn7p = new Pawn(7, 7, player2, 'p');
		Pawn pawn8p = new Pawn(8, 7, player2, 'p');
		Rook rook1p = new Rook(1, 8, player2, 't');
		Rook rook2p = new Rook(8, 8, player2, 't');
		King kingp = new King(4, 8, player2, 'k');
		Bishop bishop1p = new Bishop(3, 8, player2, 'b');
		Bishop bishop2p = new Bishop(6, 8, player2, 'b');
		Queen queenp = new Queen(5,8,player2, 'q');
		Knight knight1p = new Knight(2,8,player2, 'n');
		Knight knight2p = new Knight(7,8,player2, 'n');
		
		chessboard.addToBoard(pawn1p);
		chessboard.addToBoard(pawn2p);
		chessboard.addToBoard(pawn3p);
		chessboard.addToBoard(pawn4p);
		chessboard.addToBoard(pawn5p);
		chessboard.addToBoard(pawn6p);
		chessboard.addToBoard(pawn7p);
		chessboard.addToBoard(pawn8p);
		chessboard.addToBoard(kingp);
		chessboard.addToBoard(rook1p);
		chessboard.addToBoard(rook2p);
		chessboard.addToBoard(bishop1p);
		chessboard.addToBoard(bishop2p);
		chessboard.addToBoard(queenp);
		chessboard.addToBoard(knight1p);
		chessboard.addToBoard(knight2p);
		
		chessboard.render();
		
		
		chessboard.moveGamepiece(pawn1, 1, 3);
		
//		player1Notice();
		
		chessboard.render();
		
		
		
		
		
	}
	
	public void player1Notice() {
		JOptionPane.showMessageDialog(null, "Player 1 it is your turn");
	}
	
	public void player2Notice() {
		JOptionPane.showMessageDialog(null, "Player 2 it is your turn");
	}

}
