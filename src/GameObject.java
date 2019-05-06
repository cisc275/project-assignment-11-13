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

    GameObject(){}

    GameObject(String picFile){
    	this.picFile = picFile;
    	image = createImage(picFile);
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