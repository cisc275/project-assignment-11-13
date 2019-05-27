import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The ViewNestGame class displays the gameObjects onto the screen
 * and is updated from NestGameModel
 */
@SuppressWarnings("serial")
public class ViewNestGame extends JPanel {
	ArrayList<GameObject> objects;
    Background background;
    BufferedImage dropBirdImg;
    BufferedImage stickImg;
    GameObject scoreBoard;
    String stickFile = "ProjectPics/Stick.png";
    DropBird dropBird;
    JButton ScoreBoard;
    JLabel SticksLeft;
    JLabel scoreLabel;
    int score;
    GameObject tutorial ;

    /**
     * Constructor creates a background and new game objects for the tutorial 
     * and scoreboard
     */
    public ViewNestGame(){
    	background = new Background("ProjectPics/BackgroundNestGame.jpg");
    	tutorial = new GameObject("ProjectPics/spacebar.png");
    	scoreBoard = new GameObject("ProjectPics/NestScoreBoard.PNG");
    }

    /**
     * This method updates the ArrayList objects
     * 
     * @param objects an arrayList containing the GameObjects
     */
    public void addObjects(ArrayList<GameObject> objects) {
       this.objects = objects;
    }        

    /**
     * This method pulls the dropBird out of the gameObject arrayList, 
     * updates the score, and then calls the repaint method to update the view
     * on the screen
     * 
     * @param objects ArrayList containing the game object
     */
    public void update(ArrayList<GameObject> objects){
    	for(GameObject o : objects) {
    		dropBird = (DropBird) o;
    	}
    	score = dropBird.score;
    	this.repaint();
    	return;
    }


    /**
     * The paint method overlays all of the game objects on the background, and keeps the 
     * score up to date and posted on the screen
     * 
     * @param g Graphics object each gameObject is drawn on
     */
    public void paint(Graphics g){
    	g.drawImage(background.image, 0, 0, this);
    	g.drawImage(dropBird.image, dropBird.getxPos(), dropBird.getyPos(), this);
        for(Stick s: dropBird.stickList) {
        	g.drawImage(s.image, s.getxPos(), s.getyPos(), this);
        }
        g.drawImage(scoreBoard.image, 1650 ,400, this);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawString(" " + (dropBird.sticksAvalible - dropBird.droppedSticks) , 1795, 525);
        if(score < 2) {
        	g.setColor(Color.RED);
        }else if(score < 4) {
        	g.setColor(Color.YELLOW);
        }else if (score < 6) {
        	g.setColor(Color.ORANGE);
        }else {
        	g.setColor(Color.GREEN);
        }
        g.drawString(" "+ score, 1800, 450);
        
        if(dropBird.stickList.size()  == 0) {
        	g.setFont(new Font("SansSerif", Font.BOLD, 60));
        	g.setColor(Color.BLACK);
        	g.drawString("Press                      to drop sticks", 400, 550);
    		g.drawImage(tutorial.image, 600 , 450, this);
    	}else if(dropBird.stickList.size()  == 1 ) {
    		g.setFont(new Font("SansSerif", Font.BOLD, 60));
        	g.setColor(Color.BLACK);
        	g.drawString("Stack the tower as high as you can to avoid high flood waters!", 100, 1000);
    	}
        
    }
}