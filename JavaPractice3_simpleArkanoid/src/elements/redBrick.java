package elements;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Game;

public class redBrick extends Brick{

	public redBrick(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}


	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.red);
	}
	
	@Override
	public void checkHit() {

	}

	@Override
	public void brickAction() {
		
	}

}
