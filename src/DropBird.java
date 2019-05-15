import java.util.LinkedList;

public class DropBird extends Animal {
    int xIncr = 8;
    boolean xDir = true;		//false = neg, true = pos
    int droppedSticks = 0;
    Stick topStick;
    LinkedList<Stick> stickList = new LinkedList<Stick>();
    int frameHeight;
    boolean nestStarted = false;
    


    public DropBird(String picFile, String name, int frameHeight){
    	this.name = name;
        this.picFile = picFile;
        this.frameHeight = frameHeight;
        System.out.println("The frame height is " + frameHeight);
        xPos = 10;
        yPos = 10;
        xSize = 400;
        this.image = this.createImage(picFile);
    }

    /*
     * DropStick method increases the count of dropped sticks, 
     * increases the xIncr speed, adds a new stick to the Linkedlist, 
     * and then calls its release method
     */
    public void dropStick(){
    	if(droppedSticks > 0) {								//check if any sticks have been dropped
    		if(stickList.getLast().isFalling == true) {		//prevent a drop until the stick has reached rest
    			System.out.println("No can do brochaco");
    			return;
    		}
    	}
        xIncr += 2;
        stickList.add(new Stick(100, 70, frameHeight));
        stickList.getLast().release(xPos, yPos, stickList.getLast().xPos, droppedSticks);
        droppedSticks +=1;
        topStick = stickList.getLast();
        return ;

    }
    
    
    /*
     * the move method uses an iterator for loop to call the move method for each stick
     * then it moves the dropBrid in the x direction, reversing direction if it reaches a 
     * boundary
     */
    public void move(int frameWidth, int frameHeight) {
    	if(droppedSticks > 0) {
	    	for(Stick s : stickList) {
	    		s.move(topStick.getxPos(), topStick.getyPos());
	    	}
    	}

        //checks the location of dropBird, then moves it left or right
        if( xDir == true) {			//xDir is positive
            if(xPos < (frameWidth- xSize)) {
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