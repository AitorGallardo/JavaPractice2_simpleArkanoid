package elements;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import core.Game;

public class Brick {
	private int x = 0;
	private int y = 0;
	private int lifes = 0;
	private int width = 100;
	private int height = 50;
	private Game game;

	public Brick(Game game, int newX, int newY, int lifes) {
		this.x = newX;
		this.y = newY;
		this.lifes = lifes;
		this.game= game;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}

	public void checkHit() {

	}

	public void brickAction() {
		
	}
}