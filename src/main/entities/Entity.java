package main.entities;

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage up, up1, up2, upRight, upRight1, upRight2,  upLeft, upLeft1, upLeft2,  right, right1, right2, left, left1, left2, down, down1, down2, downRight, downRight1, downRight2, downLeft, downLeft1, downLeft2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
