package tests;

import game.*;
import gamepieces.Pawn;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class Pawntest {
	
	private Chessboard chessboard;
	
	private Gamepiece newPawn;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveOneNorth() {
		chessboard.moveGamepiece(1, 2, 1, 3);
		
		newPawn = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, newPawn.getX());
		assertEquals(3, newPawn.getY());
	}
	
	@Test
	public void canNotMoveOneNorthOneEast() {
		chessboard.moveGamepiece(1, 2, 2, 3);
		
		newPawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthWhenAtStartAndBlocked() {
		chessboard.moveGamepiece(2, 1, 1, 3);
		
		chessboard.moveGamepiece(1, 2, 1, 4);
		
		newPawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canMoveTwoNorthWhenAtStart() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		
		newPawn = chessboard.findGamepiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}

	@Test
	public void canNotMoveOnFriendlyGamepiece() {
		chessboard.moveGamepiece(2, 1, 1, 3);
		chessboard.moveGamepiece(1, 2, 1, 3);
		
		newPawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveThreeNorth() {
		chessboard.moveGamepiece(1, 2, 1, 5);
		
		newPawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthTwoWest() {
		chessboard.moveGamepiece(5, 2, 3, 4);
		
		newPawn = chessboard.findGamepiece(5, 2);
		
		assertEquals(5, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canCaptureOneNorthOneEast() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		chessboard.moveGamepiece(2, 7, 2, 5);
		Gamepiece oldPawn = chessboard.findGamepiece(1, 4);
		chessboard.moveGamepiece(1, 4, 2, 5);
		
		newPawn = chessboard.findGamepiece(2, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneNorthOneWest() {
		chessboard.moveGamepiece(2, 2, 2, 4);
		chessboard.moveGamepiece(1, 7, 1, 5);
		Gamepiece oldPawn = chessboard.findGamepiece(2, 4);
		chessboard.moveGamepiece(2, 4, 1, 5);
		
		newPawn = chessboard.findGamepiece(1, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneSouthOneEast() {
		chessboard.moveGamepiece(6, 2, 6, 4);
		chessboard.moveGamepiece(5, 7, 5, 5);
		Gamepiece oldPawn = chessboard.findGamepiece(5, 5);
		chessboard.moveGamepiece(5, 5, 6, 4);
		
		newPawn = chessboard.findGamepiece(6, 4);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneSouthOneWest() {
		chessboard.moveGamepiece(4, 2, 4, 4);
		chessboard.moveGamepiece(5, 7, 5, 5);
		Gamepiece oldPawn = chessboard.findGamepiece(5, 5);
		chessboard.moveGamepiece(5, 5, 4, 4);
		
		newPawn = chessboard.findGamepiece(4, 4);
		
		assertEquals(newPawn, oldPawn);

	}
	
	@Test
	public void canNotCaptureOneNorth() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		chessboard.moveGamepiece(1, 7, 1, 5);
		chessboard.moveGamepiece(1, 4, 1, 5);
		
		newPawn = chessboard.findGamepiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureThreeNorth() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		chessboard.moveGamepiece(1, 4, 1, 7);
		
		newPawn = chessboard.findGamepiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureThreeSouth() {
		chessboard.moveGamepiece(1, 7, 1, 5);
		chessboard.moveGamepiece(1, 5, 1, 2);
		
		newPawn = chessboard.findGamepiece(1, 5);
		
		assertEquals(1, newPawn.getX());
		assertEquals(5, newPawn.getY());
	}
	
	@Test
	public void canCaptureTwoNorthFromStartPlayer1() {
		chessboard.moveGamepiece(1, 7, 1, 5);
		chessboard.moveGamepiece(1, 5, 1, 4);
		chessboard.moveGamepiece(1, 2, 1, 4);
		
		newPawn = chessboard.findGamepiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canCaptureTwoSouthFromStartPlayer2() {
		chessboard.moveGamepiece(1, 2, 1, 4);
		chessboard.moveGamepiece(1, 4, 1, 5);
		chessboard.moveGamepiece(1, 7, 1, 5);
		
		newPawn = chessboard.findGamepiece(1, 7);
		
		assertEquals(1, newPawn.getX());
		assertEquals(7, newPawn.getY());
	}

	
}
