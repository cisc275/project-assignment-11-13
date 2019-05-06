import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background extends EnvironmentObject {

	String picFile;
	BufferedImage image;
	
    public Background(String picFile){
    	this.picFile = picFile;
    	this.image = this.createImage(picFile);
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