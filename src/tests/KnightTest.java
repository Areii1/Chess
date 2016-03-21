package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Piece;

public class KnightTest {
	
	private Chessboard chessboard;
	
	private Piece knight;
	
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	
	@Test
	public void canMoveTwoNorthOneWest() {
		chessboard.movePiece(2, 1, 3, 3);
		
		knight = chessboard.findPiece(3, 3);
		
		assertEquals(3, knight.getX());
		assertEquals(3, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoNorthOneEast() {
		chessboard.movePiece(2, 1, 1, 3);
		
		knight = chessboard.findPiece(1, 3);
		
		assertEquals(1, knight.getX());
		assertEquals(3, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoSouthOneWest() {
		chessboard.movePiece(2, 8, 3, 6);
		
		knight = chessboard.findPiece(3, 6);
		
		assertEquals(3, knight.getX());
		assertEquals(6, knight.getY());	
	}
	
	@Test
	public void canMoveTwoSouthOneEast() {
		chessboard.movePiece(2, 8, 1, 6);
		
		knight = chessboard.findPiece(1, 6);
		
		assertEquals(1, knight.getX());
		assertEquals(6, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoWestOneNorth() {
		chessboard.movePiece(7, 1, 6, 3);
		chessboard.movePiece(6, 3, 4, 4);
		
		knight = chessboard.findPiece(4, 4);
		
		assertEquals(4, knight.getX());
		assertEquals(4, knight.getY());	
		
	}
	
	@Test
	public void canMoveTwoEastOneNorth() {
		chessboard.movePiece(7, 1, 6, 3);
		chessboard.movePiece(6, 3, 4, 4);
		chessboard.movePiece(4, 4, 6, 5);
		
		knight = chessboard.findPiece(6, 5);
		
		assertEquals(6, knight.getX());
		assertEquals(5, knight.getY());	
		
	}
	
	
	@Test
	public void cantMoveWhenTitleIsBlocked() { 
		chessboard.movePiece(3, 2, 3, 3);
		chessboard.movePiece(2, 1, 3, 3);
		
		knight = chessboard.findPiece(2, 1);
		
		assertEquals(2, knight.getX());
		assertEquals(1, knight.getY());	
		
	}

}
