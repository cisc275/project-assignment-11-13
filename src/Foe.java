import java.util.Random;

public class Foe extends Animal {
    int collisionPenalty;
    int speed;
    Random rand = new Random();

    /**
     * Constructor for Foe birds. Assigns random values to speed and position. Creates buffered image of Foe.
     * 
     * @param picFile
     * @param name
     * @param frameWidth
     * @param frameHeight
     */
    public Foe(String picFile, String name, int frameWidth, int frameHeight){
        super(picFile, name);
        this.picFile = picFile;
        this.image = this.createImage(picFile);
    	//Hard coding in the image size for now:
        xSize = 180;
        ySize = 106;
        
        speed = Math.abs(rand.nextInt())%5+15;
    	xPos = frameWidth;
    	yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize);
    }

    /**
     * Move function to move the Foe from the right to the left of the screen. Calls reset function after hitting left of screen.
     * 
     * @param frameWidth
     * @param frameHeight
     * @return
     */
    public boolean move(int frameWidth, int frameHeight){
    	xPos -= speed;
    	if (xPos < -xSize) {
    		reset(frameWidth, frameHeight);
    	}
        return true;
    }
    
    /**
     * Resets the for on the screen from the left side to the right side but with a random vertical position and random speed
     * 
     * @param frameWidth
     * @param frameHeight
     */
    public void reset(int frameWidth, int frameHeight) {
    	xPos += frameWidth + 2*xSize;
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize);
		speed = Math.abs(rand.nextInt())%5+15;
    }

    /**
     * Collision function used to help identify when a Playable bird collides with a Foe
     * 
     * @return boolean
     */
    public boolean isCollided(){
        return true;
    }
}
