package userinterface;

import game.Gamepiece;
import gamepieces.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ChessTile extends StackPane {
	Rectangle tile;
	
	private Image blackPawn = new Image("/chessicons/black_pawn.png");
	private Image blackRook = new Image("/chessicons/black_rook.png");
	private Image blackKnight = new Image("/chessicons/black_knight.png");
	private Image blackQueen = new Image("/chessicons/black_queen.png");
	private Image blackBishop = new Image("/chessicons/black_bishop.png");
	private Image blackKing = new Image("/chessicons/black_king.png");
	private Image whitePawn = new Image("/chessicons/white_pawn.png");
	private Image whiteRook = new Image("/chessicons/white_rook.png");
	private Image whiteKnight = new Image("/chessicons/white_knight.png");
	private Image whiteQueen = new Image("/chessicons/white_queen.png");
	private Image whiteBishop = new Image("/chessicons/white_bishop.png");
	private Image whiteKing = new Image("/chessicons/white_king.png");


	public ChessTile(boolean isWhite, Gamepiece gamepiece) {				
		if (isWhite) {
			tile = new Rectangle(80, 80, Color.WHITE);
			drawIcon(gamepiece);
			getChildren().addAll(tile);
		}
		else {
			tile = new Rectangle(80, 80, Color.BLACK);
			drawIcon(gamepiece);
			getChildren().addAll(tile);
		}
	}
	
	private void drawIcon(Gamepiece gamepiece) {
		if (gamepiece != null && gamepiece.getPlayer().getId() == 1) {
			if (gamepiece instanceof Pawn) {
				tile.setFill(new ImagePattern(whitePawn));
			}
			else if (gamepiece instanceof Rook) {
				tile.setFill(new ImagePattern(whiteRook));
			}
			else if (gamepiece instanceof Bishop) {
				tile.setFill(new ImagePattern(whiteBishop));
			}
			else if (gamepiece instanceof Knight) {
				tile.setFill(new ImagePattern(whiteKnight));
			}
			else if (gamepiece instanceof Queen) {
				tile.setFill(new ImagePattern(whiteQueen));
			}
			else if (gamepiece instanceof King) {
				tile.setFill(new ImagePattern(whiteKing));
			}
		}
		else {
			if (gamepiece instanceof Pawn) {
				tile.setFill(new ImagePattern(blackPawn));
			}
			else if (gamepiece instanceof Rook) {
				tile.setFill(new ImagePattern(blackRook));
			}
			else if (gamepiece instanceof Bishop) {
				tile.setFill(new ImagePattern(blackBishop));
			}
			else if (gamepiece instanceof Knight) {
				tile.setFill(new ImagePattern(blackKnight));
			}
			else if (gamepiece instanceof Queen) {
				tile.setFill(new ImagePattern(blackQueen));
			}
			else if (gamepiece instanceof King) {
				tile.setFill(new ImagePattern(blackKing));
			}
		}
	}
}
