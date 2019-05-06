import java.util.Random;

public class Foe extends Animal {
    int collisionPenalty;
    int speed;
    Random rand = new Random();

    public Foe(String picFile, String name, int frameWidth, int frameHeight){
        super(picFile, name);
        this.picFile = picFile;
        this.image = this.createImage(picFile);
    	//Hard coding in the image size for now:
        xSize = 180;
        ySize = 106;
        
        speed = Math.abs(rand.nextInt())%5+15;
    	xPos = frameWidth;
    	yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize);
    }

    public boolean move(int frameWidth, int frameHeight){
    	xPos -= speed;
    	if (xPos < -xSize) {
    		reset(frameWidth, frameHeight);
    	}
        return true;
    }
    
    public void reset(int frameWidth, int frameHeight) {
    	xPos += frameWidth + 2*xSize;
		yPos = Math.abs(rand.nextInt()) % ((frameHeight/2)-ySize);
		speed = Math.abs(rand.nextInt())%5+15;
    }

    public boolean isCollided(){
        return true;
    }
}
