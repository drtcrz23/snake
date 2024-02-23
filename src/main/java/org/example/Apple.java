package org.example;

import java.awt.*;
import java.util.Random;

public class Apple {
  private final int WIDTH = 800;
  private final int HEIGHT = 800;
  private final int UNIT_SIZE = 25;

  private int appleX;
  private int appleY;

  public void newApple() {
    appleX = new Random().nextInt((WIDTH / UNIT_SIZE)) * UNIT_SIZE;
    appleY = new Random().nextInt((HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
  }

  public int getAppleX() {
    return appleX;
  }

  public int getAppleY() {
    return appleY;
  }
  public void draw(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
  }
}
