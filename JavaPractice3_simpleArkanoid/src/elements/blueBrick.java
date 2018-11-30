package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import core.Game;

public class blueBrick extends Brick{

	
	public blueBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.blue);
	}
	@Override
	public boolean checkHit() {
		return super.checkHit();
	}

	@Override
	public void brickAction() {
		y = y+1;
	}
	
}
