package elements;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import core.Game;

public class Ball {
	private static final int DIAMETER = 10; // 30
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	public void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETER) {
			ya = -1; //
			//game.gameOver();
		}
		if (collision()){
			ya = -1;
			y = game.racquet.getTopSide() - DIAMETER/2;
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		//game.brickPack.lastIndexOf(o)
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		// g.fillRect(x, y, DIAMETER, DIAMETER);  // We can use a rectangle to have a clearer view of intersactions
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}