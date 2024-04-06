package entities;

public class Pawn extends Piece {
	public Pawn(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♙' : '♟', row, column, "Pawn", 'p');
	}
}
