import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.*;

public class Game extends JPanel implements Runnable, KeyListener {
	private BufferedImage back;
	private int key, count, score;
	private ImageIcon gameScreen;
	private ImageIcon Background;
	private char screen;
	int applesEaten;
	int snakeX;
	int snakeDx;
	int snakeDy;
	int snakeY;
	int appleX;
	int appleY;
	private boolean appleEaten=false;
	

	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
	
		
		key = -1;
		
		//win = false;
		snakeDy=0;
		snakeDx=0;
	    snakeX= 300;
	    snakeY=300;
		count = 0;
		score = 0;
		screen = 'S';
		Background = new ImageIcon("Background.png");
		gameScreen = new ImageIcon("Game Screen.jpg");
		
	}

	public void screen(Graphics g2d) {
		switch (screen) {

		case 'S':
			drawStartScreen(g2d);

			break;

	

		case 'G':
			g2d.drawImage(gameScreen.getImage(), 0, 0, getWidth(), getHeight(), this);
			//spawnApple();
		    drawSnake(g2d);
			g2d.setFont(new Font("arial", Font.BOLD, 25));
			g2d.setColor(Color.white);
			g2d.drawString("Score=" + score, 10, 50);
			count++;
			
			// checkPlayerHit();
			break;

		// game screen

		case 'W':
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You Win!! ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);
			score = 0;
			
			
			// win screen

			break;

		case 'L':
			score = 0;
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You lose :( ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);
		

			// lose screen

			break;

		}

	}




	public void run()

	{

		try

		{

			while (true)

			{

				Thread.currentThread().sleep(5);

				repaint();

			}

		}

		catch (Exception e)

		{

		}

	}

	public void paint(Graphics g) {

		
		Graphics2D twoDgraph = (Graphics2D) g;
		if (back == null)

			back = (BufferedImage) ((createImage(getWidth(), getHeight())));

		Graphics g2d = back.createGraphics();

		g2d.clearRect(0, 0, getSize().width, getSize().height);
         move();
		screen(g2d);
		
		
		twoDgraph.drawImage(back, null, 0, 0);

	}


public void drawStartScreen(Graphics g2d) {
	g2d.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);

}
public void drawSnake(Graphics g2d) {
			g2d.setColor(Color.BLUE);
			g2d.fillOval(snakeX, snakeY, 100, 40);
			


}
	public void win() {
			screen = 'W';
			if(score>=27) {
				screen= 'W';
			}
	}
				
			
public void move() {
	snakeX += snakeDx;
	if (snakeY < 0)
		snakeY = 0;
	snakeY += snakeDy;
	if (snakeX < 0)
		snakeX = 0;

}

	
	




	@Override

	public void keyTyped(KeyEvent e) {

	}

	@Override

	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);
		

		
		   if (key == 66) {
			screen = 'G';

		}

		if (key == 32) {
			screen = 'G';
		}
		if (key == 39) {
			snakeDx=snakeDx+2;
		}
	
	if (key == 37) {
		snakeDx=snakeDx-2;
	}
}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	
	
}