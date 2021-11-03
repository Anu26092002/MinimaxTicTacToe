/**
 * Class in the pacakage minimax
 * 
 */
package minimax; //definging the package using the package keyword

/**
 * Public class grid which implements the logic for making the grid
 * 
 * 
 */
public class Grid {

	/**public global variable to store the grid values */
	public int value[][] = new int[3][3]; // initializing the array
	/**public global variable to store the child of each iteration by using an array of objects */
	public Grid childGrids[]; // Array of objects of Grid definition
	/**public global variable for Decissions */
	public int decision = -1; // decision for the agent to perform

	/**
	 * Public constructor for initialization
	 */
	public Grid() {

	}

	/**
	 * Public method to initialize the grid
	 * 
	 */
	public void initialize() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				value[i][j] = 0; // setting the value to
			}
		}
	}

	/**
	 * Method to copy the values
	 * 
	 * @param temp to copy the temp values
	 */
	public void copyValues(Grid temp) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				value[i][j] = temp.value[i][j]; // compying the temp values
			}
		}
	}

	/**
	 * Initializing the children at each node
	 * 
	 * @param total to find the number of childs for each node
	 */
	public void initializeChildGrids(int total) {

		// initalizing the array of objects
		childGrids = new Grid[total];
		for (int i = 0; i < total; i++) {
			childGrids[i] = new Grid();
		}
	}

	/**
	 * public method to count the empty positions
	 * 
	 * @return counter
	 */
	public int countEmptySpots() {

		int counter = 0; // initializing the counter
		// loops to iterate through the values
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (value[i][j] == 0) {
					counter++;
				}
			}
		}

		return counter;
	}

	/**
	 * Public method to put the values in the grid
	 * 
	 * @param loc the location of the values
	 * @param id  the id for the value
	 */
	public void putValue(int loc, int id) {

		int counter = 0; // counter initialization
		// loops to iterate and find empty postions and put the value in it
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (value[i][j] == 0 && loc == counter) {
					value[i][j] = id;
					return;
				} else if (value[i][j] == 0) {
					counter++;
				}
			}
		}
	}

	/**
	 * Method to find who has won
	 * 
	 * @return temp
	 */
	public int findIfWon() {

		int temp = vertical(); // for vertical condition
		if (temp == 1 || temp == 2) {
			return temp;
		}

		temp = horizontal();// for horizontal condition
		if (temp == 1 || temp == 2) {
			return temp;
		}

		temp = diagonal(); // for diagonal condition
		if (temp == 1 || temp == 2) {
			return temp;
		}

		if (draw() == true) { // draw condition
			return 0;
		}

		return -1;
	}

	/**
	 * Method to find if its a draw
	 * @return true
	 */
	public boolean draw() {
		// loop for iterating through the values
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (value[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Method for vertical checking
	 * @return value
	 */
	public int vertical() {
		for (int i = 0; i < 3; i++) {

			if (value[0][i] == value[1][i] && value[1][i] == value[2][i] && value[1][i] != 0) {
				return value[1][i];
			}
		}

		return -1;
	}

	/**
	 * Method for horizontal checking
	 * 
	 * @return value
	 */
	public int horizontal() {
		for (int i = 0; i < 3; i++) {
			if (value[i][0] == value[i][1] && value[i][1] == value[i][2] && value[i][0] != 0) {
				return value[i][0];
			}
		}

		return -1;
	}

	/**
	 * Method for diagonal checking
	 * 
	 * @return value
	 */
	public int diagonal() {

		if (value[0][0] == value[1][1] && value[1][1] == value[2][2] && value[0][0] != 0) {
			return value[0][0];
		}
		if (value[0][2] == value[1][1] && value[1][1] == value[2][0] && value[1][1] != 0) {
			return value[1][1];
		}

		return -1;
	}

	/**
	 * public method to put in the grid
	 * 
	 * @param i the i th row of the 2D array
	 * @param j the j th roe of the 2D array
	 */
	public void putIntoGrid(int i, int j) {
		value[i][j] = 2;
	}

	/**
	 * protected method to print the grid values
	 * 
	 */
	protected void printValues() {

		// looping through the grid
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(value[i][j] + " "); // printing the values
			}
			System.out.println();
		}
		System.out.println();
	}
}
