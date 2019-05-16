import java.util.Random;

public class Food extends GameObject {
    int size;
    int pointValue;
    int xIncr;
    int yIncr;
    boolean isCollected;
    private static final int SPEEDRANGE = 6;
    private Random rand = new Random();

    public Food(int frameWidth, int frameHeight, int pointValue){
    	xPos = Math.abs(rand.nextInt()) % frameWidth; 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
		this.pointValue = pointValue;
		xIncr = Math.abs(rand.nextInt()) % SPEEDRANGE; 
    }

    public void move(int scrollSpeed, int frameWidth, int frameHeight){
        xPos -= (scrollSpeed + xIncr);
        if(xPos + xSize < 0) {
        	reset(frameWidth, frameHeight);
        }
    }

    public boolean collected(){
        return isCollected;
    }
    
    public void reset(int frameWidth, int frameHeight) {
    	xPos = Math.abs(rand.nextInt() % frameWidth/3) + frameWidth; // the "/3" part determines frequency of new spawns 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
    }
    
    public int getPointValue() {
    	return pointValue;
    }
}
