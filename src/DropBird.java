public class DropBird extends GameObject {
    boolean isHoldingStick;

    public DropBird(){}

    public boolean dropStick(){
        return !isHoldingStick;
    }
}
