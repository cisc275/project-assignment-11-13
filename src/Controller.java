import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;

public class Controller implements ActionListener, KeyListener {
    private View view;
    private ViewStartMenu startView;
    private Model model;
    private PlayableBird mainBird;
	private DropBird dropbird;
	private Foe foe;
	private Collection<Food> foodGameConsumables;
	private GameState gs;

	/* Constructor for Controller responsible for initializin the model, gameState, and views */
    Controller(){
    	gs = GameState.STARTMENU;
    	view = new View(gs);
    	model = new Model(view.getWidth(), view.getHeight(), gs);
    	view.addFoodGameListener(model.getPlayableBird());
    	view.addNestGameListener(model.getDropBird());
    }

    /** 
     * Initial verification of gameState, performing operations to load the specific view pertaining to the gameState 
     * 
     * @return void
     **/
	void start(){
		while(true) {
			switch(gs){
				case STARTMENU:
					gs = view.getState();
					break;
			}
			model.update(gs);
			
			// One-time insertion of new score into score board
			if(model.getState().equals(GameState.SCOREBOARD) && !gs.equals(GameState.SCOREBOARD)) {
				view.scoreboard.insertNewScore();
			}
			
			
			gs = model.getState();
			if (gs.equals(GameState.FOODGAME))
				view.update(model.getObjects(), model.getMap(), gs);
			else view.update(model.getObjects(), gs);
		}
	}

	/** 
	 * The following Action and Key Events are in place solely to meet import requirements
	 */
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
    
    /**
     * GameState getter
     * 
     * @return GameState
     */
    
    public GameState getGS(){
    	return this.gs;
	}

    /**
     * GameState setter
     *  
     * @param gs
     * @return void
     */
	public void setGS(GameState gs){
    	this.gs = gs;
	}
}
