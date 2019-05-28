import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class View extends JPanel {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    
    CardLayout cardLayout;
    ViewStartMenu menu;
    ViewFoodGame food;
    ViewNestGame nest;
    ViewNestQuiz nestQuiz;
    ViewFoodQuiz foodQuiz;
    ViewScoreboard scoreboard;
    GameState gs;
    
    
    PlayableBird mainBird; //need in order to add listeners
    DropBird dropBird; //need in order to add listeners
    
    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Controller control = new Controller();
        control.start();
    	/*
    	MyTests tests = new MyTests();
    	tests.Test1();
    	tests.Test2();
    	tests.Test3();
    	tests.Test4();
    	tests.Test5();
    	tests.Test6();
    	tests.Test7();
    	tests.Test8();
    	tests.Test9();
    	tests.Test10();
    	tests.Test11();
    	tests.Test12();
    	tests.Test13();
    	tests.Test14();
    	tests.Test15();
    	tests.Test16();
    	*/
    }
    
    /**
     * Retrieves the frame width
     * 
     * @return int
     */
    public int getWidth() {
        return frameWidth;
    }

    /**
     * Retrieves the frame height
     * 
     * @return int
     */
    public int getHeight() {
        return frameHeight;
    }
    
    /**
     * Constructor for the View object (utilized for all subclasses as well)
     * Initializes the cardLayout used for view transitions throughout the game 
     * Also implements action listeners in order to understand when screen transitions are to occur
     * 
     * Generates initial frame
     * 
     * @param state
     */
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
	    
	    @SuppressWarnings("unused")
		ActionListener al = e -> cardLayout.next(frame.getContentPane());
	    ActionListener osp = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		gs = GameState.FOODGAME;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener clap = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		gs = GameState.NESTGAME;
	    		cardLayout.next(frame.getContentPane());
	    		cardLayout.next(frame.getContentPane());
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    
	    ActionListener correctFood = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	 	try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e1) {
	    			e1.printStackTrace();
	    		}
	    		gs = GameState.NESTGAME;
	    		cardLayout.next(frame.getContentPane());
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener incorrectFood = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e1) {
	    			e1.printStackTrace();
	    		}
	    		gs = GameState.NESTGAME;
	    		cardLayout.next(frame.getContentPane());
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    
	    ActionListener correctNest = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	 	try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e1) {
	    			e1.printStackTrace();
	    		}
	    		gs = GameState.SCOREBOARD;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    ActionListener incorrectNest = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e1) {
	    			e1.printStackTrace();
	    		}
	    		gs = GameState.SCOREBOARD;
	    		cardLayout.next(frame.getContentPane());
	    	}
	    };
	    
	    
	    
	    menu = new ViewStartMenu(osp, clap,  "Select Bird:");
	    food = new ViewFoodGame();
	    foodQuiz = new ViewFoodQuiz(incorrectFood, correctFood, "Food quiz: ");
	    nest = new ViewNestGame();
	    nestQuiz = new ViewNestQuiz(incorrectNest, correctNest, "Nest Quiz: ");
	    scoreboard = new ViewScoreboard();
	    frame.getContentPane().add(menu);
	    frame.getContentPane().add(food);
	    frame.getContentPane().add(foodQuiz);
	    frame.getContentPane().add(nest);
	    frame.getContentPane().add(nestQuiz);
	    frame.getContentPane().add(scoreboard);
	    frame.setVisible(true);
    }
    
    /**
     * Generates the listener for the food game with actions performed on specific arrow key presses
     * 
     * @return voi
     * @param mainBird
     */
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
			public void keyTyped(KeyEvent e) {}

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
    
    /**
     * Generates the listener for the nest game with actions performed on space key presses
     * 
     * @return void
     * @param mainBird
     */
    public void addNestGameListener(DropBird dropBird) {
    	frame.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        			dropBird.dropStick();
        		}
        		
        		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        			System.exit(1);
        		}
        	}

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
        });
    }
    
    /**
     * Checker for the game state, observing which view is to be loaded based upon the cardLayout
     * 
     * @return void
     * @param objects
     * @param gs
     */
    public void update(ArrayList<GameObject> objects, GameState gs){
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
    
    /**
     * Overloaded function specifically for the food game, designed to load the next frame
     * 
     * @return void
     * @param objects
     * @param map
     * @param gs
     */
    public void update(ArrayList<GameObject> objects, Minimap map, GameState gs){
    	//check for change of gameState
    	if (this.gs != gs)
    		cardLayout.next(frame.getContentPane());
    	this.gs = gs;
    	
    	food.update(objects, map);
    	
        //Pause after each frame
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the game state
     * 
     * @return GameState
     */
    public GameState getState() {
    	return gs;
    }
    
    /**
     * Empty paint method used as a placeholder for frame updating
     * 
     * @param g
     * @return void
     */
    public void paint(Graphics g){
    }
}
