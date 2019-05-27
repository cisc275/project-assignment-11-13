public class NonEdibleFood extends Food {

	private static final int NONEDIBLEFOOD_XSIZE = 80;
	private static final int NONEDIBLEFOOD_YSIZE = 40;
	private static final int NONEDIBLEFOOD_POINTVALUE = -3;
	
	public NonEdibleFood(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight, NONEDIBLEFOOD_POINTVALUE);
		xSize = NONEDIBLEFOOD_XSIZE;
		ySize = NONEDIBLEFOOD_YSIZE;
		image = this.createImage("ProjectPics/trash.png");
	}

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return super.isCollected;
    }

}
