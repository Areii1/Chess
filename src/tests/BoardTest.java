package tests;

import javax.swing.JOptionPane;

import game.*;
import gamepieces.*;
import userDialog.*;
import javax.swing.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
//		
//		player1Notice();
//		chessboard.moveGamepiece(findGamepiece(askForCurrentXCoordinate(), askForCurrentYCoordinate), askForNewXCoordinate(), askForNewYCoordinate());
		
		chessboard.startNewGame();
		
	}
	
	public static void player1Notice() {
		JOptionPane.showMessageDialog(null, "Player 1 it is your turn");
	}
	
	public static void player2Notice() {
		JOptionPane.showMessageDialog(null, "Player 2 it is your turn");
	}


	public static int askForCurrentXCoordinate() {
		String textX = JOptionPane.showInputDialog("Give the x value of the gamepiece you want to move");
		int x = Integer.parseInt(textX);
		return x;
	}
	
	public static int askForCurrentYCoordinate() {
		String textY = JOptionPane.showInputDialog("Give the y value of the gamepiece you want to move");
		int y = Integer.parseInt(textY);
		return y;
	}
	
	public static int askForNewXCoordinate() {
		String textX = JOptionPane.showInputDialog("Assign a new x value for the given gamepiece");
		int newX = Integer.parseInt(textX);
		return newX;
	}
	
	public static int askForNewYCoordinate() {
		String textY = JOptionPane.showInputDialog("Assign a new y value fot the given gamepiece");
		int newY = Integer.parseInt(textY);
		return newY;
	}
	
}
