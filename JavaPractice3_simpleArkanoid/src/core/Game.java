package core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import elements.Ball;
import elements.Brick;
import elements.Racquet;
import elements.blueBrick;
import elements.greenBrick;
import elements.redBrick;

@SuppressWarnings("serial") // QUE ES ???
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Brick brick;
	private ArrayList<Brick> brickPack = new ArrayList<Brick>();


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
				racquet.keyPressed(e);
			}
		});
		 setFocusable(true); // PARA QUE SIRVE ???
	}
	
	private void fillBrickList() {
		
		Random random = new Random();
		
		int x = 3, y = 3;
		
		
		for(int i = 0; i < 20; i++) {

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
			if(x==28) {
				y = y + brick.getHeight();
				x = 3;
			}	
		}
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		for(Brick brick : brickPack) {
			brick.paint(g2d);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}