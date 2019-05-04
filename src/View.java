import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View extends JPanel {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    String name;
    
    CardLayout cardLayout;
    ViewStartMenu menu;
    public ViewFoodGame food;
    ViewNestGame nest;
    
    GameState gs;
    
    
    PlayableBird mainBird;
    Foe foe;
    
    public static void main(String[] args) {
        Controller control = new Controller();
        control.start();
    }
    
    public int getWidth() {
        return frameWidth;
    }

    public int getHeight() {
        return frameHeight;
    }
    
    public View(){
    	gs = GameState.STARTMENU;
    	
    	//frame.getContentPane().add(this);
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setFocusable(true);
        
        cardLayout = new CardLayout();

	    frame.getContentPane().setLayout(cardLayout);
	    
	    ActionListener al = e -> cardLayout.next(frame.getContentPane());
	    ActionListener osp = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("Osprey");
	    		gs = GameState.FOODGAME;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener clap = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("Clapper Rail");
	    		gs = GameState.FOODGAME;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    
	    menu = new ViewStartMenu(osp, clap,  "Select Bird:");
	    food = new ViewFoodGame();
	    
	    frame.getContentPane().add(menu);
	    frame.getContentPane().add(food);
	    frame.setVisible(true);
    }

    
    public void update(PlayableBird bird, Foe foe){
        //Pick which panel to update based on the game state
    	switch(gs) {
        case STARTMENU:
        	break;
        case FOODGAME:
        	food.update(bird, foe);
        	break;
        }
        
        //Pause after each frame
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage createImage(String path) {
        BufferedImage bufferedImage;
        try {
            System.out.println();
            bufferedImage = ImageIO.read(new File(path)); //Utilizes the path name
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //I don't think this will ever be necessary because paint is called in the individual subviews
    public void paint(Graphics g){
    }
}
