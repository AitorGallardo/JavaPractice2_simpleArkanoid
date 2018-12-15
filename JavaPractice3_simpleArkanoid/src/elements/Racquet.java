package elements;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import core.Game;

public class Racquet {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;

	public Racquet(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e, int modifier) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1 - modifier;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1 + modifier;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopSide() {
		return Y - HEIGHT;
	}
	public int getBottomSide() {
		return Y + HEIGHT;
	}
	public int getLeftSide() {
		return x - WIDTH;
	}
	public int getRightSide() {
		return x + WIDTH;
	}
}