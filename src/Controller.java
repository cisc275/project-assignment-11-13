import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
    View view;
    Model model;

    public Controller(){
    	view = new View();
    	model = new Model(view.getWidth(), view.getHeight());
    	
    	view.frame.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_UP) {
        			model.mainBird.upPressed = true; //Probably shouldn't call the bird's attributes like this directly, right? how should we change it?
        		}
        		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        			model.mainBird.downPressed = true; //Probably shouldn't call the bird's attributes like this directly, right? how should we change it?
        		}
        	}

			@Override
			public void keyTyped(KeyEvent e) {
				//In place just to have all required methods
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					model.mainBird.upPressed = false;
	    		}
	    		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    			model.mainBird.downPressed = false;
	    		}
			}
        });
    }

    public void start(){
    	for (int i = 0; i < 100; i++) {
    		model.update();
    		
    		view.update();
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
