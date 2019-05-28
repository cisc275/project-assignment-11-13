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
    private static int score;
    boolean tutorial = true;
    private Minimap map;
    GameObject tutorialUpDn;
    GameObject tutorialSpace;
    GameObject tutorialItems;
    
    private static final int startTime = 1000;
    private static final int EDIBLEFOODCOUNT = 3; // determines how many edible food objects will exist at any one time
    private static final int NONEDIBLECOUNT = 3; // determines how many non-edible food objects will exist at any one time
    private static final int SCROLLSPEED = 6; // determines how fast the player bird moves through the environment (how fast food, background moves back)
    
    /**
     * Constructor for ModelFoodGame; establishes all objects necessary for the main game as well as the tutorial
     * 
     * @param frameWidth
     * @param frameHeight
     * @param gs
     */
    public ModelFoodGame(int frameWidth, int frameHeight, GameState gs) {//, PlayableBird bird) {//, Foe foe) {//, int imgWidth, int imgHeight){
    	this.gs = gs;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
        this.foe = new Foe("ProjectPics/Eagle.png", "Eagle", frameWidth, frameHeight);
        time = startTime+100;
        map = new Minimap("ProjectPics/Map.png", "ProjectPics/MapPath.png", frameWidth, frameHeight);
        tutorialUpDn = new GameObject("ProjectPics/Food_Instructions_UpDn.png", 200, 10);
        tutorialSpace = new GameObject("ProjectPics/Food_Instructions_Space.png", 500, 10);
        tutorialItems = new GameObject("ProjectPics/Food_Instructions_Items.png", 400, 10);
        consumables = new ArrayList<Food>();
        createConsumables();
        score = 0;
    }
    
    /**
     * Generates all objects dependent on the time elapsed in the game (tutorial based or main game based)
     * 
     * @return ArrayList<GameObject>
     */
    public ArrayList<GameObject> getObjects(){
    	ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(mainBird);
        if (tutorial) {
        	if (time > startTime+25) {
        		objects.add(tutorialUpDn);
        	}
        	else if (time > startTime) {
        		objects.add(tutorialUpDn);
        		objects.add(tutorialSpace);
        	}
        	else {
        		time++;
        		objects.add(tutorialUpDn);
        		objects.add(tutorialSpace);
        	}
        }
        else {
        	if (time > startTime-100)
        		objects.add(tutorialItems);
        	objects.add(foe);
        	for (Food f : consumables) {
        		objects.add(f);
        	}
        }
        //objects.add(tutorialUpDn);
        return objects;
    }
    
    /**
     * Updates the game and gives appropriate instructions to change the view as communicated through the controller
     * Also addresses the situations regarding collisions
     * 
     * @return void
     * @param gs
     */
    public void update(GameState gs){
    	time--;
    	if (tutorial == true) {
    		this.gs = gs;
    		mainBird.move(frameHeight);
    		foe.move(frameWidth, frameHeight);
    		if(mainBird.collidesWith(foe)){
    			foe.reset(frameWidth, frameHeight);
    		}
    		if(mainBird.spacePressed == true) {
    			tutorial = false;
    			time = startTime;
    		}
    		map.updateProgress(0);
    	}
    	else {
    		this.gs = gs;
    		mainBird.move(frameHeight);
    		foe.move(frameWidth, frameHeight);
    		if(mainBird.collidesWith(foe)){
    			score -= 5;
    			if (score < 0)
    				score = 0;
    			mainBird.ow();
    			foe.reset(frameWidth, frameHeight);
    			//System.out.println("ow");
    		}
    		for(Food f: consumables) {
    			f.move(SCROLLSPEED, frameWidth, frameHeight);
    			if(mainBird.collidesWith(f)) {
    				score += f.getPointValue();
    				if (score < 0)
    					score = 0;
    				if (f.getPointValue() < 0)
    					mainBird.ow();
    				else mainBird.yay();
    				f.reset(frameWidth, frameHeight);
    			}
    		}
    		double percentDone = startTime;
        	percentDone = (startTime-time)/percentDone;
        	map.updateProgress(percentDone);
        	mainBird.setScore(score);
    	}
    	
    	

    	if (time < 0) {
    		this.gs = GameState.FOODQUIZ;
    		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nOsprey Final Score: "+ score);
    	}
    }
    
    /**
     * Resets the game's state if necessary (used in the tutorial)
     */
    public void reset() {
    	time = startTime;
    	score = 0;
    	mainBird.setScore(0);
    }
    /**
     * Retrieves the game's state
     * 
     * @return GameState
     */
    public GameState getState() {
    	return gs;
    }
    
    /**
     * Retrieves the mainBird
     * 
     * @return PlayableBird
     */
    public PlayableBird getPlayableBird() {
    	return mainBird;
    }

    /**
     * Retrieves the map
     * 
     * @return Minimpap
     */
    public Minimap getMap() {
    	return map;
    }
    
    /**
     * Generates the consumables as necessary based upon the amount of edible and non-edible food desired
     * Can be modified to change difficulty
     * 
     * @return void
     */
    private void createConsumables() {
    	// initializing the ArrayList with the proper number of each type of food
    	
    	for(int i = 0; i < EDIBLEFOODCOUNT; i++) {
    		consumables.add(new EdibleFood(frameWidth, frameHeight));
    	}
    	for(int i = 0; i < NONEDIBLECOUNT; i++) {
    		consumables.add(new NonEdibleFood(frameWidth, frameHeight));
    	}
    }
    
    /**
     * Retrieves the score
     * 
     * @return int
     */
    public static int getScore() {
    	return score;
    }
    
    /**
     * getter for the time, only used in testing
     * @return time
     */
    public int getTime() {
    	return time;
    }
}
