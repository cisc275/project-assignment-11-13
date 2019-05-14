public class Stick extends GameObject {
	int speedFalling = 3;
	boolean isFalling = false;
	boolean isTopStick = false;
	int frameHeight;



	public Stick(int xSize, int ySize, int frameHeight){
		picFile = "ProjectPics/Stick.png";
		this.xSize = xSize;
		this.ySize = ySize;
		this.frameHeight = frameHeight;

	}

	/*
	 * DropBird releases stick. xPos is set, isFalling becomes true
	 */
	public void release(int xPos, int yPos) {
		System.out.println("accessed");
		isFalling = true;
		this.xPos = xPos;
		this.yPos = yPos;
		return;
	}

	/*
	 * The stick is incrementing downward. 
	 * Increments if it is supposed to be falling
	 * Checks for collision, and registers if it is 
	 * at the top of the nest
	 */
	public void move(int topStickXPos, int topStickYPos){
		if(isFalling == false) {
			return;
		}
		yPos += speedFalling;
		if( yPos >= frameHeight - ySize) {
			System.out.println(yPos + " " + frameHeight+ " " + ySize);
			isFalling = false;
			isTopStick = true;
		}
		/*
		else if(yPos >= topStickYPos) {
			if (this.collided(topStickXPos, topStickYPos)) {
				isFalling = false;
				isTopStick = true;
			}
		}
		*/
		return;
	}

	/*
	 * The collided method compares the stick this another stick
	 * and uses two if statements to check for collision.
	 */
	public boolean collided( int topXPos, int topYPos){
		if(xPos <= topXPos || xPos >= topYPos) {
			if(yPos >= topYPos ) {
				return true;
			}
		}
			return false;
	}

	/*
	 * Checks if the stick is at the top of the pile. If it is, return true, otherwise 
	 * returns false
	 */
	public boolean checkOnPile(){
		return isTopStick;
	}

}