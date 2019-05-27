import java.util.Random;

public class Food extends GameObject {
    int size;
    int pointValue;
    int xIncr;
    int yIncr;
    boolean isCollected;
    private static final int SPEEDRANGE = 6;
    private Random rand = new Random();

    /**
     * Generates viable food in the water for the PlayableBird to eat at random Y positions on the right of the screen at varying speeds.
     * 
     * @param frameWidth
     * @param frameHeight
     * @param pointValue
     */
    public Food(int frameWidth, int frameHeight, int pointValue){
    	xPos = Math.abs(rand.nextInt()) % frameWidth; 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
		this.pointValue = pointValue;
		xIncr = Math.abs(rand.nextInt()) % SPEEDRANGE; 
    }

    /**
     * Moves the food from the right to the left of the screen, calling reset function upon hitting the left.
     * 
     * @param scrollSpeed
     * @param frameWidth
     * @param frameHeight
     */
    public void move(int scrollSpeed, int frameWidth, int frameHeight){
        xPos -= (scrollSpeed + xIncr);
        if(xPos + xSize < 0) {
        	reset(frameWidth, frameHeight);
        }
    }

    /**
     * Helps identify when food has been collected by the player.
     * 
     * @return boolean
     */
    public boolean collected(){
        return isCollected;
    }
    
    /**
     * When food travels past the left of the screen, food is reset on the right side with a random Y position and speed.
     * 
     * @param frameWidth
     * @param frameHeight
     */
    public void reset(int frameWidth, int frameHeight) {
    	xPos = Math.abs(rand.nextInt() % frameWidth/3) + frameWidth; // the "/3" part determines frequency of new spawns 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
    }
    
    /**
     * @return pointValue
     */
    public int getPointValue() {
    	return pointValue;
    }
}
