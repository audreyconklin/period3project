
import java.awt.*;

	public class Snake {
		static int UNIT_SIZE = 25;
		int[] x;
		int[] y;
		int startposX = 150;
		int startposY = 100;

		int GAME_UNITS;
		int bodyParts = 3;
		char direction = 'R';
		boolean isMoving = false;
		
		// constructor
		public Snake(int w, int h) {
			GAME_UNITS =(w*h)/UNIT_SIZE;
			x =new int[GAME_UNITS];
			y =new int[GAME_UNITS];
			isMoving = true;
			int prevX = startposX;
			// start it somewhere in the middle of the screen
			for(int i = 0;i<bodyParts;i++) {
				
				x[i] =  prevX;
				y[i] = startposY;
				prevX -= UNIT_SIZE;
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

		public void grows() {
			bodyParts++;
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

		public boolean hitsFood(Rectangle food) {
			Rectangle head = new Rectangle(x[0], y[0],  UNIT_SIZE, UNIT_SIZE);
			return head.intersects(food);
		
		}
		public boolean hitsItSelf () {
			
			Rectangle head = new Rectangle(x[0], y[0],  UNIT_SIZE, UNIT_SIZE);
			// does the snake hit the tail
			for (int i = bodyParts; i > 0; i--) {
				Rectangle bodypart = new Rectangle(x[i], y[i],  UNIT_SIZE, UNIT_SIZE);
				if (bodypart.intersects(head))
					return true; 		
				
			}
			return false;
					
		}
		public int getHeadX() {
			// return the position of the head
			return x[0];
		}
	
		public int getHeadY() {
			// return the position of the head
			return y[0];
		}
	
}
