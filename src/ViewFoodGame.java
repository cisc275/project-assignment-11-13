import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewFoodGame extends JPanel {
	
	ArrayList<GameObject> objects;
    Background background;
    GameObject tutorial;
    Minimap map;
    
    final int scoreOffset = 20;
    final int scoreSize = 34;
	
    /**
     * The constructor creates a background object and tutorial game object
     */
	public ViewFoodGame() {
		background = new Background("ProjectPics/Background.png");
		tutorial = new GameObject("ProjectPics/Food_Instructions.png");
	}
    
	/**
	 * Adds an array list of the game objects 
	 * 
	 * @param objects An array list of gameObjects  
	 */
    public void addObjects(ArrayList<GameObject> objects) {
    	this.objects = objects;
    }
	
    
    /**
     * This method updates the gameObject list from the model class, then
     * calls the repaint method to update the GUI to reflect the current status
     * of the game. Lastly, the background is updated
     * 
     * @param objects ArrayList of gameObjects from the model
     */
    public void update(ArrayList<GameObject> objects) {
    	this.objects = objects;
    	this.repaint();
    	background.update();
    }
    
    /**
     * /**
     * This method updates the gameObject list from the model class, then
     * calls the repaint method to update the GUI to reflect the current status
     * of the game. Map, which serves as a timer for the user, is also updated. 
     * Lastly, the background is updated
     * 
     * @param objects ArrayList of gameObjects from the model
     * @param map a minimap object that reflects the users postion in the game
     */
    public void update(ArrayList<GameObject> objects, Minimap map) {
    	this.objects = objects;
    	this.map = map;
    	this.repaint();
    	background.update();
    }
	
    /**
     * the method called in the repaint method that updates the users interface. 
     * Up to date gameObejcts are projected onto the screen. 
     * 
     * @param g the graphics object that is updated
     */
	public void paint(Graphics g) {
		g.drawImage(background.image, 0, 0, this);
		for (GameObject go : objects) {
			g.drawImage(go.getImage(), go.getxPos(), go.getyPos(), this);
		}
		g.drawImage(map.map, map.getXPos(), map.getMapYPos(), this);
		g.drawImage(map.getCurrentMapPath(), map.getXPos(), map.getPathYPos() + map.getPathHeight() - map.getProgress(), this);
		g.setFont(new Font("Ariel", Font.ITALIC, scoreSize));
        g.drawString("SCORE: " + objects.get(0).getScore(), map.getXPos()+scoreOffset, map.getMapHeight()+scoreOffset);
	}
}
