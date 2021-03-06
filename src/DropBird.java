import java.util.LinkedList;

/**
 * An extension of gameObject, the dropbird is the central object of the nest game
 */
public class DropBird extends Animal {
    int xIncr = 8;
    boolean xDir = true;		//false = neg, true = pos
    int droppedSticks = 0;
    Stick topStick;
    LinkedList<Stick> stickList = new LinkedList<Stick>();
    int frameHeight;
    boolean nestStarted = false;
    int score;
    int sticksAvalible;
    private final int STICKWIDTH = 200;
    private final int STICKHEIGHT = 80;
    private final int MAXSTICKS = 10;
    private final int DROPBIRDSIZE = 400;
    private final int STARTX = 10;
    private final int STARTY = 10;
    

	/**
	 * The constructor sets the name defines the picfile, frameHeight
	 * starting x and y position, and creates the bufferedImage
	 * 
	 * @param picFile
	 * @param name
	 * @param frameHeight
	 */
    public DropBird(String picFile, String name, int frameHeight){
    	this.name = name;
        this.picFile = picFile;
        this.frameHeight = frameHeight;
        xPos = STARTX;
        yPos = STARTY;
        this.image = this.createImage(picFile);
        score = 0;
    }

    /**
     * DropStick method increases the count of dropped sticks, 
     * increases the xIncr speed, adds a new stick to the Linkedlist, 
     * and then calls its release method
     * 
     * 
     */
    public void dropStick(){
    	if(droppedSticks > 0) {								//check if any sticks have been dropped
    		if(stickList.getLast().isFalling == true) {		//prevent a drop until the stick has reached rest
    			return;
    		}
    	}
    	if(stickList.size() == MAXSTICKS) {
    		return;
    	}
        xIncr += 6;
        stickList.add(new Stick(STICKWIDTH, STICKHEIGHT, frameHeight));
        stickList.getLast().release(xPos, yPos, stickList.getLast().xPos, droppedSticks);
        droppedSticks +=1;
        topStick = stickList.getLast();
        return ;

    }
    
    
    /**
     * the move method uses an iterator for loop to call the move method for each stick
     * then it moves the dropBrid in the x direction, reversing direction if it reaches a 
     * boundary
     * 
     * @param frameWidth the x axis distnace of the screen
     * @param frameHeight the y axis distance of the screen
     * @param sticksAvalible the number of sticks the user still can drop
     * @return void
     */
    public void move(int frameWidth, int frameHeight, int sticksAvalible) {
    	this.sticksAvalible = sticksAvalible;
    	if(droppedSticks > 0) {
	    	for(Stick s : stickList) {
	    		s.move(stickList);
	    	}
    	}

        //checks the location of dropBird, then moves it left or right
        if( xDir == true) {			//xDir is positive
            if(xPos < (frameWidth- DROPBIRDSIZE)) {
                xPos += xIncr;
            }else {
                xDir = false;
            }
        }else {						//xDir is Neg
            if(xPos > 0) {
                xPos -= xIncr;
            }else {
                xDir = true;
            }
        }
        return;
    }
}
