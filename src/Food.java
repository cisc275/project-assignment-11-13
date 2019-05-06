import java.util.Random;

public class Food extends GameObject {
    private int pointValue;
    private Random rand = new Random();
    
    // This constructor will initialize x and y positions to random values with reason.
    public Food(int frameWidth, int frameHeight, int pointValue) {
    	xPos = Math.abs(rand.nextInt()) % frameWidth; 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
		this.pointValue = pointValue;
    }

    // Alters only x position. Subtracts input amount from it
    public void move(int xIncr, int frameWidth, int frameHeight){
        xPos -= xIncr;
        if(xPos < 0) {
        	reset(frameWidth, frameHeight);
        }
    }
    
    // Food objects are never destroyed during the program. Instead, when one leaves the screen
    // or is eaten, it is respawned. This also maintains the edible/non edible ratio
    public void reset(int frameWidth, int frameHeight) {
    	xPos = Math.abs(rand.nextInt() % frameWidth/3) + frameWidth; // the "/3" part determines frequency of new spawns 
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize) + (frameHeight/2);
    }
    
    public int getPointValue() {
    	return pointValue;
    }

}
