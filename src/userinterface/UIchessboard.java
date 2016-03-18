package userinterface;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;

public class UIchessboard extends Application {
	
	Scene scene;
	TilePane grid = new TilePane();
	
	public static void main(String[] arguments) {
		launch(arguments);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chessboard");
		
		renderChessboard();
		
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setPrefColumns(8);
		grid.setPrefRows(8);		

		scene = new Scene(grid, 410, 410, Color.GRAY);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void renderChessboard() {
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				renderRow(true);
			}
			else {
				renderRow(false);
			}
		}
	}
	
	private void renderRow(boolean startWithWhite) {
		int counter = 1;
		if (startWithWhite == true) {
			counter = 0;
		}
		for (int i = 0; i < 8; i++) {	
			if (counter % 2 == 0) {
				grid.getChildren().add(createTile(true));
			}
			else {
				grid.getChildren().add(createTile(false));
			}
			counter++;
		}
	}
	
	
	private Rectangle createTile(boolean isWhite) {
		if (isWhite) {
			return new Rectangle(50, 50, Color.WHITE);
		}
		else { 
			return new Rectangle(50, 50, Color.BLACK);
		}
	}
}