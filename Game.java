import java.util.Arrays;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;

public class Game{
    
    public static void main(String [] args){
	String a = "0abcdefghijklmnopqrstuvwxyz";
	String [] alphabet = a.split("");
	String a2 = "abcdefghijklmnopqrstuvwxyz";
	String [] balphabet = a2.split("");

	int order = 1;
	int board_size = 0;
	if (args.length >= 1 && args[0].equals("-n")){
	    board_size = Integer.parseInt(args[1]);
	    if (args.length >= 2 && args[2].equals("-l")){
		order = 2;
	    }
	}
	else if (args.length >= 1 && args[0].equals("-l")){
	    order = 2;
	    if (args.length >= 2 && args[1].equals("-n"))
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
		//TODO: print given moves and board
		/*	else{
			System.out.println("Error: invalid input");
		    System.out.println("Input should be of the format: letternumber");
		    System.out.println("EX: a5");
		    System.out.println("Please enter move: ");
		    h_move = input.next();
		    char letter = h_move.charAt(0);
		    if(letter >= 'A' && letter <='Z')
		    x = (int) letter - 'A' + 1;
		    if(letter >= 'a' && letter <= 'z')
		    x = (int) letter - 'a' + 1;
			y = Integer.parseInt(h_move[1]);
		    if (board.getBoard(true)[x][y] >=0 && board.getWinner() == 0)
		    human.move(x, y);
			} */
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
		if (board.getBoard(true)[x][y] >=0 && board.getWinner() == 0){
		    human.move(x, y);
		}
		System.out.println(board.toString());
		System.out.println("Move played: " + h_move);
		System.out.println("robos turn");
		ai_move_store = ai.move();
		String b = balphabet[ai_move_store[0]];
		System.out.println(board.toString());
		System.out.print("Move played: " + b + ai_move_store[1]);
		//TODO: print given moves and board
		}
	}
    }
}
