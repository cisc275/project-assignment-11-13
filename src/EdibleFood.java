public class EdibleFood extends Food {

    public EdibleFood(int pointValue, int xIncr, int yIncr){
        super(pointValue, xIncr, yIncr);
    }

    public boolean move(){
        return true;
    }

    public boolean collected(){
        return super.isCollected;
    }

}
