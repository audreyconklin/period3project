import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
//import java.util.ArrayList;
import java.awt.event.*;
//import java.util.*;

//
public class Game extends JPanel implements Runnable, KeyListener, ActionListener {
	private BufferedImage back;
	private int key;
	private int score;
	private ImageIcon gameScreen;
	private ImageIcon Background;
	private char screen;

	// timer is used to create an ActionListener that gets called every 150 MS 
	Timer timer = new Timer(150, this);
	Snake snake;

	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		key = -1;
		score = 0;
		screen = 'S';
		Background = new ImageIcon("Background.png");
		gameScreen = new ImageIcon("Game Screen.jpg");
		
		// build a snake. pass in canvas size
		snake  = new Snake(800,600);
		timer.start();
		
	}

	public void run() {

		try	{

			while (true){
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch (Exception e) {}

	}

	public void paint(Graphics g) {

		Graphics2D twoDgraph = (Graphics2D) g;
		if (back == null)
			back = (BufferedImage) ((createImage(getWidth(), getHeight())));

		Graphics g2d = back.createGraphics();
		g2d.clearRect(0, 0, getSize().width, getSize().height);
		// screen manager 
		screen(g2d);
		twoDgraph.drawImage(back, null, 0, 0);

	}

	public void screen(Graphics g2d) {
		switch (screen) {

		case 'S':
			g2d.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		
		case 'G':
			g2d.drawImage(gameScreen.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			// draw the snake
			snake.draw(g2d);
			
			
			g2d.setFont(new Font("arial", Font.BOLD, 25));
			g2d.setColor(Color.white);
			g2d.drawString("Score=" + score, 10, 50);
			//count++;
			break;
		
		// win screen
		case 'W':
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You Win!! ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);
			score = 0;
			break;

		// lose screen
		case 'L':
			score = 0;
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You lose :( ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);

			break;

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);
		
		// press b to beging the game
		if (key == 66) {
			screen = 'G';
		}


		if (key == 37) {
			snake.changeDirection('L');
		}

		if (key == 38) {
			snake.changeDirection('U');
		}

		if (key == 39) {
			snake.changeDirection('R');
		}

		if (key == 40) {
			snake.changeDirection('D');
		}
		
		//snake.move();
	}

	public void keyReleased(KeyEvent e) { }

	/// actionhandler hooked to the timer
	@Override
    public void actionPerformed(ActionEvent e) {
		// move the snake
		snake.move();
        repaint();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}