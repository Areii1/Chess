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
	
}
