import java.awt.image.BufferedImage;

public class Minimap extends EnvironmentObject {

	final int mapWidth = 229;
	final int mapHeight = 368;
	final int pathWidth = 229;
	final int pathHeight = 270;
	final int pathOffset = 56;
	String mapFile;
	String mapPathFile;
	BufferedImage map;
	BufferedImage mapPath;
	int progress;
	int xPos;
	int yPos;
	
    /**
     * Creates a minimap of the PlayableBird's travel as migration is happening.
     * 
     * @param mapFile
     * @param mapPathFile
     * @param frameWidth
     * @param frameHeight
     */
    public Minimap(String mapFile, String mapPathFile, int frameWidth, int frameHeight){
    	this.mapFile = mapFile;
    	this.mapPathFile = mapPathFile;
    	map = this.createImage(mapFile);
    	mapPath = this.createImage(mapPathFile);
    	progress = 1;
    	xPos = frameWidth - mapWidth;
    	yPos = 0;
    }
    
    /**
     * Updates how much of the game has been completed as a percent
     * 
     * @param percentDone
     */
    public void updateProgress(double percentDone) {
    	progress = (int) (percentDone * pathHeight);
    	//Prevent progress form being 0 to avoid error from creating subimage of zero height
    	if (progress==0)
    		progress++;
    }
    
    /** 
     * @return Progress of the game
     */
    public int getProgress() {
    	return progress;
    }
    
    /**
     * @return X position
     */
    public int getXPos() {
    	return xPos;
    }
    
    /**
     * @return Y position
     */
    public int getMapYPos() {
    	return yPos;
    }
    
    /**
     * @return YPos and pathOffset added together
     */
    public int getPathYPos() {
    	return yPos + pathOffset;
    }
    
    /**
     * @return Height of the path on the map
     */
    public int getPathHeight() {
    	return pathHeight;
    }
    
    /**
     * @return Height of the map
     */
    public int getMapHeight() {
    	return mapHeight;
    }
    
    /**
     * @return visual path on the minimap
     */
    public BufferedImage getCurrentMapPath() {
    	return mapPath.getSubimage(0, pathHeight-progress, pathWidth, progress);
    }
}
