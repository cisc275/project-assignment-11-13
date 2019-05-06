public class EdibleFood extends Food {
	
	private static final int EDIBLEFOOD_XSIZE = 40;
	private static final int EDIBLEFOOD_YSIZE = 80;
	private static final int EDIBLEFOOD_POINTVALUE = 5;

	public EdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, EDIBLEFOOD_POINTVALUE);
		xSize = EDIBLEFOOD_XSIZE;
		ySize = EDIBLEFOOD_YSIZE;
		image = this.createImage("ProjectPics/fish.png");
	}

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return super.isCollected;
    }

}
