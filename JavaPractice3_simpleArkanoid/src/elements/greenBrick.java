package elements;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Game;

public class greenBrick extends Brick {

	public greenBrick(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
/*		g.setPaint(Color.green);
		super.paint(g);*/
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.setColor(Color.green);
		g.fillRect(x, y, width-1, height-1);
	}
	
	@Override
	public void checkHit() {

	}

	@Override
	public void brickAction() {
		
	}


}
