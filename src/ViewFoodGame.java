import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewFoodGame extends JPanel {
    BufferedImage birdImg;
    BufferedImage foeImg;
    BufferedImage bgImg;
	int x; int y;
	
	PlayableBird mainBird;
    Foe foe;
    Background background;
	
	public ViewFoodGame() {
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
	
    public void addObjects(PlayableBird bird, Foe foe, Background background) {
        this.mainBird = bird;
        this.foe = foe;
        this.background = background;
        foeImg = createImage(this.foe.picFile);
        birdImg = createImage(this.mainBird.picFile);
        bgImg = createImage(this.background.picFile);
    }
	
    public void update(PlayableBird bird, Foe foe){
        this.mainBird = bird;
        this.foe = foe;
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
		g.drawImage(bgImg, 0, 0, this);
		g.drawImage(birdImg, mainBird.getxPos(), mainBird.getyPos(), this);
        g.drawImage(foeImg, foe.getxPos(), foe.getyPos(), this);
	}
	
	public BufferedImage createImage(String path) {
        BufferedImage bufferedImage;
        try {
            System.out.println();
            bufferedImage = ImageIO.read(new File(path)); //Utilizes the path name
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return null;
    }
	
	
}
