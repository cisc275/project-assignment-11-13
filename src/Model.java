public interface Model {
	public void update();
}

/* public class Model {
    GameState gameState;
    private int frameWidth;
    private int frameHeight;
    private PlayableBird mainBird;
    private Foe foe;
    private DropBird dropBird;
    
    //These two vars are irrelevant now, right?
    //int imgWidth;
    //int imgHeight;
    
    public Model(int frameWidth, int frameHeight, PlayableBird bird, Foe foe) {//, int imgWidth, int imgHeight){
    	this.gameState = gameState;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.mainBird = bird;
        this.foe = foe;
        //this.imgWidth = imgWidth;
        //this.imgHeight = imgHeight;
    }
    
    public Model(int frameWidth, int frameHeight, DropBird dropBird) {
    	this.gameState = gameState;
    	this.frameWidth = frameWidth;
    	this.frameHeight = frameHeight;
    	this.dropBird = dropBird;
    	
    }


    public void update(){
	    	mainBird.move(frameHeight);
	    	foe.move(frameWidth, frameHeight);
    }
} */
