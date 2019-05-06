public class NonEdibleFood extends Food {

	// constants defining size of non-edible food and point value
	private static final int NONEDIBLEFOOD_XSIZE = 80;
	private static final int NONEDIBLEFOOD_YSIZE = 40;
	private static final int NONEDIBLEFOOD_POINTVALUE = -5;
	
 /*   public NonEdibleFood(int pointValue, int xIncr, int yIncr){
        super(pointValue, xIncr, yIncr);
    } */ // Old Constructor, seems unnecessary for it to be told what to put in
	
	public NonEdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, NONEDIBLEFOOD_POINTVALUE);
		xSize = NONEDIBLEFOOD_XSIZE;
		ySize = NONEDIBLEFOOD_YSIZE;
	}

}
