import java.util.ArrayList;

public class Model {
    GameState gs;
    ModelFoodGame food;
    
    
    public Model() {}
    
    public Model(int frameWidth, int frameHeight, GameState gs) {
    	this.gs = gs;
        food = new ModelFoodGame(frameWidth, frameHeight, this.gs);
    }

    public ArrayList<GameObject> getObjects(){
    	ArrayList<GameObject> objects;// = new ArrayList<>();
//    	switch(gs) {
//    	case FOODGAME:
//    		default:
    		objects = food.getObjects();
//    	}
    		
    	return objects;
    }
    
    public void update(GameState gs){
    	this.gs = gs;
    	//System.out.println("model: " + gs);
    	switch(this.gs) {
        case STARTMENU:
        	break;
        case FOODGAME:
        	food.update(gs);
        	this.gs = food.getState();
        	break;
        case NESTGAME:
        }
    }
    
    public GameState getState() {
    	return gs;//GameState.FOODGAME;
    }
    
    public PlayableBird getPlayableBird() {
    	return food.getPlayableBird();
    }
}
