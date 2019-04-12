public class NonEdibleFood extends Food {

    public NonEdibleFood(int pointValue, int xIncr, int yIncr){
        super(pointValue, xIncr, yIncr);
    }

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return super.isCollected;
    }

}
