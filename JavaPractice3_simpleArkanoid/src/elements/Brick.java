package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import core.Game;

public class Brick {
	protected int x = 0;
	protected int y = 0;
	protected int lifes = 0;
	protected String type = "none";
	protected static final int WIDTH = 20;
	protected static final int HEIGHT = 10;
	protected boolean hasHitRacquetOREndOfScreenOnFall = false; // we use this just in red bricks

	
	protected Game game;

	public Brick(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game= game;
	}

	
	public void paint(Graphics2D g, Color color) {
		g.setColor(color.black);
		g.drawRect(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		g.fillRect(x+1, y+1, WIDTH-1, HEIGHT-1);
	}
	

	public int checkHit() {
		
		if(collision() && lifes > 0) {
			this.changeBallDirection();
			this.lifes--;
		}
		return lifes;
	}
		
	public void brickAction() {
		
	}
	
	public boolean collision() {
		  return (game.ball.getBounds().intersects(getBounds()));
	}

	public void changeBallDirection() {
		
			Rectangle ball = game.ball.getBounds();
				int	ballT = getTopSide(ball.y, ball.height),
					ballB = getBottomSide(ball.y, ball.height),
					ballL = getLeftSide(ball.x, ball.width),
					ballR = getRightSide(ball.x, ball.width);

			Rectangle thisBrick = this.getBounds();
				int brickT = getTopSide(thisBrick.y, thisBrick.height),
					brickB = getBottomSide(thisBrick.y, thisBrick.height),
					brickL = getLeftSide(thisBrick.x, thisBrick.width),
					brickR = getRightSide(thisBrick.x, thisBrick.width);
 
			 if(ballT-brickB == -1) {
				 game.ball.ya = 1;
				
			 } else if(brickT-ballB == -1) {
				 game.ball.ya = -1;
			
			 } else if(ballL-brickR == 4) { 
				 game.ball.xa = 1;
			
			 } else if(brickL-ballR == -6) {
				 game.ball.xa = -1;				 
			 }
	}


	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public int getTopSide(int y,int HEIGHT) {
		return y - HEIGHT/2;
	}
	public int getBottomSide(int y, int HEIGHT) {
		return y + HEIGHT/2;
	}
	public int getLeftSide(int x, int WIDTH) {
		return x - WIDTH/2;
	}
	public int getRightSide(int x, int WIDTH) {
		return x + WIDTH/2;
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


	public int getLifes() {
		return lifes;
	}


	public String getType() {
		return type;
	}


	public boolean isHasHitRacquetOnFall() {
		return hasHitRacquetOREndOfScreenOnFall;
	}
	
	
	
	
	
	
	
	
	
	
	
}