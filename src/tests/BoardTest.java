package tests;

import javax.swing.JOptionPane;
import game.*;

public class BoardTest {
	
	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
		chessboard.startNewGame();
		chessboard.render();
		
		int counter = 0;
		while (!chessboard.isGameOver()) {
			String player;
			if (counter % 2 == 0) {
				player = "player1";
			}
			else {
				player = "player2";
			}
			playerNotice(player + ": it is your turn!");
			chessboard.moveGamepiece(askForCoordinate(player + ": Give the x value of the gamepiece you want to move"),
					askForCoordinate(player + ": Give the y value of the gamepiece you want to move"),
					askForCoordinate(player + ": Assign a new x value for the given gamepiece"),
					askForCoordinate(player + ": Assign a new x value for the given gamepiece"));
			counter++;
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
