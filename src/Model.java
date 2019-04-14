public class Model {
    GameState gameState;
    int frameWidth;
    int frameHeight;
    
    //These two vars are irrelevant now, right?
    //int imgWidth;
    //int imgHeight;
    
    PlayableBird mainBird = new PlayableBird("Osprey.png", "Osprey");

    public Model(int frameWidth, int frameHeight) {//, int imgWidth, int imgHeight){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        //this.imgWidth = imgWidth;
        //this.imgHeight = imgHeight;
    }

    public void update(){
    	mainBird.move();
    }
}
