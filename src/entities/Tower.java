package entities;

public class Tower extends Piece {
	public Tower(int row, int column, Colors color) {
		super(color == Colors.BLACK ? '♖' : '♜', row, column, "Tower", 'T');
	}
}
