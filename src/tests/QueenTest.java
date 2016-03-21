package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Piece;


public class QueenTest {
	
	private Chessboard chessboard;
	
	private Piece queen;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	
	@Test
	public void canMoveFourNorth() {
		chessboard.deletePiece(5, 2);
		chessboard.movePiece(5, 1, 5, 5);
		
		queen = chessboard.findPiece(5, 5);
		
		assertEquals(5, queen.getX());
		assertEquals(5, queen.getY());
	}
	
	
	@Test
	public void canMoveFourSouth() {
		chessboard.deletePiece(5, 7);
		chessboard.movePiece(5, 8, 5, 4);
		
		queen = chessboard.findPiece(5, 4);
		
		assertEquals(5, queen.getX());
		assertEquals(4, queen.getY());
	}
	
	
	@Test
	public void canMoveTwoEast() {
		chessboard.deletePiece(6, 1);
		chessboard.deletePiece(7, 1);
		chessboard.movePiece(5, 1, 7, 1);
		
		queen = chessboard.findPiece(7, 1);
		
		assertEquals(7, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void canMoveTwoWest() {
		chessboard.deletePiece(4, 1);
		chessboard.deletePiece(3, 1);
		chessboard.movePiece(5, 1, 3, 1);
		
		queen = chessboard.findPiece(3, 1);
		
		assertEquals(3, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void canMoveThreeNorthEast() {
		chessboard.deletePiece(6, 2);
		chessboard.movePiece(5, 1, 8, 4);
		
		queen = chessboard.findPiece(8, 4);
		
		assertEquals(8, queen.getX());
		assertEquals(4, queen.getY());
	}
	
	
	@Test
	public void canMoveThreeNorthWest() {
		chessboard.deletePiece(4, 2);
		chessboard.movePiece(5, 1, 2, 4);
		
		queen = chessboard.findPiece(2, 4);
		
		assertEquals(2, queen.getX());
		assertEquals(4, queen.getY());
		
	}
	
	
	@Test
	public void cantMoveNorthWhenBlocked() {
		chessboard.movePiece(5, 1, 5, 4);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantMoveSouthWhenBlocked() {
		chessboard.movePiece(5, 8, 5, 4);
		
		queen = chessboard.findPiece(5, 8);
		
		assertEquals(5, queen.getX());
		assertEquals(8, queen.getY());
	}
	
	
	@Test
	public void cantMoveWestWhenBlocked() {
		chessboard.movePiece(5, 1, 2, 1);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantMoveEastWhenBlocked() {
		chessboard.movePiece(5, 1, 7, 1);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	@Test
	public void cantMoveNorthEastWhenBlockded() {
		chessboard.movePiece(5, 1, 7, 3);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test 
	public void cantMoveNorthWestWhenBlocked() {
		chessboard.movePiece(5, 1, 3, 3);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantSkipColumn() {
		chessboard.deletePiece(5, 2);
		chessboard.deletePiece(6, 2);
		chessboard.deletePiece(7, 2);
		chessboard.movePiece(5, 1, 6, 3);
		
		queen = chessboard.findPiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	

}
