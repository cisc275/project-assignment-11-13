import java.util.ArrayList;
import java.util.Collection;

public class ModelFoodGame {
    GameState gs;
    private int frameWidth;
    private int frameHeight;
    private PlayableBird mainBird;
    private Foe foe;
    private int time;
    private Collection<Food> consumables;
    private int score;
    
    private static final int EDIBLEFOODCOUNT = 3; // determines how many edible food objects will exist at any one time
    private static final int NONEDIBLECOUNT = 3; // determines how many non-edible food objects will exist at any one time
    private static final int SCROLLSPEED = 6; // determines how fast the player bird moves through the environment (how fast food, background moves back)
    
    public ModelFoodGame(int frameWidth, int frameHeight, GameState gs) {//, PlayableBird bird) {//, Foe foe) {//, int imgWidth, int imgHeight){
    	this.gs = gs;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
        this.foe = new Foe("ProjectPics/Eagle.png", "Eagle", frameWidth, frameHeight);
        time = 1;
        consumables = new ArrayList<Food>();
        createConsumables();
    }

    public ArrayList<GameObject> getObjects(){
    	ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(mainBird);
        objects.add(foe);
        for (Food f : consumables) {
        	objects.add(f);
        }
        return objects;
    }
    
    public void update(GameState gs){
    	this.gs = gs;
    	mainBird.move(frameHeight);
    	foe.move(frameWidth, frameHeight);
    	if(mainBird.collidesWith(foe)){
    		score -= 10;
    		foe.reset(frameWidth, frameHeight);
    		System.out.println("ow");
    	}
    	for(Food f: consumables) {
    		f.move(SCROLLSPEED, frameWidth, frameHeight);
    		if(mainBird.collidesWith(f)) {
    			score += f.getPointValue();
    			f.reset(frameWidth, frameHeight);
    		}
    	}
    	
    	time--;
    	if (time < 0) {
    		this.gs = GameState.NESTGAME;
    	}
    	System.out.println("Score: " + score);
    }
    
    public GameState getState() {
    	return gs;
    }
    
    public PlayableBird getPlayableBird() {
    	return mainBird;
    }
    
    private void createConsumables() {
    	// initializing the ArrayList with the proper number of each type of food
    	
    	for(int i = 0; i < EDIBLEFOODCOUNT; i++) {
    		consumables.add(new EdibleFood(frameWidth, frameHeight));
    	}
    	for(int i = 0; i < NONEDIBLECOUNT; i++) {
    		consumables.add(new NonEdibleFood(frameWidth, frameHeight));
    	}
    }
}