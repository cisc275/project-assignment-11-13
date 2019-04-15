import java.awt.image.BufferedImage;

public class PlayableBird extends Animal {

	final int yIncr = 8; //Just made up this value for now
	boolean upPressed = false;
	boolean downPressed = false;
	boolean spacePressed = false;
	int moveFrameHeight;

    public PlayableBird(String picFile, String name){
		super(picFile, name);
    	this.picFile = picFile;
        //Hard coding in the image size for now:
        xSize = 123;
        ySize = 102;
    }

    public boolean move(int frameHeight){
    	moveFrameHeight = frameHeight;
    	//This method should only deal with up and down, right? Because the bird doesn't move left/right, the background and everything else does.
		if (dive()) {
			yPos += 2*yIncr;
		}
		else {
			if (upPressed && yPos - yIncr > 0) {
				yPos -= yIncr;
			}
			if (downPressed && yPos + yIncr < (moveFrameHeight / 2) - ySize) {
				yPos += yIncr;
			}
			if (!dive() && yPos > (moveFrameHeight / 2) - ySize) {
				yPos -= yIncr;
			}
		}
    	
 
    	
    	//System.out.println("Bird's y-position: " + yPos); //For testing to see that value was updating
    	return true;
    }

    public boolean dive(){
    if (spacePressed && yPos + yIncr < moveFrameHeight - ySize) {
        return true;
    }
    else 
    	return false;
    }

    public boolean getUpPressed(){
    	return this.upPressed;
	}

	void setUpPressed(boolean up){
    	this.upPressed = up;
	}

	public boolean getDownPressed(){
    	return this.downPressed;
	}

	void setDownPressed(boolean down){
    	this.downPressed = down;
	}
	
	public boolean getSpacePressed(){
    	return this.spacePressed;
	}

	void setSpacePressed(boolean space){
    	this.spacePressed = space;
	}
}
