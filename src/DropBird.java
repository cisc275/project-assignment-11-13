import java.util.LinkedList;

public class DropBird extends Animal {
    int xIncr = 8;
    boolean xDir = true;		//false = neg, true = pos
    int droppedSticks = 0;
    Stick topStick;
    LinkedList<Stick> stickList = new LinkedList<Stick>();
    int frameHeight;


    public DropBird(String picFile, String name, int frameHeight){
    	this.name = name;
        this.picFile = picFile;
        xPos = 10;
        yPos = 10;
    }

    /*
     * DropStick method increases the count of dropped sticks, 
     * increases the xIncr speed, adds a new stick to the Linkedlist, 
     * and then calls its release method
     */
    public void dropStick(){
        droppedSticks +=1;
        xIncr += 2;
        stickList.add(new Stick(100, 100, frameHeight));
        stickList.getLast().release(xPos, yPos);
        return ;

    }
    
    
    /*
     * the move method uses an iterator for loop to call the move method for each stick
     * then it moves the dropBrid in the x direction, reversing direction if it reaches a 
     * boundary
     */
    public void move(int frameWidth, int frameHeight) {
    	for(Stick s : stickList) {
    		s.move(topStick);
    		if (s.checkOnPile() == true) {
    			topStick = s;
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