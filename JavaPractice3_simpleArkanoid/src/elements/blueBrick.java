package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;


import core.Game;

public class blueBrick extends Brick{

	
	public blueBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 1;
		super.type = "blue";
		// TODO Auto-generated constructor stub
	}
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		
		public void run() {
			game.raquetSpeedModifier = 3;
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
		//myTimer.schedule(task, 0, 10000);
		//game.raquetSpeedModifier = 0;
        try {
        	game.raquetSpeedModifier = 3;
            wait(10000);
            game.raquetSpeedModifier = 0;
        } catch (Exception e) {}
	}
	
	
}
