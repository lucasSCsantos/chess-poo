package entities;

import java.util.Arrays;

public class Player {
	private Colors color;
	private String name;
	private Piece pieces[] = new Piece[16];
	
	public Player(String name, Colors color) {
		this.color = color;
		this.name = name;
		setPieces();
	}
	
	public Piece[] getPieces() {
		return pieces;
	}
	
	public Piece getPieceByLocation(int row, int column) {
//		return pieces.find(where char equal a character);
		Piece foundPiece = null;
		for (Piece piece : pieces) {	
			if (piece.getRow() == row && piece.getColumn() == column) {
				foundPiece = piece;
				break;
			}
		}
		
		if (foundPiece == null) {
			return null;
		}
		
		return foundPiece;
	}
	
	private void setPieces() {
		int startRow = color == Colors.BLACK ? 0 : 7;
		int pawnStartRow = color == Colors.BLACK ? 1 : 6;
		
		for (int i = 0; i < pieces.length; i++) {
			if (i == 0) {
				pieces[i] = new Tower(startRow, i, color);
				pieces[7 - i] = new Tower(startRow, 7, color);
			} else if (i == 1) {
				pieces[i] = new Bishop(startRow, i, color);
				pieces[7 - i] = new Bishop(startRow, 7 - i, color);
			} else if (i == 2) {
				pieces[i] = new Knight(startRow, i, color);
				pieces[7 - i] = new Knight(startRow, 7 - i, color);
			} else if (i == 3) {
				pieces[i] = new Queen(startRow, i, color);
			} else if (i == 4) {
				pieces[i] = new King(startRow, i, color);
			} else if (i > 7) {
				pieces[i] = new Pawn(pawnStartRow, i - 8, color);
			}
		}
	}
	
	public boolean play(Play play, Game game, Board board) {
		boolean isSucced = false;
		Piece piece = getPieceByLocation(play.getPieceRow(), play.getPieceColumn());
		
		if (piece != null) {
				boolean canMove = piece.validateMove(play.getPlayRow(), play.getPlayColumn(), game.getRound(), color) ;
//							&& 
//								board.validateMove(play.getPosition());
				if (canMove) {
					piece.setColumn(play.getPlayColumn());
					piece.setRow(play.getPlayRow());
					isSucced = true;
				}
		} else {
			System.out.println("There is no piece in this coordenates");
		}
		
		if (isSucced == false) {
			System.out.println("This piece cannot do this move");
		}
		
		return isSucced;
	}
	
}
