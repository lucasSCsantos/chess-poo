package app;

import java.util.Scanner;
import entities.Board;
import entities.Colors;
import entities.Player;
import entities.Piece;
import entities.Play;
import entities.Game;

public class App {
	public static void main(String[] args) {
		Player player1 = new Player("Lucas", Colors.WHITE);
		Player player2 = new Player("Lucas 2", Colors.BLACK);
		Game game = new Game(player1, player2);
		Board board = new Board(game.getPieces());
		board.printBoard();
		
		game.start();
		
		Scanner sc = new Scanner(System.in);
		while(game.isLive() == true) {
			String playCommand, pieceCommand;

			System.out.println("Please type the coordinates from the piece you want to play");
			pieceCommand = sc.next();
			System.out.println("Please type the coordinates where you want to place your piece in");
			playCommand = sc.next();
			
			Play play = new Play(pieceCommand, playCommand);
			
			boolean playIsSucced = game.actualPlayer().play(play, board);
			
			if (playIsSucced) {		
				board.regenerateBoard(game.getPieces());
				game.changePlayer();
				board.printBoard();
			}
		}
		sc.close();
	}
}
