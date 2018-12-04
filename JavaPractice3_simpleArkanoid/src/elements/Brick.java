package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import core.Game;

public class Brick {
	protected int x = 0;
	protected int y = 0;
	protected int lifes = 0;
	protected String type = "none";
	protected static final int WIDTH = 20;
	protected static final int HEIGHT = 10;
	protected boolean hasHitRacquetOnFall = false; // we use this just in red bricks
	
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
	

	public boolean checkHit() {
		
		if(collision() && lifes > 0) {
			this.changeBallDirection();
			this.lifes--;
			return true;
		}
		return false;
	}
		
	public void brickAction() {
		
	}
	
	public boolean collision() {
		  return (game.ball.getBounds().intersects(getBounds()));
	}

	public void changeBallDirection() {
		
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
			 
			 // Messages to check hitting						
			 String touchingTopBrickandBottomBall = "TOP_BRICK - BOTTOM_BALL: " + (brickT-ballB);
			 String touchingBottomBrickandTopBall = "BOTTOM_BRICK - TOP_BALL: " + (ballT-brickB);
			 String touchingLeftBallandRightBrick = "LEFT_BALL - RIGHT_BRICK: " + (ballL-brickR);
			 String touchingRighttBallandLeftBrick = "RIGHT_BALL - LEFT_BRICK: " + (brickL-ballR);

			 /*JOptionPane.showMessageDialog(null, touchingTopBrickandBottomBall);
			 JOptionPane.showMessageDialog(null, touchingBottomBrickandTopBall);
			 JOptionPane.showMessageDialog(null, touchingLeftBallandRightBrick);
			 JOptionPane.showMessageDialog(null, touchingRighttBallandLeftBrick);*/
			 
			 
			 
			// HARCODED INTERSECTION RANGE
			 if(ballT-brickB == -1) {
				 // JOptionPane.showMessageDialog(null, touchingBottomBrickandTopBall);
				 game.ball.ya = 1;
				
			 } else if(brickT-ballB == -1) {
				 // JOptionPane.showMessageDialog(null, touchingTopBrickandBottomBall);
				 game.ball.ya = -1;
			
			 } else if(ballL-brickR == 4) { 
				 // JOptionPane.showMessageDialog(null, touchingLeftBallandRightBrick);
				 game.ball.xa = 1;
			
			 } else if(brickL-ballR == -6) {
				  // JOptionPane.showMessageDialog(null, touchingRighttBallandLeftBrick);
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


	public int getLifes() {
		return lifes;
	}


	public String getType() {
		return type;
	}


	public boolean isHasHitRacquetOnFall() {
		return hasHitRacquetOnFall;
	}
	
	
	
	
	
	
	
	
	
	
	
}