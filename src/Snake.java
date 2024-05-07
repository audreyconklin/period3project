
import java.awt.*;

	public class Snake {
		static int UNIT_SIZE = 25;
		int[] x;
		int[] y;
		int startposX = 10;
		int startposY = 150;

		int GAME_UNITS;
		int bodyParts = 5;
		char direction = 'R';
		boolean isMoving = false;
		
		// constructor
		public Snake(int w, int h) {
			GAME_UNITS =(w*h)/UNIT_SIZE;
			x =new int[GAME_UNITS];
			y =new int[GAME_UNITS];
			isMoving = true;
			// start it somewhere in the middle of the screen
			for(int i = 0;i<bodyParts;i++) {
				x[i] = i + startposX;
				y[i] = startposY;
			}
		}

		// draw the snake
		public void draw(Graphics g) {
		
			for(int i = 0;i<bodyParts;i++) {
				// head is a different color
				if (i==0) {
					g.setColor(Color.YELLOW);	
				} else 
					g.setColor(Color.RED);
				
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}

		}
		// move the snake 
		public void move() {
			for(int i=bodyParts; i>0; i--) {
				x[i] =x[i-1];
				y[i] =y[i-1];
			}
			//account for the direction
			switch(direction) {
			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;
			case 'D':
				y[0] = y[0] + UNIT_SIZE;
				break;
			case 'L':
				x[0] = x[0] - UNIT_SIZE;
				break;
			case 'R':
				x[0] = x[0] + UNIT_SIZE;
				break;
			}
		}

		// change direction 
		public void changeDirection(char newDirection) {
			if (isMoving) {
				  // Ensure that the snake cannot turn back on itself
				  if (
					(newDirection == 'U' && direction != 'D') ||
					(newDirection == 'D' && direction != 'U') ||
					(newDirection == 'L' && direction != 'R') ||
					(newDirection == 'R' && direction != 'L')
				  ) {
						direction = newDirection;
				  }

			}
		  
		} 
}
