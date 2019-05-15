import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class ViewNestGame extends JPanel {


	ArrayList<GameObject> objects;
    Background background;
    
    BufferedImage dropBirdImg;
    BufferedImage stickImg;
    String stickFile = "ProjectPics/Stick.png";
    DropBird dropBird;





    public ViewNestGame(){
    	background = new Background("ProjectPics/BackgroundNestGame.jpg");
    }

    public void addObjects(ArrayList<GameObject> objects) {
       this.objects = objects;
      // dropBirdImg = createImage(this.dropBird.picFile);
       //stickImg = createImage(stickFile);
    }        

    public void update(ArrayList<GameObject> objects){
    	for(GameObject o : objects) {
    		dropBird = (DropBird) o;
    	}
    	this.repaint();
    	return;
    }



    public void paint(Graphics g){
    	System.out.println("The picFile is" + background.picFile);
    	g.drawImage(background.image,  0,  0,  this);
        g.drawImage(dropBird.image, dropBird.getxPos(), dropBird.getyPos(), Color.cyan, this);
        for(Stick s: dropBird.stickList) {
        	g.drawImage(s.image, s.getxPos(), s.getyPos(), Color.cyan, this);
        }
    }
}