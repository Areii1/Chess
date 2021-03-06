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
	private static int chosenPieceY;
	
	private static int turnCounter = 0;
	
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
	
		scene = new Scene(uiBoard, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void renderChessboard() {
		uiBoard.getChildren().clear();
		for (int y = 8; y > 0; y--) {
			for (int x = 1; x < 9; x++) {
				Piece piece = chessApp.findPiece(x, y);
				UITile tile = new UITile((x + y) % 2 == 0, piece, x, y);
				UIPiece uiPiece = new UIPiece(piece, x, y);
				uiBoard.getChildren().addAll(tile, uiPiece);
			}
		}
		if (chessApp.isGameOver()) {
			Stage primaryStage = (Stage) uiBoard.getScene().getWindow();
			primaryStage.close();
		}
		}
	
	public static void moveUIPiece(int newX, int newY) {
		if (chessApp.findPiece(chosenPieceX, chosenPieceY) != null 
			&& ((chessApp.findPiece(chosenPieceX, chosenPieceY).getPlayer().getId() == 1 && (turnCounter % 2 == 0))
			||  (chessApp.findPiece(chosenPieceX, chosenPieceY)).getPlayer().getId() == 2 && (turnCounter % 2 == 1))) {
			
			if (chessApp.movePiece(chosenPieceX, chosenPieceY, newX, newY)) {
				renderChessboard();
				turnCounter++;
			}
		}
	}

	
	public static void choosePieceCoordinates(int x, int y) {
		chosenPieceX = x;
		chosenPieceY = y;
		highlightTile();
	}
	
	private static void highlightTile() {
		for (Object child : uiBoard.getChildren()) {
			if (child instanceof UITile) {
				UITile tile = (UITile) child;
				if (tile.getTileX() == chosenPieceX 
					&& (tile.getTileY() == chosenPieceY)) {
					tile.highlight();
				}
				else {
					tile.unHighlight();
				}
			}
		}
	}
}