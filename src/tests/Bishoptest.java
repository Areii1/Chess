package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Piece;

public class Bishoptest {
	private Chessboard chessboard;
	
	private Piece newbishop;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveTwoWestTwoNorth() {
		chessboard.deletePiece(2, 2);
		chessboard.movePiece(3, 1, 1, 3);
		
		newbishop = chessboard.findPiece(1, 3);
		
		assertEquals(1, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canMoveTwoEastTwoNorth() {
		chessboard.deletePiece(7, 2);
		chessboard.movePiece(6, 1, 8, 3);
		
		newbishop = chessboard.findPiece(8, 3);
		
		assertEquals(8, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canMoveThreeEastThreeSouth() {
		chessboard.deletePiece(4, 7);
		chessboard.movePiece(3, 8, 6, 5);
		
		newbishop = chessboard.findPiece(6, 5);
		
		assertEquals(6, newbishop.getX());
		assertEquals(5, newbishop.getY());
	}
	
	
	@Test
	public void canMoveFiveWestFiveSouth() {
		chessboard.deletePiece(5, 7);
		chessboard.movePiece(6, 8, 1, 3);
		
		newbishop = chessboard.findPiece(1, 3);
		
		assertEquals(1, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canNotMoveFourWestFiveSouth() {
		chessboard.deletePiece(5, 7);
		chessboard.deletePiece(4, 7);
		chessboard.deletePiece(8, 7);
		chessboard.deletePiece(7, 7);
		chessboard.deletePiece(6, 7);
		chessboard.deletePiece(1, 7);
		chessboard.deletePiece(2, 7);
		chessboard.deletePiece(3, 7);
		
		chessboard.movePiece(6, 8, 2, 3);
		
		newbishop = chessboard.findPiece(6, 8);
		
		assertEquals(6, newbishop.getX());
		assertEquals(8, newbishop.getY());
	}
	
	@Test
	public void canNotMoveTwoEastTowNorthWhenBlocked() {
		chessboard.deletePiece(5, 2);
		chessboard.deletePiece(8, 2);
		chessboard.deletePiece(7, 2);
		chessboard.deletePiece(6, 2);
		chessboard.deletePiece(1, 2);
		chessboard.deletePiece(2, 2);
		chessboard.deletePiece(3, 2);
		
		chessboard.movePiece(3, 1, 5, 3);
		
		newbishop = chessboard.findPiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	@Test
	public void canNotMoveTwoWestTwoSouthWhenBlocked() {
		chessboard.movePiece(6, 8, 5, 6);
		
		newbishop = chessboard.findPiece(6, 8);
		
		assertEquals(6, newbishop.getX());
		assertEquals(8, newbishop.getY());
	}
	
	@Test
	public void canNotMoveOnTopOfGamepiece() {
		chessboard.movePiece(3, 1, 4, 2);
		
		newbishop = chessboard.findPiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	
	@Test
	public void canNotMoveFourEastThreeNorth() {
		chessboard.deletePiece(5, 2);
		chessboard.deletePiece(4, 2);
		chessboard.deletePiece(8, 2);
		chessboard.deletePiece(7, 2);
		chessboard.deletePiece(6, 2);
		chessboard.deletePiece(1, 2);
		chessboard.deletePiece(2, 2);
		chessboard.deletePiece(3, 2);
		
		chessboard.movePiece(3, 1, 7, 4);
		
		newbishop = chessboard.findPiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	@Test
	public void canPlayer1BishopCaptureGamepiece() {
		chessboard.deletePiece(4, 2);
		chessboard.deletePiece(4, 7);
		chessboard.movePiece(3, 1, 7, 5);
		chessboard.movePiece(7, 5, 5, 7);
		
		newbishop = chessboard.findPiece(5, 7);
		
		assertEquals(5, newbishop.getX());
		assertEquals(7, newbishop.getY());
	}
	
	@Test
	public void canPlayer2BishopCaptureGamepiece() {
		chessboard.deletePiece(4, 2);
		chessboard.deletePiece(4, 7);
		
		chessboard.movePiece(3, 8, 7, 4);
		chessboard.movePiece(7, 4, 5, 2);
		
		newbishop = chessboard.findPiece(5, 2);
		
		assertEquals(5, newbishop.getX());
		assertEquals(2, newbishop.getY());
	}

	@Test
	public void canMoveFiveSouthFiveEast() {
		Piece oldBishop = chessboard.findPiece(3, 8);
		chessboard.deletePiece(2, 7);
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(5, 2);
		
		chessboard.movePiece(3, 8, 1, 6);
		chessboard.movePiece(1, 6, 6, 1);
		
		newbishop = chessboard.findPiece(6, 1);
		
		assertEquals(newbishop, oldBishop);
		
	}
}
