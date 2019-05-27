import java.awt.image.BufferedImage;

public class PlayableBird extends Animal {

	final int yIncr = 12;
	final int xImageSize = 123;
	final int yImageSize = 102;
	final int colorDuration = 7;

	boolean upPressed = false;
	boolean downPressed = false;
	boolean spacePressed = false;
	boolean floating = false;
	int moveFrameHeight;
	int pain = 0;
	int joy = 0;
	BufferedImage bad;
	BufferedImage good;
	
	/**
     * Constructor for PlayableBird. Creates the image as well as an all red version called bad and an all green version called good.
     * 
     * @param picFile
     * @param name
     */
    public PlayableBird(String picFile, String name){
		super(picFile, name);
    	this.picFile = picFile;
        this.image = this.createImage(picFile);
        xSize = xImageSize;
        ySize = yImageSize;
        bad = this.createImage("ProjectPics/RedOsprey.png");
        good = this.createImage("ProjectPics/GreenOsprey.png");
    }

    /**
     * Method that is called when PlayableBird collides with something bad. Bird will be in "pain" for the number of frames set by colorDuration.
     * 
     */
    public void ow() {
    	pain = 7;
    }
    
    /**
     * Method that is called when PlayableBird collides with something good. Bird will be in "joy" for the number of frames set by colorDuration.
     * 
     */
    public void yay() {
    	joy = colorDuration;
    }
    
    /**
     * Decrement pain and joy variables if they are nonzero.
     * 
     * @return bad (red) image if bird is in pain, good (green) image if bird is in joy, and normal image if neither.
     */
    public BufferedImage getImage() {
    	if (pain > 0) {
    		pain--;
    		return bad;
    	}
    	if (joy > 0) {
    		joy--;
    		return good;
    	}
    	return this.image;
    }
    
    /**
     * Move the bird up or down appropriately based on which keys are being pressed and where on the screen it is.
     * Up or down with speed yIncr if on the top half of the screen and the right arrow is pressed.
     * Down with speed 2*yIncr if diving. Up with speed yIncr if underwater and just finished diving.
     * 
     * @param frameHeight
     * @return true if bird moved successfully
     */
    public boolean move(int frameHeight){
    	moveFrameHeight = frameHeight;
    	if ((!spacePressed && yPos > (frameHeight / 2) - ySize) || yPos + ySize + yIncr > frameHeight) {
    		floating = true;
    	}
    	else if(yPos < (frameHeight / 2) - ySize) {
    		floating = false;
    	}
    	if(floating) {
    		yPos -= 2*yIncr;
    	}
    	else if (dive()) {
			yPos += 2*yIncr;
		}
		else {
			if (upPressed && yPos - yIncr > 0) {
				yPos -= yIncr;
			}
			if (downPressed && yPos + yIncr < (frameHeight / 2) - ySize) {
				yPos += yIncr;
			}
		}
    	return true;
    }

    /**
     * Checks to see if bird should be diving by checking location on the screen and if space is pressed.
     * 
     * @return true if bird should be diving, false if not.
     */
    public boolean dive(){
    if (spacePressed && yPos + yIncr < moveFrameHeight - ySize) {
        return true;
    }
    else 
    	return false;
    }

    /**
     * @return the state of upPressed.
     */
    public boolean getUpPressed(){
    	return this.upPressed;
	}

    /**
     * Sets the state of upPressed.
     * 
     * @return up
     */
	void setUpPressed(boolean up){
    	this.upPressed = up;
	}

	/**
     * @return the state of downPressed.
     */
	public boolean getDownPressed(){
    	return this.downPressed;
	}

	/**
     * Sets the state of downPressed.
     * 
     * @return down
     */
	void setDownPressed(boolean down){
    	this.downPressed = down;
	}
	
	/**
     * @return the state of spacePressed.
     */
	public boolean getSpacePressed(){
    	return this.spacePressed;
	}

	/**
     * Sets the state of spacePressed.
     * 
     * @return space
     */
	void setSpacePressed(boolean space){
    	this.spacePressed = space;
	}
}
