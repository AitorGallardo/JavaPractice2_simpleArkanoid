package elements;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Game;

public class redBrick extends Brick{

	public redBrick(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
/*		g.setPaint(Color.red);
		super.paint(g);*/
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.setColor(Color.red);
		g.fillRect(x-1, y-1, width, height);
	}
	
	@Override
	public void checkHit() {

	}

	@Override
	public void brickAction() {
		
	}

}
