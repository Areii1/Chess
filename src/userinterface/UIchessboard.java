package userinterface;

import game.Chessboard;
import game.Piece;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class UIchessboard extends Application {
	
	private static Scene scene;
	private static TilePane grid = new TilePane();
	private static Chessboard chessboard = new Chessboard();

	private static int currentPrimaryX;
	private static int currentPrimaryY;
	private static int currentSecondaryX;
	private static int currentSecondaryY;
	
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
	
	private static void renderChessboard() {
		for (int y = 8; y > 0; y--) {
			for (int x = 1; x < 9; x++) {
				Piece gamepiece = chessboard.findPiece(x, y);
				Tile tile = new Tile((x + y) % 2 == 0, gamepiece, x, y);
				grid.getChildren().add(tile);
			}
		}
	}
	
	public static void moveUIGamepiece() {
		chessboard.movePiece(currentPrimaryX, currentPrimaryY, currentSecondaryX, currentSecondaryY);
		System.out.println("moved");
		grid.getChildren().clear();
		
		renderChessboard();
		
	}
	
	public static void chosenGamepieceValues(int x, int y) {
		currentPrimaryX = x;
		currentPrimaryY = y;
	}
	
	public static void chosenTileValues(int tileX, int tileY) {
		currentSecondaryX = tileX;
		currentSecondaryY = tileY;
	}
}