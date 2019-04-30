import java.awt.Rectangle;
public class GameObject {

    String picFile;
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    int frameCount;
    Rectangle hitBox;

    GameObject(){
    	hitBox = new Rectangle();
    }

    GameObject(String picFile){
    	this.picFile = picFile;
    	hitBox = new Rectangle();
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
	
	void updateHitBox() { // ALWAYS CALL THIS AFTER MODIFYING SIZE OR POSITIONS
		this.hitBox.setBounds(xPos, yPos, xSize, ySize);
	}
	
	public boolean collidesWith(GameObject other) {
		return this.hitBox.intersects(other.hitBox);
	}
}
