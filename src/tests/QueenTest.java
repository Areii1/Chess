package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Gamepiece;


public class QueenTest {
	
	private Chessboard chessboard;
	private Gamepiece queen;
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	
	@Test
	public void canMoveFourNorth(){
		chessboard.deleteGamepiece(5, 2);
		chessboard.moveGamepiece(5, 1, 5, 5);
		
		queen = chessboard.findGamepiece(5, 5);
		
		assertEquals(5, queen.getX());
		assertEquals(5, queen.getY());
	}
	
	
	@Test
	public void canMoveFourSouth(){
		chessboard.deleteGamepiece(5, 7);
		chessboard.moveGamepiece(5, 8, 5, 4);
		
		queen = chessboard.findGamepiece(5, 4);
		
		assertEquals(5, queen.getX());
		assertEquals(4, queen.getY());
	}
	
	
	@Test
	public void canMoveTwoEast(){
		chessboard.deleteGamepiece(6, 1);
		chessboard.deleteGamepiece(7, 1);
		chessboard.moveGamepiece(5, 1, 7, 1);
		
		queen = chessboard.findGamepiece(7, 1);
		
		assertEquals(7, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void canMoveTwoWest(){
		chessboard.deleteGamepiece(4, 1);
		chessboard.deleteGamepiece(3, 1);
		chessboard.moveGamepiece(5, 1, 3, 1);
		
		queen = chessboard.findGamepiece(3, 1);
		
		assertEquals(3, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void canMoveThreeNorthEast(){
		chessboard.deleteGamepiece(6, 2);
		chessboard.moveGamepiece(5, 1, 8, 4);
		
		queen = chessboard.findGamepiece(8, 4);
		
		assertEquals(8, queen.getX());
		assertEquals(4, queen.getY());
	}
	
	
	@Test
	public void canMoveThreeNorthWest(){
		chessboard.deleteGamepiece(4, 2);
		chessboard.moveGamepiece(5, 1, 2, 4);
		
		queen = chessboard.findGamepiece(2, 4);
		
		assertEquals(2, queen.getX());
		assertEquals(4, queen.getY());
		
	}
	
	
	@Test
	public void cantMoveNorthWhenBlocked(){
		chessboard.moveGamepiece(5, 1, 5, 4);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantMoveSouthWhenBlocked(){
		chessboard.moveGamepiece(5, 8, 5, 4);
		
		queen = chessboard.findGamepiece(5, 8);
		
		assertEquals(5, queen.getX());
		assertEquals(8, queen.getY());
	}
	
	
	@Test
	public void cantMoveWestWhenBlocked(){
		chessboard.moveGamepiece(5, 1, 2, 1);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantMoveEastWhenBlocked(){
		chessboard.moveGamepiece(5, 1, 7, 1);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	@Test
	public void cantMoveNorthEastWhenBlockded(){
		chessboard.moveGamepiece(5, 1, 7, 3);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test 
	public void cantMoveNorthWestWhenBlocked(){
		chessboard.moveGamepiece(5, 1, 3, 3);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	
	
	@Test
	public void cantSkipColumn(){
		chessboard.deleteGamepiece(5, 2);
		chessboard.deleteGamepiece(6, 2);
		chessboard.deleteGamepiece(7, 2);
		chessboard.moveGamepiece(5, 1, 6, 3);
		
		queen = chessboard.findGamepiece(5, 1);
		
		assertEquals(5, queen.getX());
		assertEquals(1, queen.getY());
	}
	

}
