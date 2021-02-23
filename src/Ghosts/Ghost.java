package Ghosts;

import Board.Drawable;

public abstract class Ghost implements Drawable {

	public abstract int getxCoordinate();

	public abstract int getyCoordinate();

	public abstract int getWidth();
	
	public abstract int getHeight();

	public abstract void setxCoordinate(int xCoordinate);

	public abstract void setyCoordinate(int yCoordinate);

}
