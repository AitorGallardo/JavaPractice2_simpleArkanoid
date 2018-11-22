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
	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.blue);
	}
	
	@Override
	public void checkHit() {
		super.checkHit();
	}

	@Override
	public void brickAction() {
		
	}

}
