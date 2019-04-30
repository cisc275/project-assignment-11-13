import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View extends JPanel {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    final static int frameWidth = (int) screenSize.getWidth();
    final static int frameHeight = (int) screenSize.getHeight();
    String name;

    //Need to not hard code this stuff!
    BufferedImage birdImg;
    BufferedImage foeImg;
    String birdPicFile = "ProjectPics/Osprey.png";
    String foePicFile = "ProjectPics/Eagle.png";
    
    private int xloc;
    private int yloc;
    PlayableBird mainBird;
    Foe foe;
    Scoreboard scoreboard;
    
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
    
    public View(){
    	frame.getContentPane().add(this);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setFocusable(true);



    }

    public void addObjects(PlayableBird bird, Foe foe, Scoreboard scoreboard) {
        this.mainBird = bird;
        this.foe = foe;
        this.scoreboard = scoreboard;
        foeImg = createImage(this.foe.picFile);
        birdImg = createImage(this.mainBird.picFile);
    }
    
    public void update(int x, int y, PlayableBird bird, Foe foe){
        this.mainBird = bird;
        this.foe = foe;
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
        g.drawImage(birdImg, mainBird.getxPos(), mainBird.getyPos(), Color.cyan, this);
        g.drawImage(foeImg, foe.getxPos(), foe.getyPos(), Color.cyan, this);
        g.drawString(Integer.toString(scoreboard.foodGameScore), 30, 30);
    }
}
