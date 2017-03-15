import java.util.Arrays;
import java.lang.String;

public class Board {
	public static int BOARD_SIZE = 15;

	private int[][] human, ai;
	private int winner;

	public Board() {
	    
		human = new int[BOARD_SIZE][BOARD_SIZE];
		ai = new int[BOARD_SIZE][BOARD_SIZE];
		winner = 0;
	}

    public Board(int s){
	BOARD_SIZE=s;
	System.out.println(BOARD_SIZE);
	human = new int[BOARD_SIZE][BOARD_SIZE];
	ai = new int[BOARD_SIZE][BOARD_SIZE];
	winner = 0;
    }

	@Override
	public Board clone() {
		Board copy = new Board();
		for (int i = 0; i < BOARD_SIZE; i++) {
			copy.getBoard(true)[i] = Arrays.copyOf(getBoard(true)[i],
					BOARD_SIZE);
			copy.getBoard(false)[i] = Arrays.copyOf(getBoard(false)[i],
					BOARD_SIZE);
		}
		copy.setWinner(winner);
		return copy;
	}

	public int[][] getBoard(boolean isHuman) {
		return isHuman ? human : ai;
	}

	public int getBoardValue() {
		int value = 0;
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				if (human[i][j] >= 0)
					value += ai[i][j] - human[i][j];
		return value;
	}

	public int getWinner() {
		return winner;
	}

    public int getSize(){
	return BOARD_SIZE;
    }

	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < BOARD_SIZE && y < BOARD_SIZE;
	}

	public boolean isValidMove(int x, int y) {
		return isValid(x, y) && human[x][y] >= 0;
	}

	public void move(int player, int x, int y) {
	    human[x][y] = player;
	    ai[x][y] = player;
	}

	public void setValue(int player, int x, int y, int value) {
		if (player == Human.HUMAN_PLAYER)
			human[x][y] = value;
		else if (player == AI.AI_PLAYER)
			ai[x][y] = value;
	}

	public void setWinner(int player) {
		winner = player;
	}

    /*	@Override
	public String toString() {
		String print = "   ";
		for (int i = 1; i < BOARD_SIZE; i++){
		    String[] alph = new String[] {"0","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		    print += String.format("%3s", alph[i]);
			
		}
		print += "\n";
		print += "+---+";

		for (int i = 1; i < BOARD_SIZE; i++){
			print += String.format("%3d", i);
			print += "|   ";
			for (int j = 2; j < BOARD_SIZE; j++)
			     print += "---+";
			
				print += String.format("%3s", human[i][j] >= 0 ? "-"
						: human[i][j] == Human.HUMAN_PLAYER ? "L" : "D");
			print += "\n";
		}

		return print;
		}*/


    @Override
    public String toString(){
	String print = "   ";
	for (int i = 0; i< BOARD_SIZE; i++){
	    String[] alph = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	    print += String.format("%4s",alph[i]);
	}
	print += "\n";
	print += "    +---+";
	for (int i = 1; i< BOARD_SIZE; i++){
	    print += "---+";
	}
	print += "\n";
	for (int i=0; i<BOARD_SIZE; i++){
	    if (i>=10)
		print += " "+i+" |";
	    else
		print += "  "+i+" |";
	    for (int j=0; j<BOARD_SIZE; j++){
		print += String.format("%3s", human[i][j] >= 0 ? "   |"
				       : human[i][j] == Human.HUMAN_PLAYER ? " L |" : " D |");
	    }
	    // print += "   |";
	    print += "\n";
	    print += "    +---+";
	    for (int k=2; k<BOARD_SIZE; k++)
		print += "---+";
	    print += "---+";
	    print += "\n";
	}
	return print;
    }
}

