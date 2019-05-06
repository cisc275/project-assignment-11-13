import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStartMenu extends JPanel{
    //Game state attributes
    String birdType;
    //GameState gs = GameState.STARTMENU;

    //Screen and frame construction attributes
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    //JPanel panel = new JPanel();

    //Buttons
    JButton ospreyButton;// = new JButton("Osprey");
    JButton clapperButton;// = new JButton("Clapper Rail");
    JLabel textLabel;

    ViewStartMenu(ActionListener a1, ActionListener a2, String text) {
		//JButton buttonNext = new JButton("next");
        //buttonNext.addActionListener(alNext);
        
    	ospreyButton = new JButton("Osprey");
    	ospreyButton.addActionListener(a1);
    	clapperButton = new JButton("Clapper Rail");
    	clapperButton.addActionListener(a2);
        textLabel = new JLabel(text);

        this.add(textLabel);
        this.add(ospreyButton);
        this.add(clapperButton);
	}
    
//    ViewStartMenu(){
//        //frame.getContentPane().add();
//        frame.setBackground(Color.cyan);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Estuary Extravaganza");
//        frame.setSize(frameWidth, frameHeight);
//
//        panel.add(ospreyButton);
//        ospreyButton.setBounds(0, 0, 75, 25);
//        panel.add(clapperButton);
//        clapperButton.setBounds(50, 0, 75, 25);
//
//        frame.getContentPane().add(panel);
//
//        frame.setUndecorated(true);
//        frame.setVisible(true);
//        frame.setFocusable(true);
//    }

//    public void checkGameState(){
//        if(gs.equals(GameState.FOODGAME)){
//            frame.setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        Controller control = new Controller();
//    }

}
