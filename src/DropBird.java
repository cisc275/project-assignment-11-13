public class DropBird extends Animal {
    final int xIncr = 8;
    boolean xDir = true;		//false = neg, true = pos
    boolean isHoldingStick = true;
    int droppedSticks = 0;
    boolean spacePressed = false;
    int towerHeight;

    Stick stickOne;
    Stick stickTwo;
    Stick stickThree;

    public DropBird(String picFile, String name){
        super(picFile, name);
        this.picFile = picFile;
        xPos = 10;
        yPos = 10;
    }

    public void dropStick(){
        droppedSticks +=1;
        switch(droppedSticks) {
            case 1:

                stickOne.release(xPos, yPos);
                break;
            case 2:
                stickTwo.release(xPos, yPos);
                break;
            case 3:
                stickThree.release(xPos, yPos);
                break;
        }
        return ;

    }

    public void move(int frameWidth, int frameHeight) {

        //checks the location of dropBird, then moves it left or right
        if( xDir == true) {			//xDir is positive
            //System.out.println(xSize);
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
