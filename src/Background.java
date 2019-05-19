import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Background extends EnvironmentObject {

	String picFile;
	BufferedImage image;
	
    public Background(String picFile){
    	this.picFile = picFile;
       	this.image = scaleImage(View.frameWidth,View.frameHeight, picFile);
        //this.image = this.createImage(picFile);
    }
}
