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
	
    public Minimap(String mapFile, String mapPathFile, int frameWidth, int frameHeight){
    	this.mapFile = mapFile;
    	this.mapPathFile = mapPathFile;
    	map = this.createImage(mapFile);
    	mapPath = this.createImage(mapPathFile);
    	progress = 1;
    	xPos = frameWidth - mapWidth;
    	yPos = 0;
    }
    
    public void updateProgress(double percentDone) {
    	progress = (int) (percentDone * pathHeight);
    	//Prevent progress form being 0 to avoid error from creating subimage of zero height
    	if (progress==0)
    		progress++;
    }
    
    public int getProgress() {
    	return progress;
    }
    
    public int getXPos() {
    	return xPos;
    }
    
    public int getMapYPos() {
    	return yPos;
    }
    
    public int getPathYPos() {
    	return yPos + pathOffset;
    }
    
    public int getPathHeight() {
    	return pathHeight;
    }
    
    public int getMapHeight() {
    	return mapHeight;
    }
    
    public BufferedImage getCurrentMapPath() {
    	return mapPath.getSubimage(0, pathHeight-progress, pathWidth, progress);
    }
}
