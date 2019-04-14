public class PlayableBird extends Animal {
	final int yIncr = 5; //Just made up this value for now
	boolean upPressed = false;
	boolean downPressed = false;

    public PlayableBird(String picFile, String name){
        super(picFile, name);
    }

    public boolean move(){
    	//This method should only deal with up and down, right? Because the bird doesn't move left/right, the background and everything else does. 
    	if (upPressed) {
    		yPos -= yIncr; 
    	}
    	if (downPressed) {
    		yPos += yIncr;
    	}
    	System.out.println("Bird's y-position: " + yPos); //For testing to see that value was updating
    	return true;
    }

    public boolean dive(){
        return true;
    }
}
