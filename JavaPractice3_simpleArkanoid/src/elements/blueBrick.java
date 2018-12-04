package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;


import core.Game;

public class blueBrick extends Brick{
	
	int countDown = 10;
	
	public blueBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 1;
		super.type = "blue";
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

		if(game.timerActive) {
			game.countDown = 10;
		} else {
			game.timer.schedule(game.setCountDownTask(),0,1000);
		}
        
	}
	
	
}
