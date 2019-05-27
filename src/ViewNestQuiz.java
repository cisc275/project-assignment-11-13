import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ViewNestQuiz extends JPanel{
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
    JButton optionA, optionB, optionC, optionD;// = new JButton("Osprey");
    JLabel question;
    JLabel background;
    JLabel answer, response;
    String responseMessege = " ";
    
    BufferedImage redX;
    BufferedImage greenCheck;
    
    boolean isAnswered = false;
    boolean isCorrect;

    /**
     * The constructor viewNestQuiz builds a background and adds JButton and 
     * JLabels to create a quiz view that had built in listeners
     * 
     * @param incorrect The actionListener that returns if the incorrect choice is picked
     * @param correct The actionListener that returns if correct choice is picked
     */
    ViewNestQuiz(ActionListener incorrect, ActionListener correct) {
    	
    	Border line = new LineBorder(Color.WHITE, 5);
    	Border margin = new EmptyBorder(5, 15, 5, 15);
    	Border compound = new CompoundBorder(line, margin);
    	
    	optionA = new JButton("To attract mates");
    	optionA.addActionListener(incorrect);
    	optionA.setFocusPainted(false);
    	optionA.setBorder(compound);
    	optionA.setFont(new Font(null, Font.BOLD, 12));
    	optionA.setForeground(Color.BLACK);
    	
    	optionB = new JButton("To protect against flood waters");
    	optionB.addActionListener(correct);
    	optionB.setFocusPainted(false);
    	optionB.setBorder(compound);
    	optionB.setFont(new Font(null, Font.BOLD, 12));
    	optionB.setForeground(Color.BLACK);
    	
    	optionC = new JButton("To scare off other clapper rails");
    	optionC.addActionListener(incorrect);
    	optionC.setFocusPainted(false);
    	optionC.setBorder(compound);
    	optionC.setFont(new Font(null, Font.BOLD, 12));
    	optionC.setForeground(Color.BLACK);
    	
    	optionD = new JButton("To keep the eggs away from water");
    	optionD.addActionListener(incorrect);
    	optionD.setFocusPainted(false);
    	optionD.setBorder(compound);
    	optionD.setFont(new Font(null, Font.BOLD, 12));
    	optionD.setForeground(Color.BLACK);
    
    	
    	question = new JLabel("Why do clapper rails build tall nests?");
    	question.setForeground(Color.WHITE);
    	question.setFont(new Font(null, Font.BOLD, 24));
    	
        
    	
    	
        background = new JLabel(new ImageIcon("ProjectPics/NestQuizBackground.jpg"));
        background.setLayout(new FlowLayout());
        background.add(question);
        background.add(optionA);
        background.add(optionB);
        background.add(optionC);
        background.add(optionD);
        this.add(background);
}
 
 }
    