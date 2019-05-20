import java.util.ArrayList;

class ModelNestGame{
	GameState gs;
    private int frameWidth;
    private int frameHeight;
    private DropBird  dropBird;
    int nestTop;
    int sticksAvalible = 10;
    private static int score = 1;
    
    /*
     * Constructor gives the model the screen dimesnions, gamestate and creates the dropbird
     */
    public ModelNestGame (int frameWidth, int frameHeight, GameState gs) {
    	this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.gs = gs;
        dropBird = new DropBird("ProjectPics/ClapperRail.png", "stickbird", frameHeight);
    }
    

    /*
     * update resets the game state, and calls the move method of the dropBird. The stick objects exist in DropBird, 
     * so their move method is called in the dropbird move method
     */
    public void update(GameState gs){
    	System.out.println(gs);
    	this.gs = gs;
    	dropBird.move(frameWidth, frameHeight, sticksAvalible);
    	for(Stick s : dropBird.stickList) {
    		if(!s.isFalling) {
    			if(score < (  (frameHeight - s.yPos)/ s.ySize)){
    				score = ((frameHeight - s.yPos)/ s.ySize);
    			}
    		}
    	}
    	dropBird.score = score;
    	if(dropBird.stickList.size() >= sticksAvalible) {
    		if(dropBird.stickList.getLast().isFalling == false) {
    			this.gs = GameState.SCOREBOARD;
    		}
    	}
    	return;
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
    
    
    public void newSticks() {
    	sticksAvalible+=5;
	}
    public static int getScore() {
    	return score;
    }
}