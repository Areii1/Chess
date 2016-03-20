package userinterface;

import game.Chessboard;
import game.Gamepiece;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class UIchessboard extends Application {
	
	Scene scene;
	TilePane grid = new TilePane();
	Chessboard chessboard = new Chessboard();
	
	public static void main(String[] arguments) {
		launch(arguments);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chessboard");
		
		chessboard.startNewGame();
		
		renderChessboard();
		
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setPrefColumns(8);
		grid.setPrefRows(8);		

		scene = new Scene(grid, 660, 660, Color.GRAY);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void renderChessboard() {
		for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
			if (rowIndex % 2 == 0) {
				renderRow(true, rowIndex);
			}
			else {
				renderRow(false, rowIndex);
			}
		}
	}
	
	private void renderRow(boolean startWithWhite, int rowIndex) {
		int counter = 1;
		boolean isWhite;
		if (startWithWhite == true) {
			counter = 0;
		}
		for (int columnIndex = 0; columnIndex < 8; columnIndex++) {
			if (counter % 2 == 0) {
				isWhite = true;
				Gamepiece gamepiece = chessboard.findGamepiece(columnIndex + 1, rowIndex + 1);
				ChessTile whiteTile = new ChessTile(isWhite, gamepiece);
				grid.getChildren().add(whiteTile);
			}
			else {
				isWhite = false;
				Gamepiece gamepiece = chessboard.findGamepiece(columnIndex + 1, rowIndex + 1);
				ChessTile blackTile = new ChessTile(isWhite, gamepiece);
				grid.getChildren().add(blackTile);
			}
			counter++;
		}
	}
}