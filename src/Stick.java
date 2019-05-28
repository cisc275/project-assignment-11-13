import java.util.LinkedList;

/**
 * The stick class extends the gameObject class, and is used to represent sticks 
 * in the nestGame
 */
public class Stick extends GameObject {
	int speedFalling = 20;
	boolean isFalling = false;
	boolean topStickXPos;
	int droppedSticks = 0;
	int frameHeight;
	final int bufferConstant = 50;



	/**
	 * The stick constructor defines the file to use as the picture, sets the size of
	 * the object, provides the frameHieght, creates the BufferedImage
	 * 
	 * @param xSize The x dimension of the stick
	 * @param ySize The y dimension of the stick
	 * @param frameHeight the y boundary of the nest game. Serves as the ground of the game
	 */
	public Stick(int xSize, int ySize, int frameHeight){
		picFile = "ProjectPics/Stick.png";
		this.xSize = xSize;
		this.ySize = ySize;
		this.frameHeight = frameHeight;
		this.image = this.createImage(picFile);		
	}

	/**
	 * DropBird releases stick. xPos is set, isFalling becomes true
	 * 
	 * @param xPos the x position of the stick when it is  released
	 * @param yPos the y position of the stick when it is released
	 * @param droppedSticks an int representing the number of sticks the dropBird has released 
	 */
	public void release(int xPos, int yPos, int topStackXPos, int droppedSticks) {
		isFalling = true;
		this.xPos = xPos;
		this.yPos = yPos;
		this.droppedSticks = droppedSticks;
		return;
	}

	/**
	 * In this move method, the stick is incrementing downward. 
	 * Increments if it is supposed to be falling
	 * Checks for collision, and registers if it is 
	 * at the top of the nest
	 * 
	 * @param sticklisk a LinkedList of every stick that has been dropped
	 * @return void
	 */
	public void move(LinkedList<Stick> stickList){
		if(isFalling == false) {
			return;
		}
		yPos += speedFalling;
		if( yPos >= frameHeight - ySize- bufferConstant) {
			System.out.println(ySize);
			isFalling = false;
		}
		for(GameObject o : stickList) {
			if( !this.equals(o)) {
				if(this.collidesWith(o)) {
					isFalling = false;
				}
			}
		}
		return;
		
	}
	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

}