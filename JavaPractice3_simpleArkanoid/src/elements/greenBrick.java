package elements;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Game;

public class greenBrick extends Brick {

	public greenBrick(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.green);
	}
	
	@Override
	public void checkHit() {
		super.checkHit();
	}

	@Override
	public void brickAction() {
		
	}


}
