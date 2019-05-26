import java.util.ArrayList;


/**
 * This method contains all of the logic for the nest game 
 */
class ModelNestGame{
	GameState gs;
    private int frameWidth;
    private int frameHeight;
    private DropBird  dropBird;
    int nestTop;
    int sticksAvalible = 10;
    private static int score = 1;
    int delayTimer = 10;
    
    /**
     * Constructor gives the model the screen dimensions, gamestate and creates the dropbird
     * 
     * @param frameWidth the x dimension of the computer screen,  defining bounds of game
     * @param frameHeight the y dimension of the computer screen, defining bounds of game
     */
    public ModelNestGame (int frameWidth, int frameHeight, GameState gs) {
    	this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.gs = gs;
        dropBird = new DropBird("ProjectPics/ClapperRail.png", "stickbird", frameHeight);
    }
    

    /**
     * update resets the game state, and calls the move method of the dropBird. The stick objects exist in DropBird, 
     * so their move method is called in the dropbird move method
     * 
     * @param gs the overall game state is updated
     * @return void
     */
    public void update(GameState gs){
    	this.gs = gs;
    	dropBird.move(frameWidth, frameHeight, sticksAvalible);
    	for(Stick s : dropBird.stickList) {
    		if(!s.isFalling) {
    			if(score <= (  (frameHeight - s.yPos + 20) / s.ySize)){
    				score = ((frameHeight - s.yPos + 20) / s.ySize);
    			}
    		}
    	}
    	dropBird.score = score;
    	if(dropBird.stickList.size() >= sticksAvalible) {
    		if(dropBird.stickList.getLast().isFalling == false) {
    			if(delayTimer > 0) {
    				delayTimer--;
    			}else {
    				this.gs = GameState.SCOREBOARD;
    			}
    			
    		}
    	}
    	return;
    }
    
    /**
     * Places the dropbird into an arrayList and returns that list. This is done to 
     * fit the modular architecture implemented
     * 
     * @param none
     * @return objects an arrayList containing only the dropbird
     */
    public ArrayList<GameObject> getObjects(){
        ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(dropBird);
    	return objects;
    }
  
    /**
     * getter method for dropbird object
     * 
     * @param none
     * @return dropBird The model's current version of dropBird
     */
    public DropBird getDropBird() {
    	return dropBird;
    }
    
    /**
     * getter method for gamestate
     * 
     * @param none
     * @return gs The current version of gameState
     */
    public GameState getState() {
    	return gs;
    }
    
    /**
     * getter method for the score
     * 
     * @param none
     * @return score the game's current score. A measure of how many sticks have been stacked
     */
    public static int getScore() {
    	return score;
    }
}