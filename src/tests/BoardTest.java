package tests;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import game.*;
import gamepieces.*;
import userDialog.*;
import javax.swing.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();
		chessboard.startNewGame();
		chessboard.deleteGamepiece(1, 2);
		chessboard.deleteGamepiece(2, 2);
		chessboard.deleteGamepiece(1, 7);
		chessboard.deleteGamepiece(2, 7);
		chessboard.render();
		
		
		
		int counter = 0;
		while (counter < 10) {
		player1Notice();
		chessboard.moveGamepiece(askForCurrentXCoordinate(), askForCurrentYCoordinate(),
				askForNewXCoordinate(), askForNewYCoordinate());
		
		player2Notice();
		chessboard.moveGamepiece(askForCurrentXCoordinate(), askForCurrentYCoordinate(),
				askForNewXCoordinate(), askForNewYCoordinate());
		counter ++;
		}
		
		
		/*chessboard.moveGamepiece(1, 2, 1, 3);
		chessboard.save();
		
		chessboard.moveGamepiece(1, 3, 1, 4);
		chessboard.load();1
		chessboard.render();
		
		*/
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
