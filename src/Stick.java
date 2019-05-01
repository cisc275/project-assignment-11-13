public class Stick extends GameObject {
	int speedFalling = 3;
	boolean isFalling = false;
	int topOfPile;



	public Stick(){
		super("ProjectPics/Stick.png");
		//Hard coding in the image size for now:
		//  xSize = 180;
		//ySize = 106;

	}

	/*
	 * DropBird releases stick. xPos is set, isFalling becomes true
	 */
	public void release(int xPos, int yPos) {
		isFalling = true;
		this.xPos = xPos;
		this.yPos = yPos;
		return;
	}

	/*
	 * The stick is incrementing downward until it reachs the bottom of the frame
	 */
	public void move(int pileHeight, int topStick_xPos){
		System.out.println(yPos);
		if(isFalling == false) {
			return;
		}
		yPos += speedFalling;
		if (yPos >= pileHeight) {
			isFalling = false;
		}
		return;
	}


	public boolean collided(){
		return true;
	}

	public boolean checkOnPile(){
		return true;
	}

}