import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
    private View view;
    private ViewStartMenu startView;
    private Model model;
	private DropBird dropbird;
	private GameState gs;

    Controller(){
    	gs = GameState.STARTMENU;
    	view = new View(gs);
    	model = new Model(view.getWidth(), view.getHeight(), gs);
    	view.addFoodGameListener(model.getPlayableBird());
    	//view.addNestGameListener(model.getDropBird());
    }


	void start(){
		while(true) {
			if (gs==GameState.STARTMENU)
				gs = view.getState(); //need this because of buttons on the view of the startmenu
			model.update(gs);
			gs = model.getState();
			view.update(model.getObjects(), gs);
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

    public GameState getGS(){
    	return this.gs;
	}

	public void setGS(GameState gs){
    	this.gs = gs;
	}
}
