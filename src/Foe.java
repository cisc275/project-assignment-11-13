public class Foe extends Animal {
    int collisionPenalty;
    int speed;

    public Foe(String picFile, String name){
        super(picFile, name);
    }

    public boolean move(){
        return true;
    }

    public boolean isCollided(){
        return true;
    }
}
