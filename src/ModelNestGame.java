
    
class ModelNestGame extends Model{
	
    private int frameWidth;
    private int frameHeight;
    private DropBird  dropBird;
    int nestTop;
    int topStick_xPos;
    
    // was for nestGame testing
    public ModelNestGame (int frameWidth, int frameHeight, DropBird dropBird) {
    	  this.frameWidth = frameWidth;
          this.frameHeight = frameHeight;
          this.dropBird = dropBird;
    }
    


    public void update(){
    		dropBird.move(frameWidth, frameHeight);
    		nestTop = dropBird.topStick.yPos;
    		topStick_xPos = dropBird.topStick.xPos;
    }
}