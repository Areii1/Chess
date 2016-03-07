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
	public void canMoveTwoSouth(){
		chessboard.deleteGamepiece(1, 7);
		chessboard.moveGamepiece(1, 8, 1, 6);
		
		rook = chessboard.findGamepiece(1, 6);
		
		assertEquals(1, rook.getX());
		assertEquals(6, rook.getY());
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
	public void canMoveSixWest(){
		chessboard.deleteGamepiece(1, 1);
		chessboard.deleteGamepiece(2, 1);
		chessboard.deleteGamepiece(3, 1);
		chessboard.deleteGamepiece(4, 1);
		chessboard.deleteGamepiece(5, 1);
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(7, 1);
		
		chessboard.moveGamepiece(8, 1, 2, 1);
		
		rook = chessboard.findGamepiece(2, 1);
		
		assertEquals(2, rook.getX());
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
	
	
	@Test
	public void canNotMoveSixEastWhenBlocked(){
		chessboard.deleteGamepiece(3, 1);
		chessboard.deleteGamepiece(4, 1);
		chessboard.deleteGamepiece(5, 1);
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(7, 1);
		chessboard.deleteGamepiece(8, 1);
		
		chessboard.moveGamepiece(1, 1, 7, 1);
		
		rook = chessboard.findGamepiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveFourNorthWhenBlocked(){
		chessboard.moveGamepiece(1, 1, 1, 4);
		
		rook = chessboard.findGamepiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotMoveFourSouthWhenBlocked(){
		chessboard.moveGamepiece(1, 8, 1, 5);
		
		rook = chessboard.findGamepiece(1, 8);
		
		assertEquals(1, rook.getX());
		assertEquals(8, rook.getY());
	}
	
	
	@Test
	public void canNotMoveDiagonally(){
		chessboard.deleteGamepiece(2, 1);
		chessboard.deleteGamepiece(2, 2);
		chessboard.deleteGamepiece(2, 3);
		chessboard.deleteGamepiece(2, 4);
		
		chessboard.moveGamepiece(1, 1, 8, 8);
		
		rook = chessboard.findGamepiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
	
	
	@Test
	public void canNotSkipColumn(){
		chessboard.deleteGamepiece(2, 1);
		chessboard.deleteGamepiece(2, 2);
		chessboard.deleteGamepiece(2, 3);
		chessboard.deleteGamepiece(2, 4);
		
		chessboard.moveGamepiece(1, 1, 2, 4);
		
		rook = chessboard.findGamepiece(1, 1);
		
		//No assertequals??
	}
	
	@Test
	public void canPlayer1RookCaptureGamepiece() {
		chessboard.deleteGamepiece(1, 2);
		chessboard.deleteGamepiece(1, 7);
		
		chessboard.moveGamepiece(1, 1, 1, 8);
		
		rook = chessboard.findGamepiece(1, 8);
		
		assertEquals(1, rook.getX());
		assertEquals(8, rook.getY());
	}
	
	@Test
	public void canPlayer2RookCaptureGamepiece() {
		chessboard.deleteGamepiece(1, 2);
		chessboard.deleteGamepiece(1, 7);
		
		chessboard.moveGamepiece(1, 8, 1, 1);
		
		rook = chessboard.findGamepiece(1, 1);
		
		assertEquals(1, rook.getX());
		assertEquals(1, rook.getY());
	}
}
