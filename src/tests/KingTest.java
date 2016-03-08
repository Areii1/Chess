package tests;

import game.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingTest {
	
	private Chessboard chessboard;
	
	private Gamepiece king;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveNorth() {
		chessboard.deleteGamepiece(4, 2);
		chessboard.moveGamepiece(4, 1, 4, 2);
		
		king = chessboard.findGamepiece(4, 2);
		
		assertEquals(4, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canMoveSouth() {
		chessboard.deleteGamepiece(4, 7);
		chessboard.moveGamepiece(4, 8, 4, 7);
		
		king = chessboard.findGamepiece(4, 7);
		
		assertEquals(4, king.getX());
		assertEquals(7, king.getY());
	}
	
	@Test
	public void canMoveEast() {
		chessboard.deleteGamepiece(5, 1);
		chessboard.moveGamepiece(4, 1, 5, 1);
		
		king = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canMoveWest() {
		chessboard.deleteGamepiece(3, 1);
		chessboard.moveGamepiece(4, 1, 3, 1);
		
		king = chessboard.findGamepiece(3, 1);
		
		assertEquals(3, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canMoveNorthEast() {
		chessboard.deleteGamepiece(5, 2);
		chessboard.moveGamepiece(4, 1, 5, 2);
		
		king = chessboard.findGamepiece(5, 2);
		
		assertEquals(5, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canMoveNorthWest() {
		chessboard.deleteGamepiece(3, 2);
		chessboard.moveGamepiece(4, 1, 3, 2);
		
		king = chessboard.findGamepiece(3, 2);
		
		assertEquals(3, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void cantMoveNorthWhenBlocked() {
		chessboard.moveGamepiece(4, 1, 4, 2);
		
		king = chessboard.findGamepiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void cantMoweEastWhenBlocked() {
		chessboard.moveGamepiece(4, 1, 5, 1);
		
		king = chessboard.findGamepiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void cantMoweWestWhenBlocked() {
		chessboard.moveGamepiece(4, 1, 3, 1);
		
		king = chessboard.findGamepiece(4, 1);
		
		assertEquals(4, king.getX());
		assertEquals(1, king.getY());
	}
	
	@Test
	public void canPlayer1KingCaptureGamepiece() {
		chessboard.deleteGamepiece(5, 2);
		chessboard.deleteGamepiece(5, 7);
		chessboard.moveGamepiece(5, 8, 5, 2);
		
		chessboard.moveGamepiece(4, 1, 5, 2);
		
		king = chessboard.findGamepiece(5, 2);
		
		assertEquals(5, king.getX());
		assertEquals(2, king.getY());
	}
	
	@Test
	public void canPlayer2KingCaptureGamepiece() {
		chessboard.deleteGamepiece(5, 2);
		chessboard.deleteGamepiece(5, 7);
		chessboard.moveGamepiece(5, 1, 5, 7);
		
		chessboard.moveGamepiece(4, 8, 5, 7);
		
		king = chessboard.findGamepiece(5, 7);
		
		assertEquals(5, king.getX());
		assertEquals(7, king.getY());
	}

}
