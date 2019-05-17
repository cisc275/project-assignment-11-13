import java.util.ArrayList;

class ModelNestGame{
	GameState gs;
    private int frameWidth;
    private int frameHeight;
    private DropBird  dropBird;
    int nestTop;
    int sticksLeft = 10;
    int score = 1;
    
    /*
     * Constructor gives the model the screen dimesnions, gamestate and creates the dropbird
     */
    public ModelNestGame (int frameWidth, int frameHeight, GameState gs) {
    	this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.gs = gs;
        dropBird = new DropBird("ProjectPics/BirdStick.PNG", "stickbird", frameHeight);
    }
    

    /*
     * update resets the game state, and calls the move method of the dropBird. The stick objects exist in DropBird, 
     * so their move method is called in the dropbrid move method
     */
    public void update(GameState gs){
    	this.gs = gs;
    	dropBird.move(frameWidth, frameHeight);
    	for(Stick s : dropBird.stickList) {
    		if(!s.isFalling) {
    			if(score < (1 +  (frameHeight - s.yPos)/ s.ySize)){
    				score = (1 + (frameHeight - s.yPos)/ s.ySize);
    			}
    		}
    	}
    	dropBird.score = score;
    	if(dropBird.stickList.size() >= 10) {
    		this.gs = GameState.NESTQUIZ;
    	}
    }
    
    /*
     * Places the dropbird into an arrayList and returns that list. This is done to 
     * fit the modular architecture implemented
     */
    public ArrayList<GameObject> getObjects(){
        ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(dropBird);
    	return objects;
    }
  
    /*
     * getter method for dropbird object
     */
    public DropBird getDropBird() {
    	return dropBird;
    }
    
    /* 
     * getter method for gamestate
     */
    public GameState getState() {
    	return gs;
    }
}