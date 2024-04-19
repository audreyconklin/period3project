
	import java.awt.Color;

	public class Snake {
		private int x;
		private int y;
		private int width;
		private int height;
		private int dx;
		private int dy;
		private Color c;
		private int score;
		private boolean movert;
		private boolean moveup;

		public Snake() {
			x=300;
			y=300;
			width=30;
			height=30;
			dx=3;
			dy=3;
			c=Color.WHITE;
			movert=false;
			moveup=false;
		}
		public Snake(int x1, int y1, int w, int h, int dx1, int dy1, Color c1)
		{
			x=x1;
			y=y1;
			width=w;
			height=h;
			dx=dx1;
			dy=dy1;
			movert=true;
			moveup=true;
			c=c1;
	}

	   public int getW() {
		   return width;
	   }
	   
		
		public Color getColor() {
			return c;
		}
			

		public int getH() {
			return height;
			}

			public int getX() {
				return x;
			}

			public int getY() {
				return y;
			}

			public int getDX() {
				return dx;
			}

			public int getDY() {
				return dy;		
		}
			public void setdy(int d) {
				dy=d;
			}
			public void setdx(int d) {
				dx=d;
			}
		public void bounce() {
			if(movert) {
				x+=dx;
			}
			else {
				x-=dx;
			}
			if(moveup) {
				y+=dy;
			}
			else {
				y-=dy;
			}
			if (x<0)
				movert=true;
			if(x+width>800)
				movert=false;

			if(y<0)
				moveup=true;
			//if(y+height>530)
				//movedn=false;

		}
		public void setmovert() {
			movert=!movert;
		}
	   public void setmoveup() {
		moveup=!moveup;
	}
		public void setX(int s) {
			x=s;
		}
		public void setY(int s) {
			y=s;
		}
		//public boolean Collision(Wall) {
			//if (getY()+getW()>=b.gety()&&getY()<=b.gety()+b.getwidth()&&
					//getY()+getH()>=b.getx()&&getX()<=b.getx()+b.getheight())
					//{setmoveup();
				//return true;
		//}

		//return false;
	 //}
	}
}
