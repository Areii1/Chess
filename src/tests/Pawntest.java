package tests;

import game.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Pawntest {
	
	private Chessboard chessboard;
	
	private Gamepiece pawn;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveOneNorth() {
		chessboard.moveGamepiece(1, 2, 1, 3);
		
		pawn = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, pawn.getX());
		assertEquals(3, pawn.getY());
	}
	
	@Test
	public void canNotMoveOneNorthOneEast() {
		chessboard.moveGamepiece(1, 2, 2, 3);
		
		pawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, pawn.getX());
		assertEquals(2, pawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthWhenAtStartAndBlocked() {
		chessboard.moveGamepiece(2, 1, 1, 3);
		
		chessboard.moveGamepiece(1, 2, 1, 4);
		
		pawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, pawn.getX());
		assertEquals(2, pawn.getY());
	}
	
	@Test
	public void canMoveTwoNorthWhenAtStart() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		
		pawn = chessboard.findGamepiece(1, 4);
		
		assertEquals(1, pawn.getX());
		assertEquals(4, pawn.getY());
	}

	@Test
	public void canNotMoveOnTopOfAnotherGamepiece() {
		chessboard.moveGamepiece(2, 1, 1, 3);
		chessboard.moveGamepiece(1, 2, 1, 3);
		
		pawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, pawn.getX());
		assertEquals(2, pawn.getY());
	}
	
	@Test
	public void canNotMoveThreeNorth() {
		chessboard.moveGamepiece(1, 2, 1, 5);
		
		pawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, pawn.getX());
		assertEquals(2, pawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthTwoWest() {
		chessboard.moveGamepiece(5, 2, 3, 4);
		
		pawn = chessboard.findGamepiece(5, 2);
		
		assertEquals(5, pawn.getX());
		assertEquals(2, pawn.getY());
	}
	
	@Test
	public void canCaptureNorthEast() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		chessboard.moveGamepiece(2, 7, 2, 5);
		chessboard.moveGamepiece(1, 4, 2, 5);
		
		pawn = chessboard.findGamepiece(2, 5);
		
		assertEquals(2, pawn.getX());
		assertEquals(5, pawn.getY());
	}
	
	@Test
	public void canCaptureNorthWest() {
		chessboard.moveGamepiece(2, 2, 2, 4);
		chessboard.moveGamepiece(1, 7, 1, 5);
		chessboard.moveGamepiece(2, 4, 1, 5);
		
		pawn = chessboard.findGamepiece(1, 5);
		
		assertEquals(1, pawn.getX());
		assertEquals(5, pawn.getY());
	}
	
	@Test
	public void canCaptureSouthEast() {
		chessboard.moveGamepiece(6, 2, 6, 4);
		chessboard.moveGamepiece(5, 7, 5, 5);
		chessboard.moveGamepiece(5, 5, 6, 4);
		
		pawn = chessboard.findGamepiece(6, 4);
		
		assertEquals(6, pawn.getX());
		assertEquals(4, pawn.getY());
	}
	
	@Test
	public void canCaptureSouthWest() {
		chessboard.moveGamepiece(4, 2, 4, 4);
		chessboard.moveGamepiece(5, 7, 5, 5);
		chessboard.moveGamepiece(5, 5, 4, 4);
		
		pawn = chessboard.findGamepiece(4, 4);
		
		assertEquals(4, pawn.getX());
		assertEquals(4, pawn.getY());
	}
}
