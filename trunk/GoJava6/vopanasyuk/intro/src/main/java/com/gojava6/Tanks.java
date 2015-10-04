package com.gojava6;
/*
 * Opanasyuk Valentin
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.0
 */
public class Tanks extends JPanel {

    final boolean COLORDED_MODE = false;

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - top, 2 - bottom, 3 - left, 4 - right
    int tankDirection = 4;

    int tankX = 0;
    int tankY = 0;

    int bulletX = 30;
    int bulletY = 25;

    int speed = 20;
    int bulletSpeed = 5;

//	 String[][] battleField = {
//	 {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//	 {"B", " ", " ", " ", " ", " ", " ", " ", " "},
//	 };

    String[][] battleField = { { " ", " ", " ", "B", "B", "B", "B", "B", "B" },
            { " ", " ", " ", " ", " ", " ", " ", " ", "B" },
            { " ", "B", "B", " ", "B", " ", "B", "B", "B" },
            { " ", "B", "B", " ", " ", " ", "B", "B", "B" },
            { " ", "B", "B", " ", "B", " ", "B", "B", "B" },
            { " ", "B", " ", "B", "B", "B", " ", "B", "B" },
            { " ", "B", " ", " ", " ", " ", " ", "B", "B" },
            { " ", " ", " ", "B", "B", "B", " ", " ", "B" },
            { " ", " ", " ", "B", "B", "B", " ", " ", "B" } };

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

