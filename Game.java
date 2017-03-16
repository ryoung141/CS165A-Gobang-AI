import java.util.Arrays;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;

public class Game{
    
    public static void main(String [] args){
	String a = "abcdefghijklmnopqrstuvwxyz";
	String [] alphabet = a.split("");
	String a2 = "abcdefghijklmnopqrstuvwxyz";
	String [] balphabet = a2.split("");

	int order = 1;
	int board_size = 11;
	if (args.length >= 1 && args[0].equals("-n")){
	    board_size = Integer.parseInt(args[1]);
	    if (args.length > 2 && args[2].equals("-l")){
		order = 2;
	    }
	}
	else if (args.length >= 1 && args[0].equals("-l")){
	    order = 2;
	    if (args.length > 2 && args[1].equals("-n"))
		board_size = Integer.parseInt(args[2]);
	}
	else
	    board_size = 11;
	final Board board = new Board(board_size);
	final Human human = new Human(board);
	final AI ai = new AI(board);
	Scanner s = new Scanner(System.in);
	//if -l flag taken, computer goes first, otherwise, human goes first
	//two paths, human wait to recieve input, not human, decide move then pass
	//turn back
	int x = 0;
	int y = 0;
	int[] ai_move_store = new int[2];
	System.out.println(board.toString());
	System.out.println("Move played: --");
	if (order == 2){
	    while (board.getWinner() == 0){
		System.out.println("robos turn");
		ai_move_store = ai.move();
		String b = balphabet[ai_move_store[0]];
		//	System.out.println("DEBUGGING: " + "ai_move_store[0]:" + ai_move_store[0]);
		System.out.println(board.toString());
		System.out.println("Move played: " + b + ai_move_store[1]);
		System.out.println("Please enter move: ");
		String h_move = s.next();
		String[]sp = h_move.split("");
		int storage = 0;
		for (int i=0; i<26; i++){
		    if (sp[0].equals(alphabet[i]))
			storage = i;
		}
		y = storage;
		char temp = h_move.charAt(1);
		x = temp - '0';
		if (board.getBoard(true)[x][y] >=0 && board.getWinner() == 0){
		    human.move(x, y);
		}
		System.out.println(board.toString());
		System.out.println("Move played: " + h_move);
		
	    }
	}
	if (order == 1){
	    while (board.getWinner() == 0){
    		System.out.println("Please enter move: ");
		String h_move = s.next();
		String[]sp = h_move.split("");
		int storage = 0;
		for (int i=0; i<26; i++){
		    if (sp[0].equals(alphabet[i]))
			storage = i;
		}
		y = storage;
		char temp = h_move.charAt(1);
		x = temp - '0';
		if (Board.isValid(x, y) == false){
		    System.out.println("Invalid move, terminating program");
		    System.exit(0);
		}
		if (board.getBoard(true)[x][y] >=0 && board.getWinner() == 0){
		    human.move(x, y);
		}
		System.out.println(board.toString());
		System.out.println("Move played: " + h_move);
		System.out.println("robos turn");
		ai_move_store = ai.move();
		String b = balphabet[ai_move_store[1]];
		System.out.println(board.toString());
		System.out.println("Move played: " + b + ai_move_store[0]);
	    }
	}
    }
}
