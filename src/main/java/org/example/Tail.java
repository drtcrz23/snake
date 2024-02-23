package org.example;

import java.awt.*;

public class Tail{
  private int cordX = -100;
  private int cordY = -100;
  private int size = 15;

  public int getCordX() {
    return cordX;
  }

  public int getCordY() {
    return cordY;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Tail() {}

  public Tail(int cordX, int cordY, int size) {
    this.cordX = cordX;
    this.cordY = cordY;
    this.size = size;
  }

  public void draw(Graphics g) {
    g.fillOval(cordX + (25 - size) / 2, cordY + (25 - size) / 2, size, size);
  }

  void move(Tail part) {
    cordX = part.getCordX();
    cordY = part.getCordY();
  }

  void move(int x, int y) {
    cordX = x;
    cordY = y;
  }
}
