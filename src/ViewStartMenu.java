import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ViewStartMenu extends JPanel{
    String birdType;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();

    JButton ospreyButton;
    JButton clapperButton;
    JLabel textLabel;
    JLabel background;

    ViewStartMenu(ActionListener a1, ActionListener a2, String text) {
        
    	ospreyButton = new JButton(new ImageIcon("ProjectPics/OspreyButton.jpg"));
    	ospreyButton.addActionListener(a1);
    	ospreyButton.setBorderPainted(false);
    	ospreyButton.setFocusPainted(false);
    	ospreyButton.setContentAreaFilled(false);
    	
    	clapperButton = new JButton( new ImageIcon("ProjectPics/ClapperButton.jpg"));
    	clapperButton.addActionListener(a2);
    	clapperButton.setFocusPainted(false);
    	clapperButton.setBorderPainted(false);
    	clapperButton.setFocusPainted(false);
    	clapperButton.setContentAreaFilled(false);
    
    	
       textLabel = new JLabel(text);
        
        background = new JLabel(new ImageIcon("ProjectPics/MainScreen.jpg"));
        background.setLayout(new FlowLayout());
        background.add(ospreyButton);
        background.add(clapperButton);

        this.add(background);
	}

}
