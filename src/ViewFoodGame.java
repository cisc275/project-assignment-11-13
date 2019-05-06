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
	//PlayableBird mainBird;
    //Foe foe;
    Background background;
	
	public ViewFoodGame() {
		background = new Background("ProjectPics/Background.png");
//		foeImg = createImage("ProjectPics/Osprey.png");
//        birdImg = createImage("ProjectPics/Eagle.png");
//        bgImg = createImage("ProjectPics/Background.png");
//		x = 0;
//		y = 0;
		//JButton buttonNext = new JButton("next");
        //buttonNext.addActionListener(alNext);

        //JLabel textLabel = new JLabel(text);

        //this.add(textLabel);
        //this.add(buttonNext);
	}
    
    public void addObjects(ArrayList<GameObject> objects) {
    	this.objects = objects;
    }
	
    
    public void update(ArrayList<GameObject> objects) {
    	this.objects = objects;
    	this.repaint();
    }
    
	/*public GameState update() {
		x+=2;
		y+=2;
		if (x > 100) {
			reset();
			return GameState.NESTGAME;//CUTSCENE1;
		}
		this.repaint();
		return GameState.FOODGAME;
	}
	
	private void reset() {
		x = 0;
		y = 0;
	}*/
	
	public void paint(Graphics g) {
		g.drawImage(background.image, 0, 0, this);
		for (GameObject go : objects) {
			g.drawImage(go.image, go.getxPos(), go.getyPos(), this);
		}
	}
}
