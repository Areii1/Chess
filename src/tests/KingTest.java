package tests;

import game.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingTest {
	
	private Chessboard chessboard;
	
	private Piece king;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveNorth() {
		chessboard.deletePiece(4, 2);
		chessboard.movePiece(4, 1, 4, 2);
		
		king = chessboard.findPiece(4, 2);
		
		assertEquals(4, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canMoveSouth() {
		chessboard.deletePiece(4, 7);
		chessboard.movePiece(4, 8, 4, 7);
		
		king = chessboard.findPiece(4, 7);
		
		assertEquals(4, king.getX());
		assertEquals(7, king.getY());
	}
	
	@Test
	public void canMoveEast() {
		chessboard.deletePiece(5, 1);
		chessboard.movePiece(4, 1, 5, 1);
		
		king = chessboard.findPiece(5, 1);
		
		assertEquals(5, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canMoveWest() {
		chessboard.deletePiece(3, 1);
		chessboard.movePiece(4, 1, 3, 1);
		
		king = chessboard.findPiece(3, 1);
		
		assertEquals(3, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canMoveNorthEast() {
		chessboard.deletePiece(5, 2);
		chessboard.movePiece(4, 1, 5, 2);
		
		king = chessboard.findPiece(5, 2);
		
		assertEquals(5, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canMoveNorthWest() {
		chessboard.deletePiece(3, 2);
		chessboard.movePiece(4, 1, 3, 2);
		
		king = chessboard.findPiece(3, 2);
		
		assertEquals(3, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void cantMoveNorthWhenBlocked() {
		chessboard.movePiece(4, 1, 4, 2);
		
		king = chessboard.findPiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void cantMoweEastWhenBlocked() {
		chessboard.movePiece(4, 1, 5, 1);
		
		king = chessboard.findPiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void cantMoweWestWhenBlocked() {
		chessboard.movePiece(4, 1, 3, 1);
		
		king = chessboard.findPiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canPlayer1KingCaptureGamepiece() {
		chessboard.deletePiece(5, 2);
		chessboard.deletePiece(5, 7);
		chessboard.movePiece(5, 8, 5, 2);
		
		chessboard.movePiece(4, 1, 5, 2);
		
		king = chessboard.findPiece(5, 2);
		
		assertEquals(5, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canPlayer2KingCaptureGamepiece() {
		chessboard.deletePiece(5, 2);
		chessboard.deletePiece(5, 7);
		chessboard.movePiece(5, 1, 5, 7);
		
		chessboard.movePiece(4, 8, 5, 7);
		
		king = chessboard.findPiece(5, 7);
		
		assertEquals(5, king.getX());
		assertEquals(7, king.getY());
	}

}
