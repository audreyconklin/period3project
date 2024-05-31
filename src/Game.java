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
	private boolean isStarted = false;
	private Sound play;
	private boolean playsound;
	private Sound effects;

	// timer is used to create an ActionListener that gets called every 150 MS 
	Timer timer = new Timer(150, this);
	Snake snake;
	Food food;
	int foodEaten;
	int countofFoodtoWin = 10;

	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		key = -1;
		foodEaten= 0;
		playsound = true;
		effects = new Sound();
		play = new Sound();
		screen = 'S';
		Background = new ImageIcon("1.jpg");
		gameScreen = new ImageIcon("Game Screen.jpg");
		
		// build a snake. pass in canvas size
		snake  = new Snake(800,600);
		

		// create food on start
		spawnFood();
		
	}
public void reset() {
	screen = 'G';
	snake  = new Snake(800,600);
	    key = -1;
		foodEaten= 0;
		timer.start();
		// create food on start
		spawnFood();
}
	public void spawnFood() {
		if(foodEaten < countofFoodtoWin)
       	 food = new Food(750,550);
    }

	protected void eatsFood() {
		// checking to see if the head hits the food region 
		if (snake.hitsFood(new Rectangle(food.getPosX(), food.getPosY(), food.getWidth(), food.getHeight())))	{
			snake.grows();
            foodEaten++;
            spawnFood();
        }
    }

	protected void collisionTest() {
		
		// can't hit yourself
       	if (snake.hitsItSelf())  {
			screen = 'L';
		}
			

        if (snake.getHeadX() <= 0 || snake.getHeadX() >= 800 -45|| snake.getHeadY() <= 0 || snake.getHeadY() >= 600-45) {
			screen = 'L';
        }

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

	public void allFoodEaten() {
		if(foodEaten >= countofFoodtoWin)
			screen = 'W';
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
			if(!isStarted) {
				isStarted = true;
				timer.start();
			}
			playsound=true;
			g2d.drawImage(gameScreen.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			// draw the snake
			snake.draw(g2d);
			
			// draw the food
			food.draw(g2d);

			
			//count++;
			break;
		
		// win screen
		case 'W':
			timer.stop();
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You Win!! ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);
			if (playsound) {
				playsound = false;
				effects.playmusic("Hooray.wav");
			}
			break;

		// lose screen
		case 'L':
			timer.stop();
			g2d.setFont(new Font("arial", Font.BOLD, 50));
			g2d.setColor(Color.white);
			g2d.drawString("You lose :( ", 280, 250);
			g2d.drawString("Press Space To Restart", 160, 320);
			if (playsound) {
				playsound = false;
				effects.playmusic("Lose.wav");
			}
			break;

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		//System.out.println(key);
		
		// press b to beging the game
		if (key == 32) {
			reset();
		
			

		}
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

	@Override
	public void keyReleased(KeyEvent e) { }
	

	/// actionhandler hooked to the timer
	@Override
    public void actionPerformed(ActionEvent e) {
		// move the snake
		snake.move();
		collisionTest();
		eatsFood();
        repaint();
		allFoodEaten();
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	
	
}
