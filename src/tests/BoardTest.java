package tests;

import javax.swing.JOptionPane;

import game.Chessboard;

public class BoardTest {
	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
		
		playerNotice("Do you want to start a new game or load old game?", "Welcome");
		chessboard.newGame(askNewOrLoad("Press 1 to play a new game or press 2 to load old."));
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
			playerNotice("It is your turn!", player);
			chessboard.moveGamepiece(askForCoordinate(player + ": Give the x value of the gamepiece you want to move"),
					askForCoordinate(player + ": Give the y value of the gamepiece you want to move"),
					askForCoordinate(player + ": Assign a new x value for the given gamepiece"),
					askForCoordinate(player + ": Assign a new x value for the given gamepiece"));
			counter++;
		}
	}
	
	public static void playerNotice(String message, String player) {
		JOptionPane.showMessageDialog(null, message, player, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static int askNewOrLoad(String message){
		int value = 0;
		try {
			while (value < 1 || value > 2){
				String userInput = JOptionPane.showInputDialog(null, message);
				if ( userInput == null || (userInput!= null && ("".equals(userInput)))){
					return 0;
				}
				else {
					value = Integer.parseInt(userInput);
				}
			}
		}
			catch (NumberFormatException e) {
				System.out.println("Give a number");
			}
			return value;
	}

	public static int askForCoordinate(String message) {
		int value = 0;
		try {
			while (value < 1 || value > 8) {
				String userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null || (userInput != null && ("".equals(userInput)))) {
					return 0;
				}
				
				else {
					value = Integer.parseInt(userInput);
				}

			}
		}
		catch (NumberFormatException e) {
			System.out.println("Give a number");
		}
		
		
		return value;
	}
}
