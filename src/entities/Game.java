package entities;

public class Game {
	private boolean live;
	private Player player1, player2, winner;
	private Piece[] pieces;
	private int round = 1;
	private Colors turn;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.pieces = concatPieces(player1.getPieces(), player2.getPieces());
		this.live = false;
		this.turn = Colors.WHITE;
	}
	
	public boolean isLive() {
		return live;
	}
	
//	public void updatePieces() {
//		this.pieces = concatPieces(player1.getPieces(), player2.getPieces());
//	}
	
	public int getRound() {
		return round;
	}
	
	public Piece[] getPieces() {
		return pieces;
	}

	public void start() {
		if (player1 != null && player2 != null) {
			this.live = true;
		}
	}
	
	public Player actualPlayer() {
		if (turn == Colors.WHITE) {
			return player1;
		}
		return player2;
	}
	
	public void changePlayer() {
		
		if (Colors.BLACK == turn) round += 1;
		
		this.turn = Colors.WHITE == turn ? Colors.BLACK : Colors.WHITE;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public Piece[] concatPieces(Piece[] pieces1, Piece[] pieces2) {
		Piece[] pieces = new Piece[pieces1.length + pieces2.length];
	        
        System.arraycopy(pieces1, 0, pieces, 0, pieces1.length);
        System.arraycopy(pieces2, 0, pieces, pieces1.length, pieces2.length);

        
        return pieces;
	}
}
