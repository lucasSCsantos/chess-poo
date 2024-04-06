package entities;

public class Bishop extends Piece {
	public Bishop(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♗' : '♝', row, column, "Bishop", 'B');
	}
}
