public class Stick extends GameObject {
	int speedFalling = 20;
	boolean isFalling = false;
	boolean topStickXPos;
	int droppedSticks = 0;
	int frameHeight;



	public Stick(int xSize, int ySize, int frameHeight){
		picFile = "ProjectPics/Stick.png";
		this.xSize = xSize;
		this.ySize = ySize;
		this.frameHeight = frameHeight;
		this.image = this.createImage(picFile);		
	}

	/*
	 * DropBird releases stick. xPos is set, isFalling becomes true
	 */
	public void release(int xPos, int yPos, int topStackXPos, int droppedSticks) {
		isFalling = true;
		this.xPos = xPos;
		this.yPos = yPos;
		this.topStickXPos = topStickXPos;
		this.droppedSticks = droppedSticks;
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
		if( yPos >= frameHeight - ySize - (ySize* droppedSticks)) {
			System.out.println(yPos + " " + frameHeight+ " " + ySize + " " + droppedSticks);
			isFalling = false;
		}
		
	
		
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


}