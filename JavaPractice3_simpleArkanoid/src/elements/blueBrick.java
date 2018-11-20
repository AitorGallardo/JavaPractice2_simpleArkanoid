package elements;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Game;

public class blueBrick extends Brick{

	
	public blueBrick(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
/*		g.setPaint(Color.blue);
		super.paint(g);*/
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.setColor(Color.blue);
		g.fillRect(x-1, y-1, width, height);
	}
	
	@Override
	public void checkHit() {

	}

	@Override
	public void brickAction() {
		
	}

}
