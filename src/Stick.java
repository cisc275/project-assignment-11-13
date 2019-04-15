public class Stick extends GameObject {
	int speedFalling = 3;
	boolean isFalling = false;

    public Stick(){
    	picFile = "ProjectPics/Stick.png";
    	//Hard coding in the image size for now:
      //  xSize = 180;
        //ySize = 106;
        
    }
    public void release(int xPos) {
    	isFalling = true;
    	xPos = this.xPos;
    	return;
    }
    
    public void fall(int frameWidth, int frameHeight){
    	if(isFalling == false) {
    		return;
    	}
    	yPos -= speedFalling;
    	if (yPos <= -ySize) {
    		isFalling = false;
    	}
        return;
}

    public boolean collided(){
        return true;
    }

    public boolean checkOnPile(){
        return true;
    }

}
