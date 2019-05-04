import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ViewNestGame extends View {

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    String name;

    //Need to not hard code this stuff!
    BufferedImage dropBirdImg;
    BufferedImage stickOneImg;
    BufferedImage stickTwoImg;
    BufferedImage stickThreeImg;
    String dropBirdFile = "ProjectPics/BirdStick.jpg";
    String stickFile = "ProjectPics/Stick.png";

    private int xloc;
    private int yloc;
    DropBird dropBird;


    public static void main(String[] args) {
        Controller control = new Controller();
        control.start();
    }

    public int getWidth() {
        return frameWidth;
    }

    public int getHeight() {
        return frameHeight;
    }

    public ViewNestGame(){
        frame.getContentPane().add(this);
        frame.setBackground(Color.cyan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setFocusable(true);



    }

    public void addObjects(DropBird dropBird, Stick stickOne, Stick stickTwo, Stick stickThree) {
        this.dropBird = dropBird;
        this.dropBird.stickOne = stickOne;
        this.dropBird.stickTwo = stickTwo;
        this.dropBird.stickThree = stickThree;
        stickOneImg = createImage(this.dropBird.stickOne.picFile);
        stickTwoImg = createImage(this.dropBird.stickTwo.picFile);
        stickThreeImg = createImage(this.dropBird.stickTwo.picFile);
        dropBirdImg = createImage(this.dropBird.picFile);
    }

    public void update(int x, int y, DropBird dropBird, Stick stickOne, Stick stickTwo, Stick stickThree){
        this.dropBird = dropBird;
        this.dropBird.stickTwo = stickTwo;
        this.dropBird.stickOne = stickOne;
        this.dropBird.stickThree = stickThree;
        this.xloc = x;
        this.yloc = y;
        //this.picFile = bird.picFile;
        //this.name = bird.name;

        frame.repaint();
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage createImage(String path) {
        BufferedImage bufferedImage;
        try {
            System.out.println();
            bufferedImage = ImageIO.read(new File(path)); //Utilizes the path name
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void paint(Graphics g){
        g.drawImage(dropBirdImg, dropBird.getxPos(), dropBird.getyPos(), Color.cyan, this);
        switch(dropBird.droppedSticks) {
            case 1:
                g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
                break;
            case 2:
                g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
                g.drawImage(stickTwoImg, dropBird.stickTwo.getxPos(), dropBird.stickTwo.getyPos(), Color.cyan, this);
                break;
            case 3:
                g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
                g.drawImage(stickTwoImg, dropBird.stickTwo.getxPos(), dropBird.stickTwo.getyPos(), Color.cyan, this);
                g.drawImage(stickOneImg, dropBird.stickThree.getxPos(), dropBird.stickThree.getyPos(), Color.cyan, this);
                break;
        }

        System.out.println(dropBird.getxPos());
        if(dropBird.droppedSticks == 0) {
            g.drawImage(stickOneImg, dropBird.stickOne.getxPos(), dropBird.stickOne.getyPos(), Color.cyan, this);
            // g.drawImage(stickTwoImg, stickTwo.getxPos(), stickTwo.getyPos(), Color.cyan, this);
            // g.drawImage(stickOneImg, stickThree.getxPos(), stickThree.getyPos(), Color.cyan, this);
        }
    }
}
