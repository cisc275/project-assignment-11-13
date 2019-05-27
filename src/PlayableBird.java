public class PlayableBird extends Animal {

	final int yIncr = 12;

	boolean upPressed = false;
	boolean downPressed = false;
	boolean spacePressed = false;
	boolean floating = false;
	int moveFrameHeight;

    public PlayableBird(String picFile, String name){
		super(picFile, name);
    	this.picFile = picFile;
    	xSize = 123;
    	ySize = 102;
        this.image = this.createImage(picFile);
    }

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
