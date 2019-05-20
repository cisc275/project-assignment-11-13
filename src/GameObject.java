import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {

    String picFile;
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    int frameCount;
    BufferedImage image;
    int score;
    
    GameObject(){}

    GameObject(String picFile){
    	this.picFile = picFile;
    	image = createImage(picFile);
    	//this.frameCount = frameCount;
    }

    GameObject(String picFile, int x, int y){
    	this.picFile = picFile;
    	image = createImage(picFile);
    	this.xPos = x;
    	this.yPos  = y;
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
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean collidesWith(GameObject other) {
		return other.xSize > 0 && other.ySize > 0 && xSize > 0 && ySize > 0
		&& other.xPos < xPos + xSize && other.xPos + other.xSize > xPos
        && other.yPos < yPos + ySize && other.yPos + other.ySize > yPos;
	 }
	
	public BufferedImage createImage(String path) {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(path)); //Utilizes the path name
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return null;
    }
}