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
    
    /**
     * Default constructor for game objects
     */
    GameObject(){}

    /**
     * Constructor for game object that creates a buffered image from a string source
     * 
     * @param picFile
     */
    GameObject(String picFile){
    	this.picFile = picFile;
    	image = createImage(picFile);
    }

    /**
     * Constructor for a game object that creates a buffered image from a string source with a specified X and Y position
     * 
     * @param picFile
     * @param x
     * @param y
     */
    GameObject(String picFile, int x, int y){
    	this.picFile = picFile;
    	image = createImage(picFile);
    	this.xPos = x;
    	this.yPos  = y;
    }
    
    /**
     * @return picFile
     */
    public String getPicFile() {
    	return picFile;
    }
    
	/**
	 * @return xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @return xSize
	 */
	public int getxSize() {
		return xSize;
	}

	/**
	 * @return getySize
	 */
	public int getySize() {
		return ySize;
	}
	
	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	
	/**
	 * Collision function that returns true if two game objects have collided on the screen in the playable area
	 * 
	 * @param other
	 * @return boolean
	 */
	public boolean collidesWith(GameObject other) {
		return other.xSize > 0 && other.ySize > 0 && xSize > 0 && ySize > 0
		&& other.xPos < xPos + xSize && other.xPos + other.xSize > xPos
        && other.yPos < yPos + ySize && other.yPos + other.ySize > yPos;
	 }
	
	/**
	 * Takes a string input file path and creates a buffered image within java.
	 * 
	 * @param path
	 * @return null
	 */
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