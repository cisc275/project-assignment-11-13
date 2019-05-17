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
    //String name;
    
    CardLayout cardLayout;
    ViewStartMenu menu;
    ViewFoodGame food;
    ViewNestGame nest;
    ViewNestQuiz nestQuiz;
    GameState gs;
    
    
    PlayableBird mainBird; //need in order to add listeners
    DropBird dropBird; //need in order to add listeners
    
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
    
    public View(GameState state){
    	this.gs = state;
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
	    		gs = GameState.NESTGAME;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener correct = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("Correct");
	    		gs = GameState.NESTGAME;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener incorrect = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("incorrect");
	    		gs = GameState.SCOREBOARD;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    
	    
	    menu = new ViewStartMenu(osp, clap,  "Select Bird:");
	    food = new ViewFoodGame();
	    nest = new ViewNestGame();
	    nestQuiz = new ViewNestQuiz(correct, incorrect, "Nest quiz : ");
	    frame.getContentPane().add(menu);
	    frame.getContentPane().add(food);
	    frame.getContentPane().add(nest);
	    frame.getContentPane().add(nestQuiz);
	    frame.setVisible(true);
    }
    
    public void addFoodGameListener(PlayableBird mainBird) {
    	frame.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_UP) {
        			mainBird.setUpPressed(true);
        		}
        		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        			mainBird.setDownPressed(true);
        		}
        		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        			mainBird.setSpacePressed(true);
        		}
        		
        		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        			System.exit(1);
        		}
        	}

			@Override
			public void keyTyped(KeyEvent e) {
				//In place just to have all required methods
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					mainBird.setUpPressed(false);
	    		}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					mainBird.setDownPressed(false);
	    		}
				else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					mainBird.setSpacePressed(false);
					
	    		}
			}
        });
    }
    
    public void addNestGameListener(DropBird dropBird) {
    	frame.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        			dropBird.dropStick();
        			System.out.println("space pressed");
        		}
        		
        		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        			System.exit(1);
        		}
        	}

			@Override
			public void keyTyped(KeyEvent e) {
				//In place just to have all required methods
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//
			}
        });
    }
    
    public void update(ArrayList<GameObject> objects, GameState gs){
    	//System.out.println("view: " + this.gs);
    	//check for change of gameState
    	if (this.gs != gs)
    		cardLayout.next(frame.getContentPane());
    	this.gs = gs;
        //Pick which panel to update based on the game state
    	switch(this.gs) {
        case STARTMENU:
        	break;
        case FOODGAME:
        	food.update(objects);
        	break;
        case NESTGAME:
        	nest.update(objects);
        	break;
        default:
        	break;
        }
        
        //Pause after each frame
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public GameState getState() {
    	return gs;
    }
    //I don't think this will ever be necessary because paint is called in the individual subviews
    public void paint(Graphics g){
    }
}
