public class NonEdibleFood extends Food {

	private static final int NONEDIBLEFOOD_XSIZE = 80;
	private static final int NONEDIBLEFOOD_YSIZE = 40;
	private static final int NONEDIBLEFOOD_POINTVALUE = -3;
	
	/**
	 * Constructor for NonEdibleFood; initializes all class attributes
	 * 
	 * @param frameWidth
	 * @param frameHeight
	 */
	public NonEdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, NONEDIBLEFOOD_POINTVALUE);
		xSize = NONEDIBLEFOOD_XSIZE;
		ySize = NONEDIBLEFOOD_YSIZE;
		image = this.createImage("ProjectPics/trash.png");
	}

	/**
	 * Move function for the non-edible food
	 * 
	 * @return boolean
	 */
    public boolean move(){
        return true;
    }
    
    /**
     * Provides a template function for whether or not the non-edible food has collided with the playable bird
     * 
     * @return boolean
     */
    public boolean collected(){
        return super.isCollected;
    }

}