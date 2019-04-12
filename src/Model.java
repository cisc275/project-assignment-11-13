public class Model {
    GameState gameState;
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;

    public Model(int frameWidth, int frameHeight, int imgWidth, int imgHeight){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    public void update(){}
}
