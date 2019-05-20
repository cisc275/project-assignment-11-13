import java.awt.Color;
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
	
	public ViewFoodGame() {
		background = new Background("ProjectPics/Background.png");
		tutorial = new GameObject("ProjectPics/Food_Instructions.png");
	}
    
    public void addObjects(ArrayList<GameObject> objects) {
    	this.objects = objects;
    }
	
    
    public void update(ArrayList<GameObject> objects) {
    	this.objects = objects;
    	this.repaint();
    	background.update();
    }
    
    public void update(ArrayList<GameObject> objects, Minimap map) {
    	this.objects = objects;
    	this.map = map;
    	this.repaint();
    	background.update();
    }
	
	public void paint(Graphics g) {
		g.drawImage(background.image, 0, 0, this);
		g.drawImage(tutorial.image, 300, 0, this);
		for (GameObject go : objects) {
			g.drawImage(go.image, go.getxPos(), go.getyPos(), this);
		}
		g.drawImage(map.map, map.getXPos(), map.getMapYPos(), this);
		g.drawImage(map.getCurrentMapPath(), map.getXPos(), map.getPathYPos() + map.getPathHeight() - map.getProgress(), this);
	}
}
