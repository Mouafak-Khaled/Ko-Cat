package Board;

//import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Cat implements Drawable {
	private String imageName = "image_left.png";
	public static int score;
	private int xSpeed = 2;
	private int ySpeed = 2;
	private static final int WIDTH = Board.WIDTH;
	private static final int HEIGHT = Board.HEIGHT;
	private static int xCoordinate = (Board.BOARD_WIDTH - Board.WIDTH) / 2;
	private static int yCoordinate = (Board.BOARD_HEIGHT - Board.HEIGHT) / 2;
	private ImageIcon cat = new ImageIcon(getClass().getResource(imageName));;

	public void draw(Graphics g) {

		g.drawImage(cat.getImage(), xCoordinate, yCoordinate, WIDTH, HEIGHT, null);

	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		cat = new ImageIcon(getClass().getResource(imageName));
		this.imageName = imageName;
	}

	public static void setScore(int score) {
		Cat.score = score;
	}
	

	public static int getScore() {
		return score;
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static int getxCoordinate() {
		return xCoordinate;
	}

	public static void setxCoordinate(int xCoordinate) {
		Cat.xCoordinate = xCoordinate;
	}

	public static int getyCoordinate() {
		return yCoordinate;
	}

	public static void setyCoordinate(int yCoordinate) {
		Cat.yCoordinate = yCoordinate;
	}

//	moving the cat down.
	public void moveDown() {
		if (getyCoordinate() < (Board.BOARD_HEIGHT - getHEIGHT())) {
			yCoordinate += ySpeed;

		}

	}

//	moving the cat up.
	public void moveUp() {
		if (getyCoordinate() + ySpeed > 0) {
			yCoordinate -= ySpeed;

		}

	}

//	moving the cat left.
	public void moveLeft() {
		if (getxCoordinate() > 0) {
			xCoordinate -= xSpeed;

		}

	}

//	moving the cat right.
	public void moveRight() {

		if (getxCoordinate() < (Board.BOARD_WIDTH - getWIDTH())) {
			xCoordinate += xSpeed;

		}

	}

//	overriding the doAction method for the cat.
	public void doAction() {
		if (imageName.equals("image_down.png")) {
			moveDown();
		} else if (imageName.equals("image_right.png")) {
			moveLeft();
		} else if (imageName.equals("image_left.png")) {
			moveRight();
		} else {
			moveUp();
			
		}
	}
}
