import javax.swing.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ViewScoreboard extends JPanel{
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    
    // The Scoreboard object is what is written to and read from file. It is then used to create a JTable for display.
    JTable renderable_scoreboard;
    Scoreboard scoreboard;
    JLabel background;
    
    /**
     * The constructor uses a try catch block to attempt to open a file containing high
     * scores. If suck file exists, it is saved as a scoreboard object. If not, a new
     * scoreboard file is created. 
     * After this, the scoreboard is projected over the background
     */
    public ViewScoreboard(){
    	FileInputStream fis;
		try {
			fis = new FileInputStream("scoreboard.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
	    	scoreboard = (Scoreboard) ois.readObject();
			ois.close();
			
		// if there is no scoreboard file to load
		} catch (Exception e) {
	    	scoreboard = new Scoreboard();
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("scoreboard.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(scoreboard);
				oos.close();
			} catch (Exception exception) {
				System.out.println("Exception?: " + exception.toString());
			}
		}
		
		makeJTable();
    	background = new JLabel(new ImageIcon("ProjectPics/scoreboardBackground.jpg"));
        background.setLayout(new FlowLayout());
        background.add(renderable_scoreboard);
        
        this.add(background);
    	
    }
    
    /**
     * This method creates a 10x3 table for the scoreboard, to be projected onto the screen
     */
    private void makeJTable() {
    	String[][] tableData = new String[10][3];
    	String[] columnNames = {"Total Score", "Osprey Game Score", "Clapper Rail Game Score"};
    	
    	ArrayList<Score> scores = scoreboard.getScores();
    	
    	// As much as I'd rather use an iterator, JTable only accepts array parameters
    	// and I need to know the index I am on at any time for this algorithm
    	for(int i = 0; i < scores.size(); i++){
    		tableData[i][0] = Integer.toString(scores.get(i).cumulative_score);
    		tableData[i][1] = Integer.toString(scores.get(i).foodgame_score);
    		tableData[i][2] = Integer.toString(scores.get(i).nestgame_score);
    	}
    	
    	renderable_scoreboard = new JTable(tableData, columnNames);
    	
    }
    
    /**
     * This method takes the users score and inserts it into the file
     */
    public void insertNewScore() {
    	scoreboard.addScore(ModelFoodGame.getScore(), ModelNestGame.getScore());
    	makeJTable();
    	FileOutputStream fos;
		try {
			fos = new FileOutputStream("scoreboard.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(scoreboard);
			oos.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
    }
	
}
