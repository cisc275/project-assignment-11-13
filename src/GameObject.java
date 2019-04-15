public class GameObject {
    String picFile;
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    int frameCount;
    
    GameObject(){
    	
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
}
