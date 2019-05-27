import java.util.ArrayList;

public class Model {
    GameState gs;
    ModelFoodGame food;
    ModelNestGame nest;
    
    
    /**
     * Default constructor for Model
     */
    public Model() {}
    
    /**
     * Constructor for model to decide what logic to use dependent on what GameState it is in
     * 
     * @param frameWidth
     * @param frameHeight
     * @param gs
     */
    public Model(int frameWidth, int frameHeight, GameState gs) {
    	this.gs = gs;
        food = new ModelFoodGame(frameWidth, frameHeight, this.gs);
        nest = new ModelNestGame(frameWidth, frameHeight, this.gs);
    }

    /**
     * Decides which list of GameObjects to use depending on which portion of the game is being accessed.
     * 
     * @return ArrayList of objects dependent on the game
     */
    public ArrayList<GameObject> getObjects(){
    	ArrayList<GameObject> objects = food.getObjects();// = new ArrayList<>();
    	switch(gs) {
    	case FOODGAME:
    		objects = food.getObjects();
    		break;
    	case NESTGAME:
    		objects = nest.getObjects();
    		//System.out.println(" The nest game objects deal has been actiavated");
    		break;
    	//default:
    	//objects = food.getObjects();
    	}
    	return objects;
    }
    
    /**
     * Updates game to correct logic depending on which GameState is specified
     * 
     * @param gs
     */
    public void update(GameState gs){
    	this.gs = gs;
    	switch(this.gs) {
        case STARTMENU:
        	break;
        case FOODGAME:
        	food.update(gs);
        	this.gs = food.getState();
        	break;
        case NESTGAME:
        	nest.update(gs);
        	this.gs = nest.getState();
        	break;
        }
    }
    
    /**
     * @return the current GameState
     */
    public GameState getState() {
    	return gs;//GameState.FOODGAME;
    }
    
    /**
     * @return PlayableBird from food game
     */
    public PlayableBird getPlayableBird() {
    	return food.getPlayableBird();
    }
    
    /**
     * @return PlayableBird from nest game
     */
    public DropBird getDropBird() {
    	return nest.getDropBird();
    }
    

    /**
     * @return Map from the food game
     */
    public Minimap getMap() {
    	return food.getMap();
    }
}
