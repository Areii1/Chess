package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Gamepiece;

public class Rooktest {

	private Chessboard chessboard;
	private Gamepiece rook;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	@Test
	public void canMoveTwoNorth () {
		chessboard.deleteGamepiece(1, 2);
		chessboard.moveGamepiece(1, 1, 1, 3);
		
		rook = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, rook.getX());
		assertEquals(3, rook.getY());
	}
	
	@Test
	public void canMoveSixEast() {
		chessboard.deleteGamepiece(2, 1);
		chessboard.deleteGamepiece(3, 1);
		chessboard.deleteGamepiece(4, 1);
		chessboard.deleteGamepiece(5, 1);
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(7, 1);
		chessboard.deleteGamepiece(8, 1);
		
		chessboard.moveGamepiece(1, 1, 7, 1);
		
		rook = chessboard.findGamepiece(7, 1);
		
		assertEquals(7, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	@Test
	public void canNotMoveSixWestWhenBlocked() {
		chessboard.deleteGamepiece(1, 1);
		chessboard.deleteGamepiece(2, 1);
		chessboard.deleteGamepiece(3, 1);
		chessboard.deleteGamepiece(4, 1);
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(7, 1);
		
		chessboard.moveGamepiece(8, 1, 2, 1);
		
		rook = chessboard.findGamepiece(8, 1);
		
		assertEquals(8, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
}
