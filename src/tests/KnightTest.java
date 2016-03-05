package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.Chessboard;
import game.Gamepiece;

public class KnightTest {
	
	private Chessboard chessboard;
	private Gamepiece knight;
	
	
	@Before
	public void init() {
		chessboard = new Chessboard();
		chessboard.startNewGame();
	}
	
	
	@Test
	public void canMoveTwoNorthOneWest(){
		chessboard.moveGamepiece(2, 1, 3, 3);
		
		knight = chessboard.findGamepiece(3, 3);
		
		assertEquals(3, knight.getX());
		assertEquals(3, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoNorthOneEast(){
		chessboard.moveGamepiece(2, 1, 1, 3);
		
		knight = chessboard.findGamepiece(1, 3);
		
		assertEquals(1, knight.getX());
		assertEquals(3, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoSouthOneWest(){
		chessboard.moveGamepiece(2, 8, 3, 6);
		
		knight = chessboard.findGamepiece(3, 6);
		
		assertEquals(3, knight.getX());
		assertEquals(6, knight.getY());	
	}
	
	@Test
	public void canMoveTwoSouthOneEast(){
		chessboard.moveGamepiece(2, 8, 1, 6);
		
		knight = chessboard.findGamepiece(1, 6);
		
		assertEquals(1, knight.getX());
		assertEquals(6, knight.getY());	
	}
	
	
	@Test
	public void canMoveTwoWestOneNorth(){
		chessboard.moveGamepiece(7, 1, 6, 3);
		chessboard.moveGamepiece(6, 3, 4, 4);
		
		knight = chessboard.findGamepiece(4, 4);
		
		assertEquals(4, knight.getX());
		assertEquals(4, knight.getY());	
		
	}
	
	@Test
	public void canMoveTwoEastOneNorth(){
		chessboard.moveGamepiece(7, 1, 6, 3);
		chessboard.moveGamepiece(6, 3, 4, 4);
		chessboard.moveGamepiece(4, 4, 6, 5);
		
		knight = chessboard.findGamepiece(6, 5);
		
		assertEquals(6, knight.getX());
		assertEquals(5, knight.getY());	
		
	}
	
	
	@Test
	public void cantMoveWhenTitleIsBlocked(){
		chessboard.moveGamepiece(3, 2, 3, 3);
		chessboard.moveGamepiece(2, 1, 3, 3);
		
		knight = chessboard.findGamepiece(2, 1);
		
		assertEquals(2, knight.getX());
		assertEquals(1, knight.getY());	
		
	}

}
