public class Food extends GameObject {
    int size;
    int pointValue;
    int xIncr;
    int yIncr;
    boolean isCollected;

    public Food(int pointValue, int xIncr, int yIncr){}

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return isCollected;
    }
}
