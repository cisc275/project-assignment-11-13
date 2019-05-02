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
	public void move(Stick topStick){
		if(isFalling == false) {
			return;
		}
		yPos += speedFalling;
		if(topStick == null && yPos <= frameHeight - ySize) {
			isFalling = false;
			isTopStick = true;
		}
		else if(yPos >= topStick.yPos) {
			if (this.collided(topStick)) {
				isFalling = false;
				isTopStick = true;
			}
		}
		return;
	}

	/*
	 * The collided method compares the stick this another stick
	 * and uses two if statements to check for collision.
	 */
	public boolean collided(Stick topStick){
		if(xPos <= topStick.xPos || xPos >= topStick.xPos) {
			if(yPos >= topStick.yPos ) {
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
		if(isTopStick) {
			return true;
		}else {
			return false;
		}
	}

}