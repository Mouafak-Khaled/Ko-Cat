package Food;
import Board.Drawable;

public abstract class Food implements Drawable {

	public abstract int getxCoordinate();

	public abstract int getyCoordinate();

	public abstract void setxCoordinate(int xCoordinate);

	public abstract void setyCoordinate(int yCoordinate);

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract void consumed();

	public abstract void grow();

}
