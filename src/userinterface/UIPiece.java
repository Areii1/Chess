package userinterface;

import game.Piece;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class UIPiece extends Rectangle {
	private int pieceX;
	private int pieceY;
	private Piece chessPiece;
	
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
	
	public UIPiece(Piece piece, int x, int y) {
		pieceX = x;
		pieceY = y;
		chessPiece = piece;
		
		if (piece != null) {
			setWidth(80);
			setHeight(80);
			setFill(getIcon());
			relocate(x * 80, y * 80);
		}

		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (t.getButton() == MouseButton.PRIMARY) {
					if (chessPiece != null) {
						setStroke(Color.RED);
						setStrokeWidth(3);
						UIChessboard.choosePieceCoordinates(pieceX, pieceY);
					}
				}
				else {
					UIChessboard.moveUIPiece(pieceX, pieceY);
				}
			}
		});
	}
	
	private ImagePattern getIcon() {
		if (chessPiece.getPlayer().getId() == 1) {
			if (chessPiece instanceof Pawn) {
				return new ImagePattern(whitePawn);
			}
			else if (chessPiece instanceof Rook) {
				return new ImagePattern(whiteRook);
			}
			else if (chessPiece instanceof Bishop) {
				return new ImagePattern(whiteBishop);
			}
			else if (chessPiece instanceof Knight) {
				return new ImagePattern(whiteKnight);
			}
			else if (chessPiece instanceof Queen) {
				return new ImagePattern(whiteQueen);
			}
			else if (chessPiece instanceof King) {
				return new ImagePattern(whiteKing);
			}
		}
		else {
			if (chessPiece instanceof Pawn) {
				return new ImagePattern(blackPawn);
			}
			else if (chessPiece instanceof Rook) {
				return new ImagePattern(blackRook);
			}
			else if (chessPiece instanceof Bishop) {
				return new ImagePattern(blackBishop);
			}
			else if (chessPiece instanceof Knight) {
				return new ImagePattern(blackKnight);
			}
			else if (chessPiece instanceof Queen) {
				return new ImagePattern(blackQueen);
			}
			else if (chessPiece instanceof King) {
				return new ImagePattern(blackKing);
			}
		}
		return null;
	}
}
