import java.util.Random;

public class EdibleFood extends Food {
	
	private static final int EDIBLEFOOD_XSIZE = 110;
	private static final int EDIBLEFOOD_YSIZE = 37;
	private static final int EDIBLEFOOD_POINTVALUE = 5;
	private static final int GOLDEN_CHANCE = 10; // Chance is 1 over this constant. Ex. if 10, there is a 1/10 chance of a fish being golden
	
	Random rand = new Random();
	boolean golden;

	public EdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, EDIBLEFOOD_POINTVALUE);
		xSize = EDIBLEFOOD_XSIZE;
		ySize = EDIBLEFOOD_YSIZE;
		if(rand.nextInt() % GOLDEN_CHANCE == 0) {
			golden = true;
		}
		else {
			golden = false;
		}
		image = this.createImage("ProjectPics/fish.png");
	}

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return super.isCollected;
    }

}
