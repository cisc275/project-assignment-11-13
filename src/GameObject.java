public class GameObject {

    String picFile;
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    int frameCount;

    GameObject(){}

    GameObject(String picFile){
    	this.picFile = picFile;
    	//this.frameCount = frameCount;
    }

    public String getPicFile() {
    	return picFile;
    }
    
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}
	
	// This code is ripped from Java's Rectangle.intersects function.
	// Determines if two game objects collide according to rectangular hit-boxes.
	public boolean collidesWith(GameObject other) {
		return other.xSize > 0 && other.ySize > 0 && xSize > 0 && ySize > 0
		&& other.xPos < xPos + xSize && other.xPos + other.xSize > xPos
        && other.yPos < yPos + ySize && other.yPos + other.ySize > yPos;
	 }
}
