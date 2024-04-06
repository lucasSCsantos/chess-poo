package entities;

public class Board {
	private Square squares[][] = new Square[8][8];
	
	public Board(Piece[] pieces) {
		generateBoard(pieces);
	}
	
	public Square[][] getBoard() {
		return squares;
	}
	
	public Square getSquare(int row, int column) {
		return squares[row][column];
	}
	
	public void printBoard() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
		System.out.println("x a b c d e f g h");
		for (int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(squares[i][j].getChar() + " ");
			}
			System.out.println("");
		}
	}
	
	public void generateBoard(Piece[] pieces) {
		for (Piece piece : pieces) {
			int row = piece.getRow();
			int column = piece.getColumn();
			squares[row][column] = new Square(row + column % 2 == 0 ? Colors.BLACK : Colors.WHITE);
			squares[row][column].setPiece(piece);
			squares[row][column].setPosition(row, column);
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j] == null) {
					squares[i][j] = new Square((i + j) % 2 == 0 ? Colors.BLACK : Colors.WHITE);
					squares[i][j].setSpace();
					squares[i][j].setPosition(i, j);
				}
			}
		}
	}
	
	public void regenerateBoard(Piece[] pieces) {
		System.out.println(pieces.length + "aqui");

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = null;
				squares[i][j] = new Square((i + j) % 2 == 0 ? Colors.BLACK : Colors.WHITE);
				squares[i][j].setSpace();
				squares[i][j].setPosition(i, j);
			}
		}

		for (Piece piece : pieces) {
			int row = piece.getRow();
			int column = piece.getColumn();
			squares[row][column].setPiece(piece);
			squares[row][column].setPosition(row, column);
		}

	}
	
	// public boolean validateMove(int row, int column, Colors color) {
	// 	Square square = squares[row][column];
	// 	Piece piece = square.getPiece();

	// 	if (piece != null) {
	// 		// piece.getColor() == color;
	// 	} else {
	// 		return true;
	// 	}
	// 	// return false;
	// }
}
