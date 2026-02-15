package main.entities;

import main.controllers.KeyHandler;
import main.views.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try{
            up = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpIdle.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Up2.png"));

            upRight = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpRightIdle.png"));
            upRight1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpRight1.png"));
            upRight2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpRight2.png"));

            upLeft = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpLeftIdle.png"));
            upLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpLeft1.png"));
            upLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_UpLeft2.png"));

            down = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownIdle.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Down2.png"));

            downRight = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownRightIdle.png"));
            downRight1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownRight1.png"));
            downRight2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownRight2.png"));

            downLeft = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownLeftIdle.png"));
            downLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownLeft1.png"));
            downLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_DownLeft2.png"));

            right = ImageIO.read(getClass().getResourceAsStream("/player/Character_RightIdle.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Right2.png"));

            left = ImageIO.read(getClass().getResourceAsStream("/player/Character_LeftIdle.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Character_Left2.png"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed == true){
                direction = "up";
                y -= speed;
            }
            if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1) {
                    image = up;
                }
                if (spriteNum == 2) {
                    image = up1;
                }
                if (spriteNum == 3) {
                    image = up2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left;
                }
                if (spriteNum == 2) {
                    image = left1;
                }
                if (spriteNum == 3) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right;
                }
                if (spriteNum == 2) {
                    image = right1;
                }
                if (spriteNum == 3) {
                    image = right2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down;
                }
                if (spriteNum == 2) {
                    image = down1;
                }
                if (spriteNum == 3) {
                    image = down2;
                }
                break;

        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
