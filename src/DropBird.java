public class DropBird extends Animal {
	final int xIncr = 8;
    boolean isHoldingStick = true;
    Stick stickOne;
    Stick stickTwo;
    Stick stickThree;
    int droppedSticks = 0;

    public DropBird(String picFile, String name){
    	super(picFile, name);
    }

    public void dropStick(){
        if(droppedSticks == 0) {
        	stickOne = new Stick();
        	stickOne.release(xPos);
        	return;
        }else if(droppedSticks == 1 ) {
        	stickTwo.release(xPos);
        	return;
        }else if (droppedSticks == 2) {
        	stickThree.release(xPos);
        	return;
        }else {
        	isHoldingStick = false;
        	return ;
        }
    }
}
