package userinterface;

import game.Chessboard;
import game.Piece;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class UIChessboard extends Application {
	private Scene scene;
	private static Pane uiBoard = new Pane();
	private static Chessboard chessApp = new Chessboard();

	private static int chosenPieceX;
	private static int chosePieceY;
	
	public static void main(String[] arguments) {
		launch(arguments);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chessboard");
		
		chessApp.startNewGame();
		renderChessboard();
		
		uiBoard.setPadding(new Insets(10, 10, 10, 10));
		uiBoard.setPrefSize(800, 800);
	
		scene = new Scene(uiBoard, Color.GRAY);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private static void renderChessboard() {
		uiBoard.getChildren().clear();
		for (int y = 8; y > 0; y--) {
			for (int x = 1; x < 9; x++) {
				Piece piece = chessApp.findPiece(x, y);
				UITile tile = new UITile((x + y) % 2 == 0, piece, x, y);
				UIPiece uiPiece = new UIPiece(piece, x, y);
				uiBoard.getChildren().addAll(tile, uiPiece);
			}
		}
	}
	
	public static void moveUIPiece(int newX, int newY) {
		chessApp.movePiece(chosenPieceX, chosePieceY, newX, newY);
		renderChessboard();
	}
	
	public static void choosePieceCoordinates(int x, int y) {
		chosenPieceX = x;
		chosePieceY = y;
	}
}