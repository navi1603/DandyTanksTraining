import javax.swing.*;
import java.awt.*;

public class Main extends JPanel
{
    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;
    //1 - Up, 2 - Down, 3 - Left, 4 - Right
    int direction = 1;

    int bulletX = 320;
    int bulletY = 320;

    //Coordinates
    int x = 256;
    int y = 256;

    void move (int direction) throws Exception
    {
        this.direction = direction;
        if (direction == 1)
        {
            y--;
        }else if (direction == 2)
        {
            y++;
        } else if (direction == 3)
        {
            x--;
        } else if (direction == 4)
        {
            x++;
        }
        Thread.sleep(33);
        repaint();
    }

    void runTheGame () throws Exception
    {
        while (y != 0)
        {
            move(1);

        }
    }
/*
    void moveUp() throws Exception
    {
        while (y != 0){
            direction = 1;
            y--;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveDown() throws Exception
    {
        while (y != BF_HEIGHT - 64){
            direction = 2;
            y++;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveLeft() throws Exception
    {
        while (x != 0){
            direction = 3;
            x--;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveRight() throws Exception
    {
        while (x != BF_WIDTH - 64) {
            direction = 4;
            x++;
            Thread.sleep(33);
            repaint();
        }
    }*/

    public static void main(String[] args) throws Exception
    {
	// write your code here
       Main main = new Main();
       main.runTheGame();

    }

    Main(){
        JFrame frame = new JFrame("Dandy Tanks");
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 38));
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(0,0 );
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 64,64);

        g.setColor(Color.GREEN);
        if(direction == 1)
        {
            g.fillRect(x + 20, y, 24,34);
        }else if (direction == 2)
        {
            g.fillRect(x + 20, y + 30, 24,34);
        }else if (direction == 3)
        {
            g.fillRect(x, y + 20, 34,24);
        }else if (direction == 4)
        {
            g.fillRect(x + 30, y + 20, 34,24);
        }

        g.setColor(Color.YELLOW);
        g.fillRect(bulletX, bulletY, 14, 14);

    }
}
