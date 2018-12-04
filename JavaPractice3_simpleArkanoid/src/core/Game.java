package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elements.Ball;
import elements.Brick;
import elements.Racquet;
import elements.blueBrick;
import elements.greenBrick;
import elements.redBrick;

@SuppressWarnings("serial") // QUE ES ???
public class Game extends JPanel {

	public Ball ball = new Ball(this);
	public Racquet racquet = new Racquet(this);
	public ArrayList<Brick> brickPack = new ArrayList<Brick>();
	Color color;
	
	public int raquetSpeedModifier = 0;
	public int lifes = 3;
	
	
	// Timer. We need to create it in the main class cause if we create it in brick class and we delete the brick we cant manage that specific tasker to reset or finish it
	public Timer timer = new Timer();
	
	public boolean timerActive = false; // Handles wheter we have an active count. If we already have one we reset countdown
	public int countDown; 
	
	public TimerTask setCountDownTask() {
		countDown = 10;
		
		TimerTask task = new TimerTask() {	
			
			@Override
			public void run() {
				raquetSpeedModifier = 3;
				countDown--;
				timerActive = true;				
				System.out.println(countDown);
				if(countDown == 0) {
					timerActive = false;
					raquetSpeedModifier = 0;
					this.cancel();
				}
			}
		};
		
		return task;
	}

	

	public Game() {
		
		fillBrickList();
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e, raquetSpeedModifier);
			}
		});
		setFocusable(true);
	}
	
	
    private void fillBrickList() {
        
        Random random = new Random();
        
        int x = 40, // fullwidth: 300; margin: 50 => x = margin - brickWidth/2    //REMEMBER it start prints from the middle of the object
        	y = 50;
        
        
        for(int i = 0; i < 30; i++) { // 10 bricks * 3 rows

            int typeOfBrick = random.nextInt(3) + 1;
            
            switch(typeOfBrick) {
            
                case 1: brickPack.add(new greenBrick(this, x, y)); 
                    break;
                case 2: brickPack.add(new blueBrick(this, x, y));
                    break;
                case 3: brickPack.add(new redBrick(this, x, y));
                    break;
            }
            x = x + 20; // brick.getWidth()
            if(x==240) {
                y = y + 10;
                x = 40;
                
            }   
        }
    }
    
	private void checkGameState() {
		
		int position = -1 ;

		
		//Check bricks states and do brick function
		for(Brick eaBrick: brickPack) {
			eaBrick.checkHit();
			if(eaBrick.getLifes() <= 0) {
				eaBrick.brickAction();
				if(eaBrick.getType() != "red" || eaBrick.isHasHitRacquetOnFall() == true)
					position = brickPack.indexOf(eaBrick);
			}
		}
		if(position != -1)
		brickPack.remove(position);
		
		if(lifes==0) {
			this.gameOver();
		}
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	@Override
	public void paint(Graphics g) { // it prints from the middle of the object width/2 height/2
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
        for(Brick brick : brickPack) {
        	brick.paint(g2d, color);
        }
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			game.move();
			game.repaint();
			game.checkGameState();
			Thread.sleep(10);
		}
	}
}