package oop.pojo.impl;

import oop.pojo.abstracts.AbstractMovableObject;

import java.awt.*;

public class Tank extends AbstractMovableObject {

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(tankX, tankY, QUADRANT_SIZE, QUADRANT_SIZE);

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
    }
}
