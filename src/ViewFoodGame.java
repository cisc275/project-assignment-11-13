import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
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
		for (GameObject go : objects) {
			g.drawImage(go.image, go.getxPos(), go.getyPos(), this);
		}
		g.drawImage(map.map, map.getXPos(), map.getMapYPos(), this);
		g.drawImage(map.getCurrentMapPath(), map.getXPos(), map.getPathYPos() + map.getPathHeight() - map.getProgress(), this);
		g.setFont(new Font("Ariel", Font.ITALIC, 40));
        g.drawString("SCORE: " + objects.get(0).getScore(), 1700, 400);
	}
}
