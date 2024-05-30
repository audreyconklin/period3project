import java.util.Random;
import java.awt.*;

public class Food {

    private final int posX;
    private final int posY;
    static int UNIT_SIZE = 25;

    public Food(int w, int h) {
        posX = generatePos(w);
        posY = generatePos(h);
    }

    private int generatePos(int size) {
        Random random = new Random();
        return random.nextInt(size / UNIT_SIZE) * UNIT_SIZE;
    }

    // draw the food
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(getPosX(), getPosY(), UNIT_SIZE, UNIT_SIZE);

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public int getWidth() {
        return UNIT_SIZE;
    }
    public int getHeight() {
        return UNIT_SIZE;
    }
}