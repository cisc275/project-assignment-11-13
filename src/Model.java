import java.util.ArrayList;

public class Model {
    GameState gs;
    ModelFoodGame food;
    ModelNestGame nest;
    
    
    public Model() {}
    
    public Model(int frameWidth, int frameHeight, GameState gs) {
    	this.gs = gs;
        food = new ModelFoodGame(frameWidth, frameHeight, this.gs);
        nest = new ModelNestGame(frameWidth, frameHeight, this.gs);
    }

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
    
    public void update(GameState gs){
    	this.gs = gs;
    	//System.out.println("model: " + this.gs);
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
    
    public GameState getState() {
    	return gs;//GameState.FOODGAME;
    }
    
    public PlayableBird getPlayableBird() {
    	return food.getPlayableBird();
    }
    
    public DropBird getDropBird() {
    	return nest.getDropBird();
    }
    

    public Minimap getMap() {
    	return food.getMap();
    }
}
