package userinterface;

import game.Gamepiece;
import gamepieces.Bishop;
import gamepieces.King;
import gamepieces.Knight;
import gamepieces.Pawn;
import gamepieces.Queen;
import gamepieces.Rook;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ChessTile extends StackPane {
	private Rectangle tile;
	private Gamepiece chesspiece;
	private int tileX;
	private int tileY;
	


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

	public ChessTile(boolean isWhite, Gamepiece gamepiece, int columnIndex, int rowIndex) {	
		chesspiece = gamepiece;
		tileX = columnIndex;
		tileY = rowIndex;
		
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
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (t.getButton() == MouseButton.SECONDARY) {
					System.out.println("tile: " + tileX + "," + tileY);
					UIchessboard.chosenTileValues(tileX, tileY);
					UIchessboard.moveUIGamepiece();
				}
				else {
					if (chesspiece != null) {
						int x = chesspiece.getX();
						int y = chesspiece.getY();
						tile.setStroke(Color.RED);
						System.out.println("gamepiece: " + chesspiece.getX() + ", " + chesspiece.getY());
						UIchessboard.chosenGamepieceValues(x, y);
					}
				}	
				
			}
		});
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
	