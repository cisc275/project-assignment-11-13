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
    GameState gs = GameState.NESTGAME;

    //Screen and frame construction attributes
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    //JPanel panel = new JPanel();

    //Buttons
    JButton question, optionA, optionB, optionC, optionD;// = new JButton("Osprey");
    BufferedImage greenCheck, redX;
    JLabel textLabel;
    JLabel background;
    Graphics g;
    
    boolean isAnswered = false;
    boolean isCorrect;

    ViewNestQuiz(ActionListener incorrect, ActionListener correct , String text) {
		//JButton buttonNext = new JButton("next");
        //buttonNext.addActionListener(alNext);
    	
    	Border line = new LineBorder(Color.DARK_GRAY, 5);
    	Border margin = new EmptyBorder(5, 15, 5, 15);
    	Border compound = new CompoundBorder(line, margin);
    	
    	question = new JButton(new ImageIcon("ProjectPics/NestQuizQuestion.PNG"));
    	question.setBorderPainted(false);
    	question.setFocusPainted(false);
    	question.setContentAreaFilled(false);
    	
    	optionA = new JButton("To attract mates");
    	optionA.addActionListener(correct);
      	optionA.setBorder(compound);
    	optionA.setFont(new Font(null, Font.BOLD, 18));
    	optionA.setForeground(Color.DARK_GRAY);
    	
    	optionB = new JButton("To protect against flood waters");
    	optionB.addActionListener(incorrect);
    	optionB.setFocusPainted(false);
     	optionB.setBorder(compound);
    	optionB.setFont(new Font(null, Font.BOLD, 18));
    	optionB.setForeground(Color.DARK_GRAY);
    	
    	optionC = new JButton("To scare off other Clapper Rails");
    	optionC.addActionListener(incorrect);
    	optionC.setFocusPainted(false);
     	optionC.setBorder(compound);
    	optionC.setFont(new Font(null, Font.BOLD, 18));
    	optionC.setForeground(Color.DARK_GRAY);
    	
    	optionD = new JButton( "To keep eggs out of salt water");
    	optionD.addActionListener(incorrect);
    	optionD.setFocusPainted(false);
     	optionD.setBorder(compound);
    	optionD.setFont(new Font(null, Font.BOLD, 18));
    	optionD.setForeground(Color.DARK_GRAY);
    	
    	greenCheck =  createImage("ProjectPics/correct.png");
    	
    	redX =  createImage("ProjectPics/incorrect.png");
    
    	
    	textLabel = new JLabel(text);
        
        background = new JLabel(new ImageIcon("ProjectPics/NestGameBackgroud.jpg"));
        background.setLayout(new FlowLayout());
        background.add(question);
        background.add(optionA);
        background.add(optionB);
        background.add(optionC);
        background.add(optionD);
        
        
        System.out.println("ViewNestQuiz accessed");


        this.add(background);
	}
    
    public void setAnswer(boolean correct) {
    	System.out.println("setAnswer method called'");
    	isAnswered = true;
    	if(correct == true) {
    		isCorrect = true;
        }else {
    		isCorrect = false;
       	}
    	this.repaint();
       	return;
    }
    
    
    public void paint(Graphics g) {
    	System.out.println("viewNestGame paint method called'");
    	if(isAnswered = true) {
    		if(isCorrect = true) {
    			g.drawImage(greenCheck, 200, 200, this);
    		}else {
    	    	g.drawImage(redX, 200, 200, this);
    		}
    	}
    }
    
    
    public BufferedImage createImage(String path) {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(path)); //Utilizes the path name
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return null;
    }
    
 }
    