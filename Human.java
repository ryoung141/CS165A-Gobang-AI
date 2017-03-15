public class Human extends Player {
	public static final int HUMAN_PLAYER = -1;

	private Board game;

	public Human(Board game) {
		this.game = game;
	}

	public void move(int x, int y) {
		super.move(game, HUMAN_PLAYER, x, y);
	}
}
