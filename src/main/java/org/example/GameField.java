package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GameField extends JPanel implements KeyListener, ActionListener {
  private final int WIDTH = 800;
  private final int HEIGHT = 800;
  private final int UNIT_SIZE = 25;
  private Timer timer;
  private Snake snake;
  private Apple apple;

  public GameField() {

    snake = new Snake();
    apple = new Apple();
    setFocusable(true);
    addKeyListener(this);

    timer = new Timer(200, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < WIDTH / UNIT_SIZE; i++) {
      g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
      g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
    }
    snake.draw(g);
    apple.draw(g);
    Font font1 = new Font("Arial", Font.PLAIN, 20);
    g.setFont(font1);
    g.drawRect(0, 0, 150, 25);
    g.drawString("Твои очки: " + snake.getLength(), 10, 20);
    if(!timer.isRunning()) {
      Font font = new Font("Arial", Font.PLAIN, 50);
      g.setFont(font);
      g.setColor(Color.red);
      g.drawString("ТЫ проиграл!", 250,340);
    }
    if (snake.getLength() == 15) {
      timer.setDelay(150);
    }
    if (snake.getLength() == 30) {
      timer.setDelay(100);
    }
    if (snake.getLength() == 50) {
      timer.setDelay(50);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case 37 -> snake.changeDirection(Snake.Directions.LEFT);
      case 38 -> snake.changeDirection(Snake.Directions.UP);
      case 39 -> snake.changeDirection(Snake.Directions.RIGHT);
      case 40 -> snake.changeDirection(Snake.Directions.DOWN);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void actionPerformed(ActionEvent e) {
    snake.move();
    snake.checkApple(apple);
    if (snake.checkBorders()) {
      timer.stop();
    }
    repaint();
  }
}