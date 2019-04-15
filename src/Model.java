public class Model {
    GameState gameState;
    private int frameWidth;
    private int frameHeight;
    private PlayableBird mainBird;
    
    //These two vars are irrelevant now, right?
    //int imgWidth;
    //int imgHeight;
    
    public Model(int frameWidth, int frameHeight, PlayableBird bird) {//, int imgWidth, int imgHeight){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.mainBird = bird;
        //this.imgWidth = imgWidth;
        //this.imgHeight = imgHeight;
    }

    public void update(){
    	mainBird.move();
    }
}
