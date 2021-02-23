package Ghosts;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import Board.Board;
import Board.Drawable;


public class Dolly extends Ghost implements Drawable {
	private Random random = new Random();
	private String imageName = "Dolly_down.png";
	private String initialImageName = "Dolly_down.png";
	private int xCoordinate = 60 * random.nextInt(11);
	private int yCoordinate = 60 * random.nextInt(11);
	private final int Width = Board.WIDTH - 24;
	private final int Height = Board.HEIGHT - 20;
	private int Y_Speed = 2;


	public void draw(Graphics g) {
		ImageIcon dolly = new ImageIcon(getClass().getResource(imageName));
		g.drawImage(dolly.getImage(), xCoordinate + 2, yCoordinate, Width, Height, null);

	}

	
	public int getWidth() {
		return Width;
	}

	
	public int getHeight() {

		return Height;
	}

	
	public int getxCoordinate() {
		return xCoordinate;
	}

	
	public void setxCoordinate(int xCordinate) {
		this.xCoordinate = xCordinate;
	}

	
	public int getyCoordinate() {
		return yCoordinate;
	}

	
	public void setyCoordinate(int yCordinate) {
		this.yCoordinate = yCordinate;
	}

	
	public String getImageName() {

		return imageName;
	}

	
	public void setImageName(String imageName) {
	this.imageName = imageName;

	}

	
	public void doAction() {
		if (getyCoordinate() + Y_Speed < 0 || getyCoordinate() + Y_Speed > Board.BOARD_HEIGHT - getHeight()) {
			this.Y_Speed *= -1;

		}
		if (getyCoordinate() == Board.BOARD_HEIGHT - getHeight()) {
			setImageName("Dolly_up.png"); 
		
		} else if (getyCoordinate() == 0) {
			setImageName(initialImageName);
			
		}

		yCoordinate = yCoordinate + Y_Speed;

	}
}
