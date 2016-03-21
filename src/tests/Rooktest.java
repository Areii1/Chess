package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Piece;

public class Rooktest {

	private Chessboard chessboard;
	
	private Piece rook;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	
	@Test
	public void canMoveTwoNorth() {
		chessboard.deletePiece(1, 2);
		chessboard.movePiece(1, 1, 1, 3);
		
		rook = chessboard.findPiece(1, 3);
		
		assertEquals(1, rook.getX());
		assertEquals(3, rook.getY());
	}
	
	
	@Test
	public void canMoveTwoSouth() {
		chessboard.deletePiece(1, 7);
		chessboard.movePiece(1, 8, 1, 6);
		
		rook = chessboard.findPiece(1, 6);
		
		assertEquals(1, rook.getX());
		assertEquals(6, rook.getY());
	}
	
	
	@Test
	public void canMoveSixEast() {
		chessboard.deletePiece(2, 1);
		chessboard.deletePiece(3, 1);
		chessboard.deletePiece(4, 1);
		chessboard.deletePiece(5, 1);
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(7, 1);
		chessboard.deletePiece(8, 1);
		
		chessboard.movePiece(1, 1, 7, 1);
		
		rook = chessboard.findPiece(7, 1);
		
		assertEquals(7, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canMoveSixWest() {
		chessboard.deletePiece(1, 1);
		chessboard.deletePiece(2, 1);
		chessboard.deletePiece(3, 1);
		chessboard.deletePiece(4, 1);
		chessboard.deletePiece(5, 1);
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(7, 1);
		
		chessboard.movePiece(8, 1, 2, 1);
		
		rook = chessboard.findPiece(2, 1);
		
		assertEquals(2, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveSixWestWhenBlocked() {
		chessboard.deletePiece(1, 1);
		chessboard.deletePiece(2, 1);
		chessboard.deletePiece(3, 1);
		chessboard.deletePiece(4, 1);
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(7, 1);
		
		chessboard.movePiece(8, 1, 2, 1);
		
		rook = chessboard.findPiece(8, 1);
		
		assertEquals(8, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveSixEastWhenBlocked() {
		chessboard.deletePiece(3, 1);
		chessboard.deletePiece(4, 1);
		chessboard.deletePiece(5, 1);
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(7, 1);
		chessboard.deletePiece(8, 1);
		
		chessboard.movePiece(1, 1, 7, 1);
		
		rook = chessboard.findPiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveFourNorthWhenBlocked() {
		chessboard.movePiece(1, 1, 1, 4);
		
		rook = chessboard.findPiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveFourSouthWhenBlocked() {
		chessboard.movePiece(1, 8, 1, 5);
		
		rook = chessboard.findPiece(1, 8);
		
		assertEquals(1, rook.getX());
		assertEquals(8, rook.getY());
	}
	
	
	@Test
	public void canNotMoveDiagonally() {
		chessboard.deletePiece(2, 1);
		chessboard.deletePiece(2, 2);
		chessboard.deletePiece(2, 3);
		chessboard.deletePiece(2, 4);
		
		chessboard.movePiece(1, 1, 8, 8);
		
		rook = chessboard.findPiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotSkipColumn() {
		chessboard.deletePiece(2, 1);
		chessboard.deletePiece(2, 2);
		chessboard.deletePiece(2, 3);
		chessboard.deletePiece(2, 4);
		
		chessboard.movePiece(1, 1, 2, 4);
		
		rook = chessboard.findPiece(1, 1);
		
		//No assertequals??
	}
	
	@Test
	public void canPlayer1RookCaptureGamepiece() {
		chessboard.deletePiece(1, 2);
		chessboard.deletePiece(1, 7);
		
		chessboard.movePiece(1, 1, 1, 8);
		
		rook = chessboard.findPiece(1, 8);
		
		assertEquals(1, rook.getX());
		assertEquals(8, rook.getY());
	}
	
	@Test
	public void canPlayer2RookCaptureGamepiece() {
		chessboard.deletePiece(1, 2);
		chessboard.deletePiece(1, 7);
		
		chessboard.movePiece(1, 8, 1, 1);
		
		rook = chessboard.findPiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
}
