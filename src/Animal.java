public class Animal extends GameObject {
    String picFile;
    String name;
    
    /** 
     * Default constructor used in the DropBird Class for implementation of GameObject whilst maintaining it's traits 
     */
    Animal(){}

    /** 
     * Constructor for Animal defining the obeject's name for ease of recognition and the picFile for image drawing
     *
     * @param picFile
     * @param name
     */
    Animal(String picFile, String name){
        super(picFile);
        this.name = name;
    }

    /**
     * primary function for movement of Animal Object
     * 
     * @return boolean
     */
    public boolean move(){
        return true;
    }
}
