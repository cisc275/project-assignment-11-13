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
    JFrame frame = new JFrame();
    BufferedImage img;
    final static int frameWidth = 600;
    final static int frameHeight = 400;
    String picFile = "ProjectPics/Osprey.jpg";
    String name;

    private int xloc;
    private int yloc;
    
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
        frame.setBackground(Color.gray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        
        frame.setFocusable(true);

        PlayableBird bird = new PlayableBird(picFile, name);
        img = createImage(picFile);
    }

    public void update(int x, int y, PlayableBird bird){
        this.xloc = x;
        this.yloc = y;
        //this.picFile = bird.picFile;
        //this.name = bird.name;

        frame.repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage createImage(String path) {
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
        g.drawImage(img, xloc, yloc, Color.gray, this);
    }
}
