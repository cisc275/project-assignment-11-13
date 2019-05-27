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
        return objects;
    }
    
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
    		double percentDone = startTime;
        	percentDone = (startTime-time)/percentDone;
        	map.updateProgress(percentDone);
        	mainBird.setScore(score);
    	}
    	
    	

    	if (time < 0) {
    		this.gs = GameState.NESTGAME;
    	}
    }
    
    public GameState getState() {
    	return gs;
    }
    
    public PlayableBird getPlayableBird() {
    	return mainBird;
    }

    public Minimap getMap() {
    	return map;
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
    
    public static int getScore() {
    	return score;
    }
}
