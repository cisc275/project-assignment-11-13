import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ViewFoodQuiz extends JPanel{
    //Game state attributes
    String birdType;

    //Screen and frame construction attributes
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    final static int buttonWidth = 100;
    final static int buttonHeight = 40;

    //Buttons
    JButton optionA, optionB, optionC, optionD;
    JLabel question;
    JLabel background;

    /**
     * The constructor viewFoodQuiz builds a background and adds JButton and 
     * JLabels to create a quiz view that had built in listeners
     * 
     * @param incorrect The actionListener that returns if the incorrect choice is picked
     * @param correct The actionListener that returns if correct choice is picked
     * @param text a filler parameter to meet the constructor requirements
     */
    ViewFoodQuiz(ActionListener incorrect, ActionListener correct , String text) {
    	Border line = new LineBorder(Color.DARK_GRAY, 5);
    	Border margin = new EmptyBorder(5, 15, 5, 15);
    	Border compound = new CompoundBorder(line, margin);
    	
    	optionA = new JButton("Grass");
    	optionA.addActionListener(incorrect);
    	optionA.setFocusPainted(false);
    	optionA.setBorder(compound);
    	optionA.setFont(new Font(null, Font.BOLD, 18));
    	optionA.setForeground(Color.DARK_GRAY);
    	
    	optionB = new JButton("Eagles");
    	optionB.addActionListener(incorrect);
    	optionB.setFocusPainted(false);
    	optionB.setBorder(compound);
    	optionB.setFont(new Font(null, Font.BOLD, 18));
    	optionB.setForeground(Color.DARK_GRAY);
    	
    	optionC = new JButton("Fish");
    	optionC.addActionListener(correct);
    	optionC.setFocusPainted(false);
    	optionC.setBorder(compound);
    	optionC.setFont(new Font(null, Font.BOLD, 18));
    	optionC.setForeground(Color.DARK_GRAY);
    	
    	optionD = new JButton("Trash");
    	optionD.addActionListener(incorrect);
    	optionD.setFocusPainted(false);
    	optionD.setBorder(compound);
    	optionD.setFont(new Font(null, Font.BOLD, 18));
    	optionD.setForeground(Color.DARK_GRAY);
    
    	
    	question = new JLabel("What type of food do Ospreys eat?");
    	question.setForeground(Color.DARK_GRAY);
    	question.setFont(new Font(null, Font.BOLD, 36));
        
        background = new JLabel(new ImageIcon("ProjectPics/FoodQuizBackground.jpg"));
        background.setLayout(new FlowLayout());
        background.add(question);
        background.add(optionA);
        background.add(optionB);
        background.add(optionC);
        background.add(optionD);


        this.add(background);
	}
}