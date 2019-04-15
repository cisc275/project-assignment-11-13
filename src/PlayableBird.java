public class PlayableBird extends Animal {
	final int yIncr = 8; //Just made up this value for now
	boolean upPressed = false;
	boolean downPressed = false;

    public PlayableBird(String picFile, String name){
        super(picFile, name);
        //Hard coding in the image size for now:
        xSize = 123;
        ySize = 102;
    }

    public boolean move(int frameHeight){
    	//This method should only deal with up and down, right? Because the bird doesn't move left/right, the background and everything else does. 
    	if (upPressed && yPos - yIncr > 0) {
    		yPos -= yIncr; 
    	}
    	if (downPressed && yPos + yIncr < frameHeight - ySize) {
    		yPos += yIncr;
    	}
    	
    	
    	
    	//System.out.println("Bird's y-position: " + yPos); //For testing to see that value was updating
    	return true;
    }

    public boolean dive(){
        return true;
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
}
