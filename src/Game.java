import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	private BufferedImage back;
	private int key, count, score;
	private ImageIcon Background;
	private char screen;

	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		key = -1;
		
		//win = false;
	
		count = 0;
		score = 0;
		screen = 'S';
		//player = new Playership(350, 475, 80, 80);
		//aliens = setAliens();
		Background = new ImageIcon("Background.png");
		
	}

	public void screen(Graphics g2d) {
		switch (screen) {

		case 'S':
			g2d.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);
			//drawStartScreen(g2d);

			break;

		// start screen

		case 'G':
			g2d.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			win();
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

		screen(g2d);
		

		twoDgraph.drawImage(back, null, 0, 0);

	}

	public void win() {
		//if (aliens.size() == 0)
			screen = 'W';
			if(score>=27) {
				screen= 'W';
			}
	}

	
	




	@Override

	public void keyTyped(KeyEvent e) {

	}

	@Override

	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);
		
		if (key == 49) {
			score = score + 1;

		}
		if (key == 66) {
			screen = 'G';

		}

		if (key == 32) {
			screen = 'G';
		}
	}
	

	/*
	 * } if (key == 39) { player.setX(3);
	 * 
	 * }
	 * 
	 * if (key == 37) { player.setX(-3); }
	 * 
	 * }
	 */
	@Override

	public void keyReleased(KeyEvent e) {

		// if (key == 37 || key == 39)
		// player.setX(0);
	}

	@Override

	public void mouseDragged(MouseEvent arg0) {

		// TODO Auto-generated method stub

	}

	@Override

	public void mouseMoved(MouseEvent m) {
		//player.setX(m.getX());
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub

	}

	@Override

	public void mousePressed(MouseEvent arg0) {
		if (arg0.getButton() == 1) {
//			playerMissile(arg0.getX() + (player.getWidth() / 4));
		}
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseReleased(MouseEvent arg0) {

		// TODO Auto-generated method stub

	}

	@Override

	public void mouseEntered(MouseEvent arg0) {

		// TODO Auto-generated method stub

	}

	@Override

	public void mouseExited(MouseEvent arg0) {

		// TODO Auto-generated method stub

	}

}