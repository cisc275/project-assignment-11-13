import java.util.Random;

public class Foe extends Animal {
    int collisionPenalty;
    int speed;
    Random rand = new Random();

    public Foe(String picFile, String name, int frameWidth, int frameHeight){
        super(picFile, name);
    	//Hard coding in the image size for now:
        xSize = 180;
        ySize = 106;
        
        speed = Math.abs(rand.nextInt())%5+15;
    	xPos = frameWidth;
    	yPos = Math.abs(rand.nextInt()) % (frameHeight-ySize);
    }

    public boolean move(int frameWidth, int frameHeight){
    	xPos -= speed;
    	if (xPos < -xSize) {
    		xPos += frameWidth + 2*xSize;
    		yPos = Math.abs(rand.nextInt()) % (frameHeight-ySize);
    		speed = Math.abs(rand.nextInt())%5+15;
    	}
        return true;
    }

    public boolean isCollided(){
        return true;
    }
}
