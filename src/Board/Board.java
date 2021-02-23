/*  THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
    I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT.
 *  Name: Mouafak Alsaid Hasan.
 * 
 */

package Board;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import PromptUser.*;
import PromptUser.AskingUser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import Ghosts.*;
import Food.*;

public class Board extends JPanel implements KeyListener {

	public static final int BOARD_HEIGHT = 660;
	public static final int BOARD_WIDTH = 660;
	public static final int WIDTH = BOARD_WIDTH / 11;
	public static final int HEIGHT = (BOARD_HEIGHT) / 11;
	public static final int PAUSE_TIME = 10;
	private int collisionXpoint;
	private int collisionYpoint;
	public static int runTime = 0;
	private int xTouchPoint = cat.getxCoordinate() + cat.getWIDTH() / 2;
	private int yTouchPoint = cat.getyCoordinate() + cat.getHEIGHT() / 2;
	private ImageIcon board = new ImageIcon(getClass().getResource("boardImagee.jpg"));
	private ImageIcon gameOverScreen = new ImageIcon(getClass().getResource("gameover.jpg"));
	public Timer timer = new Timer(Board.PAUSE_TIME, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();

		}
	});
	private Food[] poisonFruits = new Food[AskingUser.poisonFoodNumber];
	private Food[] fruits = new Food[AskingUser.foodNumber];
	private Ghost ghost[] = new Ghost[AskingUser.ghostsNumber];
	private static Cat cat = new Cat();
	public static JLabel catScore = new JLabel("Score: " + cat.getScore());
	private JFrame frame;

	public Board() {
		createGhosts();
		createFood();
		catScore.setVisible(true);
		frame = new JFrame("Koc Cat game board.");
		frame.setVisible(true);
		frame.setSize(Board.BOARD_WIDTH + 8, Board.BOARD_WIDTH + 20);
		frame.setResizable(false);
		this.add(catScore);
		frame.add(this);
		timer.start();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setFocusTraversalKeysEnabled(false);
		this.addKeyListener(this);

	}

// overrriding the methods of KeyListener interface to manage the direction of the cat.

	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();

		switch (i) {
		case KeyEvent.VK_DOWN:
			cat.setImageName("image_down.png");

			break;
		case KeyEvent.VK_LEFT:
			cat.setImageName("image_right.png");

			break;
		case KeyEvent.VK_RIGHT:
			cat.setImageName("image_left.png");

			break;
		case KeyEvent.VK_UP:
			cat.setImageName("image_up.png");

			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	filling the array of ghosts with ashes, dollys, and caspers.
	public void createGhosts() {

		for (int i = 0; i < ghost.length; i++) {

			if (i < ghost.length / 3 || ghost.length == 1) {
				ghost[i] = new Ash();

			} else if (i < ghost.length / 3 * 2) {
				ghost[i] = new Dolly();

			} else {
				ghost[i] = new Casper();

			}

		}

	}

// filling the array of food with poisonous and consumable food.
	public void createFood() {
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new consumableFood();
		}
		for (int i = 0; i < poisonFruits.length; i++) {
			poisonFruits[i] = new poisonousFruits();
		}

	}

//	Two methods to specify the coordinate of the contact point between the cat and the fruits.
	public int contactXpoint() {
		switch (cat.getImageName()) {
		case "image_down.png":
			collisionXpoint = (cat.getxCoordinate() + cat.getWIDTH() / 2 - 4);

			break;
		case "image_right.png":
			collisionXpoint = (cat.getxCoordinate() + cat.getWIDTH() / 3 - 4);

			break;
		case "image_left.png":
			collisionXpoint = (cat.getxCoordinate() + 2 * cat.getWIDTH() / 3 - 4);

			break;
		case "image_up.png":
			collisionXpoint = (cat.getxCoordinate() + cat.getWIDTH() / 2 - 4);

			break;
		}
		return collisionXpoint;

	}

	public int contactYpoint() {
		switch (cat.getImageName()) {
		case "image_down.png":

			collisionYpoint = (cat.getyCoordinate() + 2 * cat.getHEIGHT() / 3 - 4);
			break;
		case "image_right.png":

			collisionYpoint = (cat.getyCoordinate() + cat.getHEIGHT() / 2 - 4);
			break;
		case "image_left.png":

			collisionYpoint = (cat.getyCoordinate() + cat.getHEIGHT() / 2 - 4);
			break;
		case "image_up.png":

			collisionYpoint = (cat.getyCoordinate() + cat.getHEIGHT() / 3 - 4);
			break;
		}
		return collisionYpoint;

	}

//	 two methods to call draw and other overridden methods of the cat, ghosts, and the fruits.

	public void drawTheGhosts(Graphics g) {
		int xTouchPoint = cat.getxCoordinate() + cat.getWIDTH() / 2;
		int yTouchPoint = cat.getyCoordinate() + cat.getHEIGHT() / 2;

		for (int i = 0; i < ghost.length; i++) {
			ghost[i].draw(g);
			ghost[i].doAction();
			ghost[i].getxCoordinate();
			ghost[i].getyCoordinate();

			if (xTouchPoint > ghost[i].getxCoordinate() && xTouchPoint < ghost[i].getxCoordinate() + ghost[i].getWidth()
					&& yTouchPoint > ghost[i].getyCoordinate()
					&& yTouchPoint < ghost[i].getyCoordinate() + ghost[i].getHeight()) {
				timer.stop();
				this.removeAll();
				frame.removeAll();
				gameOverScreen = new ImageIcon(getClass().getResource("gameover.jpg"));
				g.drawImage(gameOverScreen.getImage(), 0, 0, BOARD_WIDTH, BOARD_HEIGHT, null);

			}

		}

	}

	public void drawFruits(Graphics g) {
		for (int i = 0; i < fruits.length; i++) {
			fruits[i].draw(g);
			fruits[i].doAction();

			if ((contactXpoint() > fruits[i].getxCoordinate()
					&& contactXpoint() < fruits[i].getxCoordinate() + fruits[i].getWidth())
					&& (contactYpoint() > fruits[i].getyCoordinate()
							&& contactYpoint() < fruits[i].getyCoordinate() + fruits[i].getHeight())) {
				fruits[i].consumed();
			}
		}
		for (int i = 0; i < poisonFruits.length; i++) {
			poisonFruits[i].draw(g);
			poisonFruits[i].doAction();

			if (Board.runTime % 200 == 0
					&& (contactXpoint() > poisonFruits[i].getxCoordinate()
							&& contactXpoint() < poisonFruits[i].getxCoordinate() + poisonFruits[i].getWidth())
					&& (contactYpoint() > poisonFruits[i].getyCoordinate()
							&& contactYpoint() < poisonFruits[i].getyCoordinate() + poisonFruits[i].getHeight())) {
				poisonFruits[i].consumed();
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.drawImage(board.getImage(), 0, 0, BOARD_WIDTH, BOARD_HEIGHT, null);
		runTime += PAUSE_TIME;
		cat.draw(g);
		cat.doAction();
		drawFruits(g);
		drawTheGhosts(g);

		if (cat.getScore() < 0) {

			timer.stop();
			frame.removeAll();
			this.removeAll();
			gameOverScreen = new ImageIcon(getClass().getResource("gameover.jpg"));
			g.drawImage(gameOverScreen.getImage(), 0, 0, BOARD_WIDTH, BOARD_HEIGHT, null);

		}
	}

}
