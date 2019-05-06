import java.awt.Color;
import java.util.ArrayList;

public class ModelNestGame {
    GameState gs;
    private int frameWidth;
    private int frameHeight;
    DropBird dropBird;
    private int time;
    private int score;
    //ArrayList<Stick> sticks;
    int nestTop;
    int topStick_xPos;
	
	public ModelNestGame(int frameWidth, int frameHeight, GameState gs) {//, PlayableBird bird) {//, Foe foe) {//, int imgWidth, int imgHeight){
    	this.gs = gs;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        dropBird = new DropBird("ProjectPics/BirdStick.jpg", "drop");
        //sticks = new ArrayList<>();
        //sticks.add
        time = 25;
//        mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
//        this.foe = new Foe("ProjectPics/Eagle.png", "Eagle", frameWidth, frameHeight);
//        time = 500;
//        consumables = new ArrayList<Food>();
//        createConsumables();
    }
	
	public ArrayList<GameObject> getObjects(){
		ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(dropBird);
		switch(dropBird.droppedSticks) {
        case 1:
        	objects.add(dropBird.stickOne);
            //g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
            break;
        case 2:
        	objects.add(dropBird.stickOne);
        	objects.add(dropBird.stickTwo);
//            g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
//            g.drawImage(stickTwoImg, dropBird.stickTwo.getxPos(), dropBird.stickTwo.getyPos(), Color.cyan, this);
            break;
        case 3:
        	objects.add(dropBird.stickOne);
        	objects.add(dropBird.stickTwo);
        	objects.add(dropBird.stickThree);
//            g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
//            g.drawImage(stickTwoImg, dropBird.stickTwo.getxPos(), dropBird.stickTwo.getyPos(), Color.cyan, this);
//            g.drawImage(stickOneImg, dropBird.stickThree.getxPos(), dropBird.stickThree.getyPos(), Color.cyan, this);
            break;
    }
		
        return objects;
	}
	
	public void update(GameState gs) {
		this.gs = gs;
		dropBird.move(frameWidth, frameHeight);
//		nestTop = dropBird.topStick.yPos;
//		topStick_xPos = dropBird.topStick.xPos;
	}
	
    public DropBird getDropBird() {
    	return dropBird;
    }
	
    public GameState getState() {
    	return gs;
    }
	

}
