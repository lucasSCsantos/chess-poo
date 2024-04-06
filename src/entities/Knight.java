package entities;

public class Knight extends Piece {
	public Knight(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♘' : '♞', row, column, "Knight", 'C');
	}
}
