import javax.swing.*;
import java.awt.*;

public class Main extends JPanel
{
    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    final  int OBJECT_SIZE = 64;

    final int UP = 1;
    final int DOWN = 2;
    final int LEFT = 3;
    final int RIGHT = 4;

    String [][] objects = {
            {"B", "B", "B", "G", "G", "W", "W", "G", "B"},
            {"B", "B", "B", "G", "G", "W", "W", "G", "B"},
            {"B", "B", "B", "G", "G", "W", "W", "G", "B"},
            {"B", "B", "B", "G", "G", "W", "W", "G", "B"},
            {"B", "G", "B", "G", "G", "G", "B", "G", "B"},
            {"W", "G", "G", "G", "G", "W", "W", "G", "B"},
            {"B", "B", "B", "G", "G", "W", "W", "G", "B"},
            {"W", "W", "B", "G", "G", "W", "B", "G", "B"},
            {"W", "W", "B", "G", "G", "W", "W", "G", "B"}

    };
    //1 - Up, 2 - Down, 3 - Left, 4 - Right
    int direction = 4;

    int bulletX = -100;
    int bulletY = -100;

    //Coordinates
    int tankX = 256;
    int tankY = 256;

    void move (int direction) throws Exception
    {
        this.direction = direction;
        if (direction == 1)
        {
            tankY--;
        }else if (direction == 2)
        {
            tankY++;
        } else if (direction == 3)
        {
            tankX--;
        } else if (direction == 4)
        {
            tankX++;
        }
        Thread.sleep(33);
        repaint();
    }

    void fire () throws Exception
    {
        bulletX = tankX + 25;
        bulletY = tankY + 25;

        while (bulletX > 0 && bulletX < BF_WIDTH && bulletY > 0 && bulletY < BF_HEIGHT)
        {
           switch (direction)
           {
               case 1 : bulletY--;
               break;
               case 2 : bulletY++;
               break;
               case 3 : bulletX--;
               break;
               case 4 : bulletX++;
               break;

           }
           Thread.sleep(10);
           repaint();
        }
        bulletX = -100;
        bulletY = -100;
    }


    void runTheGame () throws Exception
    {
        fire();
    }

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


        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                switch (objects[y] [x]) {
                    case "B":
                        g.setColor(new Color(224, 81, 15, 247));
                        break;
                    case "W":
                        g.setColor(new Color(28, 78, 123));
                        break;
                    case "G":
                        g.setColor(new Color(0xF1EEEB));
                        break;
                }

                g.fillRect(x * OBJECT_SIZE, y * OBJECT_SIZE, OBJECT_SIZE, OBJECT_SIZE);
            }
        }



        //draw tank
        g.setColor(Color.RED);
        g.fillRect(tankX, tankY, OBJECT_SIZE,OBJECT_SIZE);

        g.setColor(Color.GREEN);
        if(direction == 1)
        {
            g.fillRect(tankX + 20, tankY, 24,34);
        }else if (direction == 2)
        {
            g.fillRect(tankX + 20, tankY + 30, 24,34);
        }else if (direction == 3)
        {
            g.fillRect(tankX, tankY + 20, 34,24);
        }else if (direction == 4)
        {
            g.fillRect(tankX + 30, tankY + 20, 34,24);
        }

        //Draw bullen
        g.setColor(Color.YELLOW);
        g.fillRect(bulletX, bulletY, 14, 14);

    }
}
