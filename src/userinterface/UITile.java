package userinterface;

import game.Piece;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class UITile extends Rectangle {
	private int tileX;
	private int tileY;
	private boolean isWhite;
	
	public UITile(boolean isWhite, Piece piece, int x, int y) {
		tileX = x;
		tileY = y;
		this.isWhite = isWhite;
		
		setWidth(80);
		setHeight(80);
		relocate(x * 80, y * 80);
		setFill(isWhite ? Color.AQUAMARINE : Color.DARKGREEN);
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (t.getButton() == MouseButton.SECONDARY) {
					UIChessboard.moveUIPiece(tileX, tileY);
				}
			}
		});
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}
	
	public void highlight() {
		setFill(Color.LIGHTPINK);
	}
	
	public void unHighlight() {
		setFill(isWhite ? Color.AQUAMARINE : Color.DARKGREEN);
	}
}
	