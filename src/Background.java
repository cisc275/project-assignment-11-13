import java.awt.image.BufferedImage;

public class Background extends EnvironmentObject {

	String picFile;
	BufferedImage uncutImage;
	BufferedImage image;
	
	final int imageHeight = 1075;
	final int imageWidth = 4748;
	final int unscaledFrameWidth = 500;
	final int scrollSpeed = 8;
	int position;
	
	/** 
	 * Background constructor defining the image, its size, and beginning partition of it 
	 **/
    public Background(String picFile){
    	this.picFile = picFile;
       	this.uncutImage = scaleImage(View.frameWidth*3,View.frameHeight, picFile);
       	position = 0;
       	slice();
    }
    
    /**
     * Calls the slice function to partition the background
     * 
     * @return void
     */
    public void update() {
		slice();
	}
	
    /**
     * Takes the image of the background and partitions it to generate the moving background in the view
     * 
     * @return void
     */
	public void slice() {
		image = uncutImage.getSubimage(position, 0, View.frameWidth, View.frameHeight);
		position = (position + scrollSpeed) % (2*unscaledFrameWidth);
	}
}
