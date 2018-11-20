package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import core.Game;

public class Brick {
	protected int x = 0;
	protected int y = 0;
	protected int lifes = 0;
	private static final int WIDTH = 20;
	private static final int HEIGHT = 10;
	protected Game game;

	public Brick(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.lifes = lifes;
		this.game= game;
	}

	
	public void paint(Graphics2D g, Color color) {
		g.setColor(color.black);
		g.drawRect(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		g.fillRect(x+1, y+1, WIDTH-1, HEIGHT-1);
	}
	

	public void checkHit() {

	}


	public void brickAction() {
		
	}


	
	// GETTERS&SETTERS
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return WIDTH;
	}


	public int getHeight() {
		return HEIGHT;
	}
	
	
	
	
	
	
}