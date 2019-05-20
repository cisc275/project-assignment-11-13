import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Background extends EnvironmentObject {

	String picFile;
	BufferedImage uncutImage;
	BufferedImage image;
	
	final int imageHeight = 1075;
	final int imageWidth = 4748;
	final int unscaledFrameWidth = 1911;
	final int scrollSpeed = 8;
	int position;
	
    public Background(String picFile){
    	this.picFile = picFile;
       	this.uncutImage = scaleImage(View.frameWidth*3,View.frameHeight, picFile);
       	position = 0;
       	slice();
        //this.image = this.createImage(picFile);
    }
    
    public void update() {
		slice();
	}
	
	public void slice() {
		image = uncutImage.getSubimage(position, 0, View.frameWidth, View.frameHeight);
		position = (position + scrollSpeed) % (2*unscaledFrameWidth);
	}
}
