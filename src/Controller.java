import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
    private View view;
    private Model model;
	private PlayableBird mainBird;
	private DropBird dropbird;
	private Foe foe;

    Controller(){
    	
    	view = new View();
    	mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
    	foe = new Foe("ProjectPics/Eagle.png", "Eagle", view.getWidth(), view.getHeight());
    	model = new Model(view.getWidth(), view.getHeight(), mainBird, foe);
    	view.addObjects(mainBird, foe);
    	
    	view.frame.addKeyListener(new KeyListener() {
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

    void start(){
    	while(true) {
    		model.update();
    		
    		view.update(mainBird.xPos, mainBird.yPos, mainBird, foe);
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
		
    }
}
