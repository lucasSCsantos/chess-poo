package entities;

public class Queen extends Piece {
	public Queen(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♕' : '♛', row, column, "Queen", 'Q');
	}
}
