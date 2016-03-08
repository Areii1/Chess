package tests;

import javax.swing.JOptionPane;
import game.*;

public class BoardTest {
	
	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
		chessboard.startNewGame();
		chessboard.render();

		while (!chessboard.isGameOver()) {
			playerNotice("Player1 it is your turn!");
			chessboard.moveGamepiece(askForCoordinate("Player1: Give the x value of the gamepiece you want to move"),
					askForCoordinate("Player1: Give the y value of the gamepiece you want to move"),
					askForCoordinate("Player1: Assign a new x value for the given gamepiece"),
					askForCoordinate("Player1: Assign a new x value for the given gamepiece"));;
			
			playerNotice("Player2 it is your turn!");
			chessboard.moveGamepiece(askForCoordinate("Player2: Give the x value of the gamepiece you want to move"),
					askForCoordinate("Player2: Give the y value of the gamepiece you want to move"),
					askForCoordinate("Player2: Assign a new x value for the given gamepiece"),
					askForCoordinate("Player2: Assign a new x value for the given gamepiece"));
		}
	}
	
	public static void playerNotice(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static int askForCoordinate(String message) {
		String userInput = JOptionPane.showInputDialog(null, message);
		int value = Integer.parseInt(userInput);
		return value;
	}
}
