package Ghosts;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import Board.Board;
import Board.Drawable;

public class Casper extends Ghost implements Drawable {

	private String imageName = "ghost3.png";
	private Random random = new Random();
	private int xCoordinate = 60 * random.nextInt(11);
	private int yCoordinate = 60 * random.nextInt(11);
	private int direction = random.nextInt(4);
	private final int Width = Board.WIDTH - 20;
	private final int Height = Board.HEIGHT - 20;
	private int xSpeed = 2;
	private int ySpeed = 2;

//	 drawing casper.
	public void draw(Graphics g) {
		ImageIcon casper = new ImageIcon(getClass().getResource(imageName));
		g.drawImage(casper.getImage(), xCoordinate, yCoordinate, Width, Height, null);

	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}

	@Override
	public int getxCoordinate() {

		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {

		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {

		this.yCoordinate = yCoordinate;
	}

	@Override
	public void doAction() {
		if (Board.runTime % 3000 == 0 || getxCoordinate() == (Board.BOARD_WIDTH - getWidth()) || getxCoordinate() == 0
				|| getyCoordinate() == 0 || getyCoordinate() == (Board.BOARD_HEIGHT - getHeight())) {
			direction = random.nextInt(4);
		}
		switch (direction) {
		case 0:
			if (getxCoordinate() < (Board.BOARD_WIDTH - getWidth())) {
				this.xCoordinate += xSpeed;
			}

			break;
		case 1:
			if (getxCoordinate() > 0) {

				this.xCoordinate -= xSpeed;
			}
			break;
		case 2:
			if (getyCoordinate() < (Board.BOARD_HEIGHT - getHeight())) {
				this.yCoordinate += ySpeed;
			}
			break;
		case 3:
			if (getyCoordinate() > 0) {

				this.yCoordinate -= ySpeed;
			}
			break;
		}
	}

}
