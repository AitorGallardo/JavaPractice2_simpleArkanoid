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
		
		if(collision()) {
			this.changeBallDirection();
			this.lifes--;
		}
	}


	public void brickAction() {
		
	}
	
	private boolean collision() {
	
		 return (game.ball.getBounds().intersects(getBounds()));
	}
	
	private void changeBallDirection() {
		
			 Rectangle ball = game.ball.getBounds();
			 int ballT = getTopSide(ball.y, ball.height);
			 int ballB = getBottomSide(ball.y, ball.height);
			 int ballL = getLeftSide(ball.x, ball.width);
			 int ballR = getRightSide(ball.x, ball.width);
			 
			 Rectangle thisBrick = this.getBounds();
			 int brickT = getTopSide(thisBrick.y, thisBrick.height);
			 int brickB = getBottomSide(thisBrick.y, thisBrick.height);
			 int brickL = getLeftSide(thisBrick.x, thisBrick.width);
			 int brickR = getRightSide(thisBrick.x, thisBrick.width);
			 
			 if(ballT==brickB) {
				 game.ball.ya = 1;
				 game.ball.y = y + game.ball.ya;
			 } else if(ballB==brickT) {
				 game.ball.ya = -1;
				 game.ball.y = y + game.ball.ya;
			 } else if(ballL == brickR) {
				 game.ball.xa = 1;
				 game.ball.x = x + game.ball.xa;
			 } else if(ballR == brickL) {
				 game.ball.xa = -1;
				 game.ball.x = x + game.ball.xa;
			 }
	}


	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	

	public int getTopSide(int y,int HEIGHT) {
		return y - HEIGHT;
	}
	public int getBottomSide(int y, int HEIGHT) {
		return y + HEIGHT;
	}
	public int getLeftSide(int x, int WIDTH) {
		return x - WIDTH;
	}
	public int getRightSide(int x, int WIDTH) {
		return x + WIDTH;
	}
	
	/*	public int getTopSide() {
			return y - HEIGHT;
		}
		public int getBottomSide() {
			return y + HEIGHT;
		}
		public int getLeftSide() {
			return x - WIDTH;
		}
		public int getRightSide() {
			return x + WIDTH;
		}*/


	
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