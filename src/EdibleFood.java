public class EdibleFood extends Food {

	// constants defining size of edible food and point value
	private static final int EDIBLEFOOD_XSIZE = 40;
	private static final int EDIBLEFOOD_YSIZE = 80;
	private static final int EDIBLEFOOD_POINTVALUE = 5;
	
 /*   public EdibleFood(int pointValue, int xIncr, int yIncr){
        super(pointValue, xIncr, yIncr);
    } */ // Old Constructor, seems unnecessary for it to be told what to put in
	
	public EdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, EDIBLEFOOD_POINTVALUE);
		xSize = EDIBLEFOOD_XSIZE;
		ySize = EDIBLEFOOD_YSIZE;
	}

}
