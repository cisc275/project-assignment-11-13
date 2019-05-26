import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class EnvironmentObject {
	
	/** 
	 * Default constructor for EnvironmentObject
	 */
    public EnvironmentObject(){}
    
    /**
     * Manages the scaling of images in the game ensuring they fit to the screen aptly
     * 
     * @param WIDTH
     * @param HEIGHT
     * @param filename
     * @return BufferedImage
     */
    public static BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
        BufferedImage bi = null;
        try {
            ImageIcon ii = new ImageIcon(filename);//path to image
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bi;
    }
    
    /**
     * Generates the image to be displayed in the pertaining view
     * 
     * @param path
     * @return BufferedImage
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

