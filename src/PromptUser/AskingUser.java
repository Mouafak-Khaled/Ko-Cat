package PromptUser;


import javax.swing.JOptionPane;


public class AskingUser {
//	class instance variables.

	private String food;
	private String poisonFood;
	private String ghosts;
	public static int foodNumber;
	public static int poisonFoodNumber;
	public static int ghostsNumber;

// The constructor of class Number that promptthe user to enter the number of foods and ghosts.
	public AskingUser() {
		this.food = JOptionPane.showInputDialog("Enter the number of foods: ");
		this.poisonFood = JOptionPane.showInputDialog("Enter the number of poisonous foods: ");
		this.ghosts = JOptionPane.showInputDialog("Enter the number of ghosts: ");
		setFoodNumber(this.foodNumber);
		setPoisonFoodNumber(this.poisonFoodNumber);
		setGhostsNumber(this.ghostsNumber);

	}

	
	
	public static int getFoodNumber() {
		return foodNumber;
	}

	
	
	public void setFoodNumber(int foodNumber) {

		for (int i = 0; i < this.food.length(); i++) {
			if (Character.isDigit(this.food.charAt(i))) {
				foodNumber = Integer.parseInt(this.food);
				if (foodNumber > 0) {
					this.foodNumber = foodNumber;
				} else {
					JOptionPane.showMessageDialog(null, "Invalid number, please enter a value > 0.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					AskingUser askAgain = new AskingUser();

				}

			} else {
				JOptionPane.showMessageDialog(null, "Invalid number, please enter an acceptal value.", "Warning",
						JOptionPane.WARNING_MESSAGE);
				AskingUser askAgain = new AskingUser();
			}
		}

	}

	
	
	public int getPoisonFoodNumber() {
		return poisonFoodNumber;
	}

	
	
	public void setPoisonFoodNumber(int poisonFoodNumber) {

		for (int i = 0; i < this.poisonFood.length(); i++) {
			if (Character.isDigit(this.poisonFood.charAt(i))) {
				poisonFoodNumber = Integer.parseInt(this.poisonFood);
				if (poisonFoodNumber > 0) {
					this.poisonFoodNumber = poisonFoodNumber;
				} else {
					JOptionPane.showMessageDialog(null, "Invalid number, please enter a value > 0.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					AskingUser askAgain = new AskingUser();

				}

			} else {

				JOptionPane.showMessageDialog(null, "Invalid number, please enter an acceptal value.", "Warning",
						JOptionPane.WARNING_MESSAGE);
				AskingUser askAgain = new AskingUser();

			}
		}
	}

	
	
	public  int getGhostsNumber() {
		return ghostsNumber;
	}

	
	
	public void setGhostsNumber(int ghostsNumber) {

		for (int i = 0; i < this.ghosts.length(); i++) {
			if (Character.isDigit(this.ghosts.charAt(i))) {
				ghostsNumber = Integer.parseInt(this.ghosts);
				if (ghostsNumber > 0) {
					this.ghostsNumber = ghostsNumber;
				} else {
					JOptionPane.showMessageDialog(null, "Invalid number, please enter a value > 0.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					AskingUser askAgain = new AskingUser();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid number, please enter an acceptal value.", "Warning",
						JOptionPane.WARNING_MESSAGE);
				AskingUser askAgain = new AskingUser();
			}
		}
	}

}
