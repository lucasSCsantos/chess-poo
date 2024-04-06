package entities;

public class Piece {
	private char character;
	private char id;
	private int row, column;
	private String name;
	private boolean alive;
	private String[] moveHistory = new String[99];
	
	public Piece(char character, int row, int column, String name, char id) {
		this.character = character;
		this.row = row;
		this.column = column;
		this.name = name;
		this.alive = true;
		this.id = id;
	}
	
	public void kill() {
		this.alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	
	public char getChar() {
		return character;
	}
	
	public char getId() {
		return id;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

	public String[] getMoveHistory() {
		return moveHistory;
	}
	
	public void setInMoveHistory(String move) {
		for (int i = 0; i < moveHistory.length; i += 1) {
			if (moveHistory[i] == null) {
				moveHistory[i] = move;
				break;
			}
		}
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public boolean validateMove(int newRow, int newColumn, Colors color) {
		
		if (newRow > 7 || newRow < 0 || newColumn > 7 || newColumn < 0) {
			return false;
		}
		
		int rowDifference = Math.abs(newRow - row), columnDifference = Math.abs(newColumn - column);
		
		boolean isHorizontal = (rowDifference == 0 && columnDifference > 0) || (rowDifference > 0 && columnDifference == 0);
		boolean isDiagonal = rowDifference > 0 && columnDifference > 0 && columnDifference == rowDifference;
		boolean isL = (rowDifference == 1 && columnDifference == 2) || (rowDifference == 2 && columnDifference == 1);
		boolean isKing = (rowDifference == 1 || rowDifference == 0) && (columnDifference == 1 && columnDifference == 0);
		boolean pawnColor = color == Colors.BLACK ? newRow > row : newRow < row;
		boolean isPawn = moveHistory[0] == null ? pawnColor && (rowDifference == 1 || rowDifference == 2) && (columnDifference == 0) : pawnColor && rowDifference == 1 && columnDifference == 0;
//		se horizontal:
//			row muda e coluna nao ou coluna muda e row nao
		if (name == "Tower" && isHorizontal) {
			return true;
		}
//		se diagonal: 
//			a diferença de row (absoluta) - a diferença de coluna (absoluta) = 0;
		if (name == "Bishop" && isDiagonal) {
			return true;
		}
//		se L:
//			a diferença de row absoluta é 1 e coluna absoluta é 2, ou row absoluta é 2 e coluna é 1
		if (name == "Knight" && isL) {
			return true;
		}
//		(rainha) se é horizontal ou diagonal
		if (name == "Queen" && (isDiagonal || isHorizontal)) {
			return true;
		}
//		se rei:
//			a diferença de row absoluta é 1 ou 0 e diferença de coluna absoluta é 1 ou 0
		if (name == "King" && isKing) {
			return true;
		}
//		se peao:
//			se game.getRound() == 1 e é branco a diferença de row é exatamente -2 ou -1 e se é preta exatamente 1 ou 2
//			se nao for round 1, então se é branca a diferença é -1 e preta a diferença é 1
		if (name == "Pawn" && isPawn) {
			return true;
		}
		
		return false;
	}
}
