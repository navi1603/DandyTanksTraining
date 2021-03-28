package oop.pojo.impl;

import oop.pojo.abstracts.AbstractBFObject;

import java.awt.*;

public class Brick extends AbstractBFObject {

    public Brick(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(224, 81, 15, 247));
        g.fillRect(getX(), getY(), 64,64);

    }
}