        clean();


//		 move(4); move(2); move(3); move(1); // right, down, left, up

//		 moveToQuadrant(9, 9);
//		 moveToQuadrant(1, 1);

//		 while(true){
//		 	moveRandom();
//		 }

//		 while(true){
//		 	fire();
//		 }

    }

    void clean() throws Exception {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (!battleField[i - 1][j - 1].equals(" ")) {
                    moveToQuadrant(j, i);
                }
            }
        }
    }

    boolean processInterception() {
        int separator = getQuadrant(bulletX, bulletY).indexOf("_");
        int bulletQuadrantHor = Integer.valueOf(getQuadrant(bulletX, bulletY).substring(0, separator));
        int bulletQuadrantVert = Integer.valueOf(getQuadrant(bulletX, bulletY).substring(separator + 1));
        if (!battleField[bulletQuadrantHor][bulletQuadrantVert].equals(" ")) {
            battleField[bulletQuadrantHor][bulletQuadrantVert] = " ";
            return true;
        }
        return false;
    }

    String getQuadrant(int x, int y) {
        return y / 64 + "_" + x / 64;
    }



    void fire() throws Exception {
        final int BULLET_COORDINATE_MAX = 64 * 9 - 14;

        bulletX = tankX + 25;
        bulletY = tankY + 25;
        if (tankDirection == 2) {
            while (bulletY < BULLET_COORDINATE_MAX) {
                bulletY++;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 1) {
            while (bulletY >= 0) {
                bulletY--;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 3) {
            while (bulletX >= 0) {
                bulletX--;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 4) {
            while (bulletX < BULLET_COORDINATE_MAX) {
                bulletX++;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        }
    }

    void fireNeighbor() throws Exception {
        bulletX = tankX + 25;
        bulletY = tankY + 25;
        if (tankDirection == 2) {
            while (bulletY < tankY + 114) {
                bulletY++;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 1) {
            while (bulletY > tankY - 64) {
                bulletY--;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 3) {
            while (bulletX > tankX - 64) {
                bulletX--;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        } else if (tankDirection == 4) {
            while (bulletX < tankX + 114) {
                bulletX++;
                repaint();
                processInterception();
                Thread.sleep(bulletSpeed);
            }
        }
    }

    String getQuadrantXY(int v, int h) {
        return String.valueOf((v - 1) * 64) + "_" + String.valueOf((h - 1) * 64);
    }

    void move(int direction) throws Exception {
        turn(direction);

        int separator = getQuadrant(tankX, tankY).indexOf("_");
        int tankQuadrantHor = Integer.valueOf(getQuadrant(tankX, tankY).substring(0, separator));
        int tankQuadrantVert = Integer.valueOf(getQuadrant(tankX, tankY).substring(separator + 1));

        if (direction == 1 && tankY >= 64) {
            if (!battleField[tankQuadrantHor - 1][tankQuadrantVert].equals(" ")) {
                fireNeighbor();
                battleField[tankQuadrantHor - 1][tankQuadrantVert] = " ";
            }
            int tankY0 = tankY;
            while (tankY > tankY0 - 64) {
                tankY--;
                bulletX = tankX + 25;
                bulletY = tankY + 20;
                System.out.println(tankX + "_" + tankY);
                repaint();
                Thread.sleep(speed);
            }
        } else if (direction == 2 && tankY <= 64 * 7) {
            if (!battleField[tankQuadrantHor + 1][tankQuadrantVert].equals(" ")) {
                fireNeighbor();
                battleField[tankQuadrantHor + 1][tankQuadrantVert] = " ";
            }
            int tankY0 = tankY;
            while (tankY < tankY0 + 64) {
                tankY++;
                bulletX = tankX + 25;
                bulletY = tankY + 30;
                System.out.println(tankX + "_" + tankY);
                repaint();
                Thread.sleep(speed);
            }
        } else if (direction == 3 && tankX >= 64) {
            if (!battleField[tankQuadrantHor][tankQuadrantVert - 1].equals(" ")) {
                fireNeighbor();
                battleField[tankQuadrantHor][tankQuadrantVert - 1] = " ";
            }
            int tankX0 = tankX;
            while (tankX > tankX0 - 64) {
                tankX--;
                bulletX = tankX + 20;
                bulletY = tankY + 25;
                System.out.println(tankX + "_" + tankY);
                repaint();
                Thread.sleep(speed);
            }
        } else if (direction == 4 && tankX <= 64 * 7) {
            if (!battleField[tankQuadrantHor][tankQuadrantVert + 1].equals(" ")) {
                fireNeighbor();
                battleField[tankQuadrantHor][tankQuadrantVert + 1] = " ";
            }
            int tankX0 = tankX;
            while (tankX < tankX0 + 64) {
                tankX++;
                bulletX = tankX + 30;
                bulletY = tankY + 25;
                System.out.println(tankX + "_" + tankY);
                repaint();
                Thread.sleep(speed);
            }
        }
    }

    void turn(int direction) {
        tankDirection = direction;
    }

    void moveRandom() throws Exception {
        while (true) {
            move(Integer.parseInt(String.valueOf(System.currentTimeMillis() % 4 + 1)));
            fire();
        }
    }

    void moveToQuadrant(int v, int h) throws Exception {
        int separator = getQuadrantXY(v, h).indexOf("_");
        int xCoordinate = Integer.valueOf(getQuadrantXY(v, h).substring(0, separator));
        int yCoordinate = Integer.valueOf(getQuadrantXY(v, h).substring(separator + 1));
        int tankX0 = tankX;
        int tankY0 = tankY;

        if (tankY0 < yCoordinate) {
            for (int i = 0; i < (yCoordinate - tankY0) / 64; i++) {
                move(2);
            }
        } else if (tankY0 > yCoordinate) {
            for (int i = 0; i < (tankY0 - yCoordinate) / 64; i++) {
                move(1);
            }
        }

        if (tankX0 < xCoordinate) {
            for (int i = 0; i < (xCoordinate - tankX0) / 64; i++) {
                move(4);
            }
        } else if (tankX0 > xCoordinate) {
            for (int i = 0; i < (tankX0 - xCoordinate) / 64; i++) {
                move(3);
            }
        }

    }

    // Magic bellow. Do not worry about this now, you will understand everything
    // in this course.
    // Please concentrate on your tasks only.

    public static void main(String[] args) throws Exception {
        Tanks bf = new Tanks();
        bf.runTheGame();
    }

    public Tanks() throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                if (battleField[j][k].equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates
                            .substring(0, separator));
                    int x = Integer.parseInt(coordinates
                            .substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDirection == 1) {
            g.fillRect(tankX + 20, tankY, 24, 34);
        } else if (tankDirection == 2) {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        } else if (tankDirection == 3) {
            g.fillRect(tankX, tankY + 20, 34, 24);
        } else {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }

}