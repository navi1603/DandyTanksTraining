package oop.pojo.impl;

import oop.pojo.abstracts.AbstractMovableObject;

import java.awt.*;

public class Bullet extends AbstractMovableObject {

    public Bullet(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(bulletX, bulletY, 14, 14);
    }
}
