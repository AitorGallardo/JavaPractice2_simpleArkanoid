package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import core.Game;

public class greenBrick extends Brick {

	public greenBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 3;
		super.type = "green";
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.green);
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
