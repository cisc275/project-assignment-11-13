import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewScoreboard extends JPanel {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    
    Object[][] scoreInfo = {{ModelFoodGame.getScore(), ModelNestGame.getScore()}};
    String[] colHeaders = {"Osprey Game Score", "Clapper Rail Game Score"};
    
    JTable scoreboard;
    JLabel background;
    
    public ViewScoreboard() {
    	scoreboard = new JTable(scoreInfo, colHeaders);
    	background = new JLabel(new ImageIcon("ProjectPics/scoreboardBackground.jpg"));
        background.setLayout(new FlowLayout());
        background.add(scoreboard);
        
        this.add(background);
    	
    }
	
}
