import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JLabel textLabel;
    JLabel background;

    ViewNestQuiz(ActionListener incorrect, ActionListener correct , String text) {
		//JButton buttonNext = new JButton("next");
        //buttonNext.addActionListener(alNext);
    	question = new JButton(new ImageIcon("ProjectPics/NestQuizQuestion.PNG"));
    	question.setBorderPainted(false);
    	question.setFocusPainted(false);
    	question.setContentAreaFilled(false);
    	
    	optionA = new JButton(new ImageIcon("ProjectPics/NGa.PNG"));
    	optionA.addActionListener(correct);
    	optionA.setBorderPainted(false);
    	optionA.setFocusPainted(false);
    	optionA.setContentAreaFilled(false);
    	
    	optionB = new JButton( new ImageIcon("ProjectPics/NGb.PNG"));
    	optionB.addActionListener(incorrect);
    	optionB.setFocusPainted(false);
    	optionB.setBorderPainted(false);
    	optionB.setFocusPainted(false);
    	optionB.setContentAreaFilled(false);
    	
    	optionC = new JButton( new ImageIcon("ProjectPics/NGc.PNG"));
    	optionC.addActionListener(incorrect);
    	optionC.setFocusPainted(false);
    	optionC.setBorderPainted(false);
    	optionC.setFocusPainted(false);
    	optionC.setContentAreaFilled(false);
    	
    	optionD = new JButton( new ImageIcon("ProjectPics/NGd.PNG"));
    	optionD.addActionListener(incorrect);
    	optionD.setFocusPainted(false);
    	optionD.setBorderPainted(false);
    	optionD.setFocusPainted(false);
    	optionD.setContentAreaFilled(false);
    
    	
    	textLabel = new JLabel(text);
        
        background = new JLabel(new ImageIcon("ProjectPics/NestGameBackgroud.jpg"));
        background.setLayout(new FlowLayout());
        background.add(question);
        background.add(optionA);
        background.add(optionB);
        background.add(optionC);
        background.add(optionD);


        this.add(background);
	}
}