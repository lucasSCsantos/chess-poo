package entities;

public class Play {
	private char pieceId;
	private int pieceColumn, pieceRow, playColumn, playRow;

	public Play(String piece, String play) {
		this.pieceColumn = translateCommand(piece)[0];
		this.pieceRow = translateCommand(piece)[1];
		this.playColumn = translateCommand(play)[0];
		this.playRow = translateCommand(play)[1];
	}
	
	public char getPieceId() {
		return pieceId;
	}

	public int getPlayColumn() {
		return playColumn;
	}
	
	public int getPlayRow() {
		return playRow;
	}
	
	public int getPieceColumn() {
		return pieceColumn;
	}
	
	public int getPieceRow() {
		return pieceRow;
	}
	
	public int[] translateCommand(String command) {
		char[] translatedPlay = command.toCharArray();
		int column = translateColumn(translatedPlay[0]);
		int row = Character.getNumericValue(translatedPlay[1]) - 1;  
		int[] positions = { column, row };
		return positions;
	}
	
//	private void translatePlay(String play) {
//		char[] translatedPlay = play.toCharArray();
//		
////		if (translatedPlay.length == 2) {
//			//pawn play
//			this.pieceId = 'p';
//			this.column = translateColumn(translatedPlay[0]);
//			this.row = Character.getNumericValue(translatedPlay[1]) - 1;  
////		} else if (translatedPlay.length == 3) {
////			//normal play
////			this.pieceId = translatedPlay[0];
////			this.column = translateColumn(translatedPlay[1]);
////			this.row = Character.getNumericValue(translatedPlay[2]) - 1;  
////		}
//		
//	}
	
	private int translateColumn(char column) {
		   if (column >= 'a' && column <= 'z') {
	            return column - 'a';
		   }
		   return -1;
	}
	
	
}
