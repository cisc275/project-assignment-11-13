public class PlayableBird extends Animal {

    public PlayableBird(String picFile, String name){
        super(picFile, name);
    }

    public boolean move(){
        return true;
    }

    public boolean dive(){
        return true;
    }
}
