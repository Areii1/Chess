package tests;

import game.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Pawntest {
	
	private Chessboard chessboard;
	
	private Piece newPawn;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveOneNorth() {
		chessboard.movePiece(1, 2, 1, 3);
		
		newPawn = chessboard.findPiece(1, 3);
		
		assertEquals(1, newPawn.getX());
		assertEquals(3, newPawn.getY());
	}
	
	@Test
	public void canNotMoveOneNorthOneEast() {
		chessboard.movePiece(1, 2, 2, 3);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthWhenAtStartAndBlocked() {
		chessboard.movePiece(2, 1, 1, 3);
		
		chessboard.movePiece(1, 2, 1, 4);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canMoveTwoNorthWhenAtStart() {
		chessboard.movePiece(1, 2, 1, 4);
		
		newPawn = chessboard.findPiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}

	@Test
	public void canNotMoveOnFriendlyGamepiece() {
		chessboard.movePiece(2, 1, 1, 3);
		chessboard.movePiece(1, 2, 1, 3);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveThreeNorth() {
		chessboard.movePiece(1, 2, 1, 5);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotMoveTwoNorthTwoWest() {
		chessboard.movePiece(5, 2, 3, 4);
		
		newPawn = chessboard.findPiece(5, 2);
		
		assertEquals(5, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canCaptureOneNorthOneEast() {
		chessboard.movePiece(1, 2, 1, 4);
		chessboard.movePiece(2, 7, 2, 5);
		Piece oldPawn = chessboard.findPiece(1, 4);
		chessboard.movePiece(1, 4, 2, 5);
		
		newPawn = chessboard.findPiece(2, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneNorthOneWest() {
		chessboard.movePiece(2, 2, 2, 4);
		chessboard.movePiece(1, 7, 1, 5);
		Piece oldPawn = chessboard.findPiece(2, 4);
		chessboard.movePiece(2, 4, 1, 5);
		
		newPawn = chessboard.findPiece(1, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneSouthOneEast() {
		chessboard.movePiece(6, 2, 6, 4);
		chessboard.movePiece(5, 7, 5, 5);
		Piece oldPawn = chessboard.findPiece(5, 5);
		chessboard.movePiece(5, 5, 6, 4);
		
		newPawn = chessboard.findPiece(6, 4);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneSouthOneWest() {
		chessboard.movePiece(4, 2, 4, 4);
		chessboard.movePiece(5, 7, 5, 5);
		Piece oldPawn = chessboard.findPiece(5, 5);
		chessboard.movePiece(5, 5, 4, 4);
		
		newPawn = chessboard.findPiece(4, 4);
		
		assertEquals(newPawn, oldPawn);

	}
	
	@Test
	public void canNotCaptureOneNorth() {
		chessboard.movePiece(1, 2, 1, 4);
		chessboard.movePiece(1, 7, 1, 5);
		chessboard.movePiece(1, 4, 1, 5);
		
		newPawn = chessboard.findPiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureThreeNorth() {
		chessboard.movePiece(1, 2, 1, 4);
		chessboard.movePiece(1, 4, 1, 7);
		
		newPawn = chessboard.findPiece(1, 4);
		
		assertEquals(1, newPawn.getX());
		assertEquals(4, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureThreeSouth() {
		chessboard.movePiece(1, 7, 1, 5);
		chessboard.movePiece(1, 5, 1, 2);
		
		newPawn = chessboard.findPiece(1, 5);
		
		assertEquals(1, newPawn.getX());
		assertEquals(5, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureTwoNorthFromStartPlayer1() {
		chessboard.movePiece(1, 7, 1, 5);
		chessboard.movePiece(1, 5, 1, 4);
		chessboard.movePiece(1, 2, 1, 4);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(1, newPawn.getX());
		assertEquals(2, newPawn.getY());
	}
	
	@Test
	public void canNotCaptureTwoSouthFromStartPlayer2() {
		chessboard.movePiece(1, 2, 1, 4);
		chessboard.movePiece(1, 4, 1, 5);
		chessboard.movePiece(1, 7, 1, 5);
		
		newPawn = chessboard.findPiece(1, 7);
		
		assertEquals(1, newPawn.getX());
		assertEquals(7, newPawn.getY());
	}

	@Test
	public void canCaptureOneNorthOneWestInMidPosition() {
		chessboard.movePiece(5, 2, 5, 4);
		chessboard.movePiece(4, 7, 4, 5);
		Piece oldPawn = chessboard.findPiece(5, 4);
		chessboard.movePiece(5, 4, 4, 5);
		
		newPawn = chessboard.findPiece(4, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canCaptureOneSouthOneWestInMidPosition() {
		chessboard.movePiece(5, 2, 5, 4);
		chessboard.movePiece(4, 7, 4, 5);
		chessboard.movePiece(5, 4, 4, 5);
		chessboard.movePiece(5, 7, 5, 6);
		Piece oldPawn = chessboard.findPiece(5, 6);
		chessboard.movePiece(5, 6, 4, 5);
		
		newPawn = chessboard.findPiece(4, 5);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureFriendlyOneSouth() {
		Piece oldPawn = chessboard.findPiece(1, 2);
		chessboard.movePiece(1, 2, 1, 1);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureFriendlyOneSouthOneEast() {
		Piece oldPawn = chessboard.findPiece(1, 2);
		chessboard.movePiece(1, 2, 2, 1);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureFriendlyOneNorth() {
		Piece oldPawn = chessboard.findPiece(1, 7);
		chessboard.movePiece(1, 7, 1, 8);
		
		newPawn = chessboard.findPiece(1, 7);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureFriendlyOneNorthOneWest() {
		Piece oldPawn = chessboard.findPiece(1, 7);
		chessboard.movePiece(1, 7, 2, 8);
		
		newPawn = chessboard.findPiece(1, 7);
		
		assertEquals(newPawn, oldPawn);
		
	}
	
	@Test
	public void canNotCaptureOverFriendly() {
		chessboard.movePiece(1, 2, 1, 4);
		
		
		chessboard.movePiece(2, 2, 2, 4);
		chessboard.movePiece(2, 4, 2, 5);
		
		chessboard.movePiece(3, 7, 3, 6);
		Piece oldPawn = chessboard.findPiece(1, 4);
	
		chessboard.movePiece(1, 4, 3, 6);
		
		newPawn = chessboard.findPiece(1, 4);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureMoreThanOneTileAway() {
		Piece oldPawn = chessboard.findPiece(1, 2);
		chessboard.movePiece(1, 2, 6, 7);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotMoveOneNorthFourEast() {
		Piece oldPawn = chessboard.findPiece(1, 2);
		chessboard.movePiece(1, 2, 5, 3);
		
		newPawn = chessboard.findPiece(1, 2);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotMoveTwoSouthWhenNotAtStartPlayer2() {
		Piece oldPawn = chessboard.findPiece(4, 7);
		chessboard.movePiece(4, 7, 4, 6);
		chessboard.movePiece(4, 6, 4, 4);
		
		newPawn = chessboard.findPiece(4, 6);
		
		assertEquals(newPawn, oldPawn);
	}
	
	@Test
	public void canNotCaptureOneNorthOneWestPlayer2() {
		Piece oldPawn = chessboard.findPiece(2, 7);
		chessboard.deletePiece(1, 7);
		chessboard.deletePiece(1, 8);
		chessboard.deletePiece(1, 2);
		
		chessboard.movePiece(1, 1, 1, 8);
		chessboard.movePiece(2, 7, 1, 8);
		
		newPawn = chessboard.findPiece(2, 7);
		
		assertEquals(newPawn, oldPawn);
	}
	
}
