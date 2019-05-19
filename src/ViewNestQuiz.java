import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewNestQuiz extends JPanel{
    //Game state attributes
    String birdType;
    //GameState gs = GameState.NESTGAME;

    //Screen and frame construction attributes
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    final static int buttonWidth = 100;
    final static int buttonHeight = 40;
    //JPanel panel = new JPanel();

    //Buttons
    JButton optionA, optionB, optionC, optionD;// = new JButton("Osprey");
    JLabel question;
    JLabel background;
    JLabel answer;
    
    BufferedImage redX;
    BufferedImage greenCheck;
    
    boolean isAnswered = false;
    boolean isCorrect;

    ViewNestQuiz(ActionListener incorrect, ActionListener correct , String text) {
    	Border line = new LineBorder(Color.WHITE, 5);
    	Border margin = new EmptyBorder(5, 15, 5, 15);
    	Border compound = new CompoundBorder(line, margin);
    	
    	optionA = new JButton("To attract mates");
    	optionA.addActionListener(correct);
    	optionA.setFocusPainted(false);
    	optionA.setBorder(compound);
    	//optionA.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
    	optionA.setFont(new Font(null, Font.BOLD, 12));
    	optionA.setForeground(Color.WHITE);
    	
    	optionB = new JButton("To protect against flood waters");
    	optionB.addActionListener(incorrect);
    	optionB.setFocusPainted(false);
    	optionB.setBorder(compound);
    	//optionB.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
    	optionB.setFont(new Font(null, Font.BOLD, 12));
    	optionB.setForeground(Color.WHITE);
    	
    	optionC = new JButton("To scare off other clapper rails");
    	optionC.addActionListener(incorrect);
    	optionC.setFocusPainted(false);
    	optionC.setBorder(compound);
    	//optionC.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
    	optionC.setFont(new Font(null, Font.BOLD, 12));
    	optionC.setForeground(Color.WHITE);
    	
    	optionD = new JButton("To keep the eggs away from water");
    	optionD.addActionListener(incorrect);
    	optionD.setFocusPainted(false);
    	optionD.setBorder(compound);
    	//optionD.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
    	optionD.setFont(new Font(null, Font.BOLD, 12));
    	optionD.setForeground(Color.WHITE);
    
    	
    	question = new JLabel("Why do clapper rails build tall nests?");
    	question.setForeground(Color.WHITE);
    	question.setFont(new Font(null, Font.BOLD, 24));
    	
        
        background = new JLabel(new ImageIcon("ProjectPics/NestQuizBackground.jpg"));
        background.setLayout(new FlowLayout());
        background.add(question);
        //background.add(question);
        background.add(optionA);
        background.add(optionB);
        background.add(optionC);
        background.add(optionD);


        this.add(background);
}
    
    
    public void setAnswer(boolean correct) {
    	System.out.println("Set answer accessed");
    	if(correct == true) {												//correct answer
    		answer = new JLabel("Correct! + 5 points!");
    		answer.setForeground(Color.GREEN);
    		answer.setFont(new Font(null, Font.BOLD, 24));
        }else {																//incorrect answer
        	answer = new JLabel("Incorrect, please try again");
        	answer.setForeground(Color.RED);
        	answer.setFont(new Font(null, Font.BOLD, 24));
       	}
    	background.add(answer);
        this.add(background);
       	return;
    }
    
    
    
 }
    