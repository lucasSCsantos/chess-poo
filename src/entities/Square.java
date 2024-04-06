package entities;

public class Square {
	private Colors color;
	private int column, row;
	private boolean isEmpty;
	private Piece piece;
	private char black = '■', white = '□';

	public Square(Colors color) {
		this.color = color;
	}
	
	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		this.isEmpty = false;
	}
	
	public void setSpace() {
		this.piece = null;
		this.isEmpty = true;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public char getChar() {
		if (piece != null) {			
			return piece.getChar();
		}
		if (color == Colors.BLACK) {
			return black;
		}
		return white;
	}
}
