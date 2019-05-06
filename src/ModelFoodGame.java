import java.util.*;

public class ModelFoodGame implements Model{
	   	private int frameWidth;
	    private int frameHeight;
	    private PlayableBird mainBird;
	    private Foe foe;
	    private Collection<Food> consumables;
	    private int score;
	    
	    private static final int EDIBLEFOODCOUNT = 3; // determines how many edible food objects will exist at any one time
	    private static final int NONEDIBLECOUNT = 3; // determines how many non-edible food objects will exist at any one time
	    private static final int SCROLLSPEED = 8; // determines how fast the player bird moves through the environment (how fast food, background moves back)
	    
	    public ModelFoodGame(int frameWidth, int frameHeight, PlayableBird bird, Foe foe, Collection<Food> consumables){
	        this.frameWidth = frameWidth;
	        this.frameHeight = frameHeight;
	        this.mainBird = bird;
	        this.foe = foe;
	        this.consumables = consumables;
	        createConsumables();
	    }

	    public void update(){
		    	mainBird.move(frameHeight);
		    	foe.move(frameWidth, frameHeight);
		    	if(mainBird.collidesWith(foe)){
		    		score -= 10;
		    		foe.reset(frameWidth, frameHeight);
		    	}
		    	for(Food f: consumables) {
		    		f.move(SCROLLSPEED, frameWidth, frameHeight);
		    		if(mainBird.collidesWith(f)) {
		    			score += f.getPointValue();
		    			f.reset(frameWidth, frameHeight);
		    		}
		    	}
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
