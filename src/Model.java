public class Model {
    GameState gameState;
    private int frameWidth;
    private int frameHeight;
    private PlayableBird mainBird;
    private Foe foe;
    private Scoreboard scoreboard;
    
    //These two vars are irrelevant now, right?
    //int imgWidth;
    //int imgHeight;
    
    public Model(int frameWidth, int frameHeight, PlayableBird bird, Foe foe, Scoreboard scoreboard) {//, int imgWidth, int imgHeight){
    	this.gameState = gameState;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.mainBird = bird;
        this.foe = foe;
        this.scoreboard = scoreboard;
        //this.imgWidth = imgWidth;
        //this.imgHeight = imgHeight;
    }


    public void update(){
	    	mainBird.move(frameHeight);
	    	foe.move(frameWidth, frameHeight);
	    	if(mainBird.collidesWith(foe)) {
	    		foe.reset(frameWidth, frameHeight);
	    		scoreboard.foodGameScore -= 1;
	    	}
    }
}
