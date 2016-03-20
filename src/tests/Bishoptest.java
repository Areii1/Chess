package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Gamepiece;

public class Bishoptest {
	private Chessboard chessboard;
	
	private Gamepiece newbishop;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveTwoWestTwoNorth() {
		chessboard.deleteGamepiece(2, 2);
		chessboard.moveGamepiece(3, 1, 1, 3);
		
		newbishop = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canMoveTwoEastTwoNorth() {
		chessboard.deleteGamepiece(7, 2);
		chessboard.moveGamepiece(6, 1, 8, 3);
		
		newbishop = chessboard.findGamepiece(8, 3);
		
		assertEquals(8, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canMoveThreeEastThreeSouth() {
		chessboard.deleteGamepiece(4, 7);
		chessboard.moveGamepiece(3, 8, 6, 5);
		
		newbishop = chessboard.findGamepiece(6, 5);
		
		assertEquals(6, newbishop.getX());
		assertEquals(5, newbishop.getY());
	}
	
	
	@Test
	public void canMoveFiveWestFiveSouth() {
		chessboard.deleteGamepiece(5, 7);
		chessboard.moveGamepiece(6, 8, 1, 3);
		
		newbishop = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, newbishop.getX());
		assertEquals(3, newbishop.getY());
	}
	
	@Test
	public void canNotMoveFourWestFiveSouth() {
		chessboard.deleteGamepiece(5, 7);
		chessboard.deleteGamepiece(4, 7);
		chessboard.deleteGamepiece(8, 7);
		chessboard.deleteGamepiece(7, 7);
		chessboard.deleteGamepiece(6, 7);
		chessboard.deleteGamepiece(1, 7);
		chessboard.deleteGamepiece(2, 7);
		chessboard.deleteGamepiece(3, 7);
		
		chessboard.moveGamepiece(6, 8, 2, 3);
		
		newbishop = chessboard.findGamepiece(6, 8);
		
		assertEquals(6, newbishop.getX());
		assertEquals(8, newbishop.getY());
	}
	
	@Test
	public void canNotMoveTwoEastTowNorthWhenBlocked() {
		chessboard.deleteGamepiece(5, 2);
		chessboard.deleteGamepiece(8, 2);
		chessboard.deleteGamepiece(7, 2);
		chessboard.deleteGamepiece(6, 2);
		chessboard.deleteGamepiece(1, 2);
		chessboard.deleteGamepiece(2, 2);
		chessboard.deleteGamepiece(3, 2);
		
		chessboard.moveGamepiece(3, 1, 5, 3);
		
		newbishop = chessboard.findGamepiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	@Test
	public void canNotMoveTwoWestTwoSouthWhenBlocked() {
		chessboard.moveGamepiece(6, 8, 5, 6);
		
		newbishop = chessboard.findGamepiece(6, 8);
		
		assertEquals(6, newbishop.getX());
		assertEquals(8, newbishop.getY());
	}
	
	@Test
	public void canNotMoveOnTopOfGamepiece() {
		chessboard.moveGamepiece(3, 1, 4, 2);
		
		newbishop = chessboard.findGamepiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	
	@Test
	public void canNotMoveFourEastThreeNorth() {
		chessboard.deleteGamepiece(5, 2);
		chessboard.deleteGamepiece(4, 2);
		chessboard.deleteGamepiece(8, 2);
		chessboard.deleteGamepiece(7, 2);
		chessboard.deleteGamepiece(6, 2);
		chessboard.deleteGamepiece(1, 2);
		chessboard.deleteGamepiece(2, 2);
		chessboard.deleteGamepiece(3, 2);
		
		chessboard.moveGamepiece(3, 1, 7, 4);
		
		newbishop = chessboard.findGamepiece(3, 1);
		
		assertEquals(3, newbishop.getX());
		assertEquals(1, newbishop.getY());
	}
	
	@Test
	public void canPlayer1BishopCaptureGamepiece() {
		chessboard.deleteGamepiece(4, 2);
		chessboard.deleteGamepiece(4, 7);
		chessboard.moveGamepiece(3, 1, 7, 5);
		chessboard.moveGamepiece(7, 5, 5, 7);
		
		newbishop = chessboard.findGamepiece(5, 7);
		
		assertEquals(5, newbishop.getX());
		assertEquals(7, newbishop.getY());
	}
	
	@Test
	public void canPlayer2BishopCaptureGamepiece() {
		chessboard.deleteGamepiece(4, 2);
		chessboard.deleteGamepiece(4, 7);
		
		chessboard.moveGamepiece(3, 8, 7, 4);
		chessboard.moveGamepiece(7, 4, 5, 2);
		
		newbishop = chessboard.findGamepiece(5, 2);
		
		assertEquals(5, newbishop.getX());
		assertEquals(2, newbishop.getY());
	}

	@Test
	public void canMoveFiveSouthFiveEast() {
		Gamepiece oldBishop = chessboard.findGamepiece(3, 8);
		chessboard.deleteGamepiece(2, 7);
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(5, 2);
		
		chessboard.moveGamepiece(3, 8, 1, 6);
		chessboard.moveGamepiece(1, 6, 6, 1);
		
		newbishop = chessboard.findGamepiece(6, 1);
		
		assertEquals(newbishop, oldBishop);
		
	}
}
