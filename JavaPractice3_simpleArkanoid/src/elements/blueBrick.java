package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;


import core.Game;

public class blueBrick extends Brick{
	
	boolean countDownOn = false;
	
	public blueBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 1;
		super.type = "blue";
		// TODO Auto-generated constructor stub
	}
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		int i = 10;
		public void run() {
			countDownOn = true;
			i--;
			System.out.println(i);
			game.raquetSpeedModifier = 3;
			if(i == 0) {
				game.raquetSpeedModifier = 0;
				countDownOn = false;
				myTimer.cancel();
			}
			// game.raquetSpeedModifier = 3;
		}
	};

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
	
			myTimer.schedule(task, 0, 1000);
	
		//game.raquetSpeedModifier = 0;
        try {
        	// game.raquetSpeedModifier = 3;
            // wait(10000);
            // game.raquetSpeedModifier = 0;
        } catch (Exception e) {}
	}
	
	
}
