package minimax; //definging the package using the package keyword

/**
 * Class in the package minimax for defining the agent and implements the logic
 * for the AI Agent to act
 * 
 */
public class Computer {

	/**
	 * protected identity global variable to store whether the player is Computer or
	 * human
	 */
	protected int identity; // integer as identity
	/** Creating and initializing a new instance of Grid */
	public Grid maxNode = new Grid(); // new grid object initialization

	/**
	 * public constructor for the identity
	 * 
	 * @param identity i.e whether the player is player or coumputer
	 * 
	 */

	public Computer(int identity) {

		this.identity = identity; // setting the itentity to the identity of this constructor
	}

	/**
	 * public method to give turn to the computer
	 * 
	 * @param mainGrid for the agent to know the position in the
	 * @return mainGrid
	 * 
	 */

	public Grid giveTurn(Grid mainGrid) {

		Grid tempRoot = new Grid();
		tempRoot.copyValues(mainGrid);

		// Displaying the max node values
		System.out.println("\nMax Node values : ");
		maxNode.printValues();

		// finding the max root
		findMax(tempRoot, 0);
		mainGrid.copyValues(maxNode); // copying the values
		return mainGrid; // returning the mainGrid
	}

	/**
	 * protected method to find the max value
	 * 
	 * @param currentGrid the ciurrent grid in which the player is playing
	 * @param level       the level of the state
	 * @return maximumValue
	 */
	protected int findMax(Grid currentGrid, int level) {

		int currentState = currentGrid.findIfWon();
		currentGrid.decision = currentState;

		// conditions for the currentState
		if (currentState == identity) {
			return 10;
		} else if (currentState == 0) {
			return 0;
		} else if (currentState != -1) {
			return -10;
		}

		int possibleMoves = currentGrid.countEmptySpots();
		currentGrid.initializeChildGrids(possibleMoves);

		int maximumValue = -99999;
		// Displaying the possible values
		System.out.println("Possible Value for the agent : ");
		System.out.println(possibleMoves);

		// Displaying the current grid values
		System.out.println("Current Grid values : ");
		currentGrid.printValues();

		// loop through all the children and find the max value
		for (int i = 0; i < possibleMoves; i++) {

			Grid tempGrid = new Grid();
			tempGrid.copyValues(currentGrid);
			tempGrid.putValue(i, identity);
			currentGrid.childGrids[i].copyValues(tempGrid);

			int tempValue = findMin(tempGrid, level + 1);

			if (tempValue >= maximumValue) {
				maximumValue = tempValue;
				if (level == 0) {
					maxNode.copyValues(tempGrid);
				}
			}

		}

		return maximumValue;

	}

	/**
	 * protected method to find the min value
	 * 
	 * @param currentGrid the ciurrent grid in which the player is playing
	 * @param level       the level of the state
	 * @return minimumValue
	 */
	protected int findMin(Grid currentGrid, int level) {

		int currentState = currentGrid.findIfWon();
		currentGrid.decision = currentState;

		if (currentState == identity) {
			return 10;
		} else if (currentState == 0) {
			return 0;
		} else if (currentState != -1) {
			return -10;
		}

		int possibleMoves = currentGrid.countEmptySpots();
		currentGrid.initializeChildGrids(possibleMoves);

		// Displaying the grid values
		System.out.println("Grid Values : ");
		currentGrid.printValues();

		int minimumValue = 999999;

		// loop through all the children and find the min value
		for (int i = 0; i < possibleMoves; i++) {

			Grid tempGrid = new Grid();
			tempGrid.copyValues(currentGrid);
			tempGrid.putValue(i, 2);
			currentGrid.childGrids[i].copyValues(tempGrid);

			System.out.println("Temprorary Grid Values");
			tempGrid.printValues();

			minimumValue = Math.min(minimumValue, findMax(tempGrid, level + 1));
		}

		return minimumValue; // return the minvalue
	}

}