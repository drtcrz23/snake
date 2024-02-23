package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
  public static enum Directions {
    UP,
    RIGHT,
    DOWN,
    LEFT,
    STAY
  }

  private int cordX = 100;
  private int cordY = 100;
  private int size = 25;
  private int length = 1;
  private Directions direction = Directions.STAY;

  public int getLength() {
    return length;
  }
  private ArrayList<Tail> tail = new ArrayList<>();

  public Directions getDirection() {
    return direction;
  }

  public Snake() {}

  public Snake(int cordX, int cordY, int size) {
    this.cordX = cordX;
    this.cordY = cordY;
    this.size = size;
  }

  public void draw(Graphics g) {
    g.setColor(Color.green);
    g.fillOval(cordX, cordY, size, size);
    for (Tail value : tail) {
      value.draw(g);
    }
  }

  void move() {
    for (int i = tail.size() - 1; i >= 1; --i) {
      tail.get(i).move(tail.get(i - 1));
    }
    if (!tail.isEmpty()) {
      tail.get(0).move(cordX, cordY);
    }
    switch (direction) {
      case UP -> cordY -= size;
      case RIGHT -> cordX += size;
      case DOWN -> cordY += size;
      case LEFT -> cordX -= size;
    }
  }

  void changeDirection(Directions direction) {
    this.direction = direction;
  }

  void checkApple(Apple apple) {
    if (cordX == apple.getAppleX() && cordY == apple.getAppleY()) {
      length++;
      apple.newApple();

      Tail tailPart = new Tail();
      tail.add(tailPart);
      for (int i = 0; i < tail.size(); i++) {
        tail.get(i).setSize(15 + 10 * (tail.size() - i - 1) / tail.size());
      }
    }
  }


  boolean checkBorders() {
    if (cordX >= 800 || cordX < 0 || cordY >= 800 || cordY < 0) {
      return true;
    }
    for (Tail value : tail) {
      if (value.getCordX() == cordX && value.getCordY() == cordY) {
        return true;
      }
    }
    return false;
  }
}