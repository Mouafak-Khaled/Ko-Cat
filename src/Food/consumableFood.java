package Food;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;
import Board.*;

public class consumableFood extends Food implements Drawable {

//class instances variables.	
	private String imageName2 = "grapes2.png";
	private String imageName = "food2.png";
	private String initialImageName = imageName;
	private Random random = new Random();
	private ImageIcon fruitImage = new ImageIcon(getClass().getResource(imageName));

	private int Width = Board.WIDTH / 3;
	private int Height = Board.HEIGHT / 3;
	private int initialWidth = Board.WIDTH / 3;
	private int initialHeight = Board.HEIGHT / 3;
	private int foodAge = 1;
	private int xCoordinate = Board.WIDTH * random.nextInt(11);
	private int yCoordinate = Board.HEIGHT * random.nextInt(11);

// Drawing the fruits
	public void draw(Graphics g) {

		g.drawImage(fruitImage.getImage(), xCoordinate, yCoordinate, Width, Height, null);

	}

// setters and getters	
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

	public int getWidth() {
		return Width;
	}

	public void setWIDTH(int WIDTH) {
		this.Width = WIDTH;
	}

	public int getHeight() {
		return Height;
	}

	public void setHEIGHT(int HEIGHT) {
		this.Height = HEIGHT;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		fruitImage = new ImageIcon(getClass().getResource(imageName));
		this.imageName = imageName;
	}

	public int getFoodAge() {
		return foodAge;
	}

	public void setFoodAge(int foodAge) {
		this.foodAge = foodAge;
	}

// overriding the methods of the super class and the drawable interface.

	@Override
	public void grow() {
		if (Board.runTime % 1000 == 0 && foodAge != 10) {
			foodAge++;
			setWIDTH(2 + Width);
			setHEIGHT(2 + Height);

		}
		if (foodAge == 5) {
			setImageName(imageName2);
		}
		if (foodAge == 10) {
			setImageName(initialImageName);
			setxCoordinate(xCoordinate);
			setyCoordinate(yCoordinate);
			setWIDTH(initialWidth);
			setHEIGHT(initialHeight);
			setFoodAge(1);

		}

	}

	@Override
	public void consumed() {
		Cat.setScore(Cat.score +5 * getFoodAge());
		Board.catScore.setText("Score: " + Cat.getScore());
		setImageName(initialImageName);
		setWIDTH(this.initialWidth);
		setHEIGHT(this.initialHeight);
		setxCoordinate(this.xCoordinate);
		setyCoordinate(this.yCoordinate);
//		System.out.println("The cat score is: " + Cat.score);

	}

	public void doAction() {
		// TODO Auto-generated method stub
		grow();
	}

}
