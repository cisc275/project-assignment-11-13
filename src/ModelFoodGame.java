import java.util.ArrayList;

public class ModelFoodGame {
    GameState gs;
    private int frameWidth;
    private int frameHeight;
    private PlayableBird mainBird;
    private Foe foe;
    private int time;
    
    public ModelFoodGame(int frameWidth, int frameHeight, GameState gs) {//, PlayableBird bird) {//, Foe foe) {//, int imgWidth, int imgHeight){
    	this.gs = gs;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
        this.foe = new Foe("ProjectPics/Eagle.png", "Eagle", frameWidth, frameHeight);
        time = 500;
    }

    public ArrayList<GameObject> getObjects(){
    	ArrayList<GameObject> objects = new ArrayList<>();
        objects.add(mainBird);
        objects.add(foe);
        return objects;
    }
    
    public void update(GameState gs){
    	this.gs = gs;
    	mainBird.move(frameHeight);
    	foe.move(frameWidth, frameHeight);
    	time--;
    	if (time < 0) {
    		this.gs = GameState.NESTGAME;
    	}
    	//System.out.println("modelfood: " + this.gs);
    }
    
    public GameState getState() {
    	return gs;
    }
    
    public PlayableBird getPlayableBird() {
    	return mainBird;
    }
}
