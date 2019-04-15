public class Animal extends GameObject {
    String picFile;
    String name;

    Animal(){}

    Animal(String picFile, String name){
        super(picFile);
        this.name = name;
    }


    public boolean move(){
        return true;
    }
}
