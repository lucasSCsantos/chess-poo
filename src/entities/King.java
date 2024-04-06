package entities;

public class King extends Piece {
	public King(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♔' : '♚', row, column, "King", 'K');
	}
}
