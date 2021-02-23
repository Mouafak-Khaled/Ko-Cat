package Ghosts;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import Board.Board;


public class Ash extends Ghost {
	private String imageName = "ghost1.png";
	private String initialImageName = "ghost1.png";
	private Random random = new Random();
	private int xCoordinate = 60 * random.nextInt(11);
	private int yCoordinate = 60 * random.nextInt(11);
	private final int Width = Board.WIDTH - 20;
	private final int Height = Board.HEIGHT - 20;
	private int xSpeed = 2;
	

	
// drawing ash objects.
	public void draw(Graphics g) {
		ImageIcon ash = new ImageIcon(getClass().getResource(imageName));
		g.drawImage(ash.getImage(), xCoordinate, yCoordinate, Width, Height, null);

	}

	
// setters and getters.
	
	public int getWidth() {
		return Width;
	}

	
	
	public int getHeight() {
		return Height;
	}

	
	
	public String getImageName() {
		return imageName;
	}

	
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
	
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

	
	
	public int getxSpeed() {
		return xSpeed;
	}

	
	
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	
	



//	overriding the do  action method.
	public void doAction() {
		
			if (getxCoordinate() + xSpeed < 0 || getxCoordinate() + xSpeed > Board.BOARD_WIDTH - getWidth()) {
				this.xSpeed *= -1;

			}
			if (getxCoordinate() == Board.BOARD_WIDTH - getWidth()) {
				setImageName("Ash_left.png"); 
			
			} else if (getxCoordinate() == 0) {
				setImageName(initialImageName);
				
			}
			xCoordinate = xCoordinate + xSpeed;
		

	}

}
