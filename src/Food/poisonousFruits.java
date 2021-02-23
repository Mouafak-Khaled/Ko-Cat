package Food;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import Board.*;


public class poisonousFruits extends Food implements Drawable {
	
	
	private Random random = new Random();
	private String imageName = "result.png";
	private String initialImageName = "yellowApple.png";
	private int fruitAge = 1;
	private int Width = Board.WIDTH / 3;
	private int Height = Board.HEIGHT / 3;
	private int xCoordinate = Board.WIDTH * random.nextInt(11);
	private int yCoordinate = Board.HEIGHT * random.nextInt(11);
	private ImageIcon poisonFruit = new ImageIcon(getClass().getResource(initialImageName));

	
	
	
	public void draw(Graphics g) {
		g.drawImage(poisonFruit.getImage(), xCoordinate, yCoordinate, Width, Height, null);

	}

	
	public int getFruitAge() {
		return fruitAge;
	}

	
	public int getxCoordinate() {
		return xCoordinate;
	}

	
	public void setxCoordinate(int xCoordinate) {
		xCoordinate = Board.WIDTH * random.nextInt(11);
		this.xCoordinate = xCoordinate;
	}

	
	public int getyCoordinate() {

		return yCoordinate;
	}

	
	public void setyCoordinate(int yCoordinate) {
		yCoordinate = Board.HEIGHT * random.nextInt(11);
		this.yCoordinate = yCoordinate;
	}

	
	
	public String getImageName() {
		return imageName;
	}

	
	
	public void setImageName(String imageName) {
		poisonFruit = new ImageIcon(getClass().getResource(imageName));
		this.imageName = imageName;

	}

	
	
	public int getWidth() {
		return Width;
	}

	
	
	public void setWIDTH(int Width) {
		this.Width = Width;
	}

	
	
	public int getHeight() {
		return Height;
	}

	
	
	public void setHEIGHT(int Height) {
		this.Height = Height;
	}

	
	
	public void setFoodAge(int fruitAge) {
		this.fruitAge = fruitAge;
	}

	
	
	@Override
	public void doAction() {
		grow();
	}

	
	
	@Override
	public void grow() {

		if (Board.runTime % 1000 == 0 && fruitAge != 10) {
			fruitAge++;
			setWIDTH(2 + Width);
			setHEIGHT(2 + Height);

		}
		if (fruitAge == 10) {
			setImageName(imageName);
		}

	}

	
	@Override
	public void consumed() {
		// TODO Auto-generated method stub
		Cat.setScore(Cat.score - 10 * getFruitAge()); 
		Board.catScore.setText("Score: " + Cat.getScore());
	}

}
