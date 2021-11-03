
//Importing the Computer and Grid classes from the minimax package.
import minimax.Computer;
import minimax.Grid;

import java.awt.*; //importing the java.awt package for different awt classes such as Class.
import java.awt.event.*;//importing the package for action listener class
import java.awt.image.*;//importing the package for Image class
import java.io.*; //importing the IO package for Exceptions
import javax.imageio.*; //importing
import javax.swing.*; //Importing the javax.swing package for swing components

/**
 * <h1 style="color:red; font-size: large; text-align:center;">Java Program to implement Minimax Algorithm using an AI Agent</h1>
 * <h2 style="text-align:center;">Code compiled and Executed in a Windows 11 Device with Java JDK 17.0.0</h2>
 * <p>
 *      The Program is a GUI Implemetation of the <b><a href="https://en.wikipedia.org/wiki/Tic-tac-toe">Tic-Tac-Toe</a></b>
 * 		game by using Java Swings, the game is played against the computer in this case. The user takes the crosses or <strong>(X)</strong>
 * 		by default and the Computer takes the naughts ed by (O)</strong> the moves of the computer are predicted and implemented using the
 * 		<b></b> scheme and the state space trees and possible moves are displayed in the console and appropriate action is seen
 * 		in the GUI.
 * </p>
 * <p> 
 *      Inspired from  <a href="https://www.youtube.com/watch?v=rA7tfvpkw0I">Bro Code</a> and
 * 		<a href="https://www.youtube.com/watch?v=trKjYdBASyQ">The Coding Train</a>
 * </p>
 * <p> 
 *      Know more about the Minimax Algorithm from <a href="https://www.javatpoint.com/mini-max-algorithm-in-ai">Javapoint</a>
 * 		and <a href="https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-1-introduction/">Geeks For Geeks</a><br/>
 * 		Play a demo Tic-Tac-Toe Game <a href="https://g.co/kgs/YRaLVr">Google X and O</a>
 * </p>
 * 
 * @author Anurag Ghosh
 * @version 3.0
 * @since 2021-10-22
 */

/**
 * Main class which contains the main constructor and method.
 */
public class Main {

    /**
     * Main class containg the main method and integrates all the components
     * 
     * @return null
     */

    // Dynamically creating an object of Class Computer
    Computer player1 = new Computer(1);
    JFrame mainFrame = new JFrame("Tic-Tac-Toe"); // Defining and dynmically initializing a new JFrame
    JPanel mainPanel = new JPanel(); // Defining and dynamically initializing a JPanel to include all the
                                     // sub-components
    JPanel buttonPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JLabel textfield1 = new JLabel(); // Defining and initializing a JLable
    JLabel textfield2 = new JLabel();
    JLabel textfield3 = new JLabel();
    JLabel textfield4 = new JLabel();

    JButton restartButton = new JButton("Exit"); // Defining the restart button
    JButton buttons[][] = new JButton[3][3]; // Storing the values of the button in a 2D Array
    Grid mainGrid = new Grid(); // Defining and initializing new Grid

    Buttonhandler handler = new Buttonhandler(); // Defining and initializing a new instance of the Buttonhandler class

    /**
     * private class Buttonhandler to contain the methods for event handling using
     * the buttons
     * 
     */
    private class Buttonhandler implements ActionListener {

        /**
         * public method for performing the action in case of an event
         * 
         * @param e for the ActionEvent
         * @return null
         */
        // Overloading the actionPerformed method
        public void actionPerformed(ActionEvent e) {

            // Loops for iterating through the buttons array
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // if action is performed
                    if (e.getSource() == buttons[i][j]) {

                        // putting it into the grid
                        mainGrid.putIntoGrid(i, j);
                        rePaint(mainGrid);

                        // wining condition
                        if (mainGrid.findIfWon() == 2) {
                            JOptionPane.showMessageDialog(null, "You won, That's Impossible!");
                            System.exit(0);
                        } else if (mainGrid.findIfWon() == 0) { // Draw condition
                            JOptionPane.showMessageDialog(null, "Congratulations! You are Tied with Computer");
                            System.exit(0);
                        }

                        computerTurn(); // calling the computerTurn method
                    }
                }
            }

        }
    }

    /**
     * Main Method
     * 
     * @param args for the arguments
     */
    public static void main(String[] args) {

        // Dynamically creating and calling the instance of Main class
        new Main();
    }

    /**
     * public constructor for Main class
     * 
     */
    public Main() {

        startGame(); // calling the startGame method
    }

    /**
     * Public method for the game to start
     * 
     */
    private void startGame() {

        // calling the showGui method
        showGui();
        // Initializing the mainGrid by using the initializer object
        mainGrid.initialize();
        // passing this mainGrid to rePaint method
        rePaint(mainGrid);
    }

    /**
     * method for giving the AI Agent or computer the turn
     * 
     */
    public void computerTurn() {

        // Calling the player1 instance with the giveTurn Method
        player1.giveTurn(mainGrid);
        // Repainting the groid
        rePaint(mainGrid);

        // Condition for wining
        if (mainGrid.findIfWon() == 1) {
            JOptionPane.showMessageDialog(null, "Computer Wins");
            System.exit(0);
        } else if (mainGrid.findIfWon() == 0) { // Condfition for draw
            JOptionPane.showMessageDialog(null, "Congratulations! You are Tied with Computer");
            System.exit(0);
        }
    }

    /**
     * Method to display the GUI
     * 
     */
    public void showGui() {

        // Setting the layout for the mainPanel and gamePanel
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.setPreferredSize(new Dimension(800, 600));
        gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setPreferredSize(new Dimension(500, 500));
        // loops to iterate through the buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(handler);
                gamePanel.add(buttons[i][j]); // adding the buttons to the gamePanel

            }
        }

        mainPanel.add(gamePanel); // adding gamePanel to the mainPanel

        buttonPanel.setPreferredSize(new Dimension(300, 600));
        JLabel picLabel = new JLabel();
        picLabel.setBackground(new Color(25, 25, 25));
        picLabel.setForeground(new Color(25, 255, 0));
        picLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
        picLabel.setHorizontalAlignment(JLabel.CENTER);
        picLabel.setText("<html>Tic-Tac-Toe in AI<br/><br/><br/></html>"); // Adding a Text to the JLabel
        buttonPanel.add(picLabel);

        // try catch block for catching the exceptions if no file is present
        try {
            BufferedImage crossImg = ImageIO.read(new File("cross.png"));
            textfield1 = new JLabel(new ImageIcon(crossImg));
            buttonPanel.add(textfield1);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        // setting the other textfields
        textfield2.setBackground(new Color(25, 25, 25));
        textfield2.setForeground(new Color(25, 255, 0));
        textfield2.setFont(new Font("Ink Free", Font.BOLD, 40));
        textfield2.setHorizontalAlignment(JLabel.CENTER);
        textfield2.setText("<html> - You (As Player) &nbsp;<br/></html>");

        buttonPanel.add(textfield2); // adding to the buttonPanel

        // try catch block for catching the exceptions if no file is present
        try {
            BufferedImage circleImg = ImageIO.read(new File("circle.png"));
            textfield3 = new JLabel(new ImageIcon(circleImg));
            buttonPanel.add(textfield3);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        textfield4.setBackground(new Color(25, 25, 25));
        textfield4.setForeground(new Color(25, 255, 0));
        textfield4.setFont(new Font("Ink Free", Font.BOLD, 40));
        textfield4.setHorizontalAlignment(JLabel.CENTER);
        textfield4.setText("<html> - Computer (AI) &nbsp; </html>");

        buttonPanel.add(textfield4); // adding it to the buttonPanel

        restartButton.addActionListener(handler); // Adding actionListerner to the restart button

        buttonPanel.setBackground(Color.BLACK); // setting the background color of the buttonPanel
        mainPanel.add(buttonPanel);

        mainPanel.setBackground(Color.BLACK); // setting the background color of the mainPanel

        ImageIcon icon = new ImageIcon("icon.png"); // Icon definition
        mainFrame.setIconImage(icon.getImage()); // Adding the icon to the title bar
        mainFrame.add(mainPanel);
        mainFrame.setLayout(new GridLayout(1, 2)); // Setting the grid for the mainFrame
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close performed when exited
        mainFrame.getContentPane();
        mainFrame.setVisible(true); // making it visible

    }

    /**
     * Public method to repaint the grid
     * 
     * @param myGrid the grid object
     * 
     */
    public void rePaint(Grid myGrid) {

        // removing the previous things and setting new things
        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();
        gamePanel.setPreferredSize(new Dimension(500, 500));

        // Loops to iterate through the buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Method to get the cross and circle image
                buttons[i][j].addActionListener(handler);
                if (myGrid.value[i][j] != 0) {

                    if (myGrid.value[i][j] == 1) {
                        buttons[i][j] = getCircleButton();
                    } else {
                        buttons[i][j] = getCrossButton();
                    }

                }
                gamePanel.add(buttons[i][j]); // adding it to the gamePanel
            }
        }

        mainPanel.add(gamePanel);// adding it to the mainPanel
    }

    /**
     * Private method to get the circle image
     * @return button
     * 
     */
    private JButton getCircleButton() {

        JButton button = new JButton(); // defining and initializing a new button
        // setting an Icon to this button
        try {
            button.setIcon(new ImageIcon("circle.png"));
        } catch (Exception ex) {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
        }
        button.setSize(50, 50);

        return button; // returning the button

    }

    /**
     * Private method to get the cross image
     * @return button
     * 
     */
    private JButton getCrossButton() {

        JButton button = new JButton();// defining and initializing a new button
        // setting an Icon to this button
        try {
            button.setIcon(new ImageIcon("cross.png"));
        } catch (Exception ex) {
        }
        button.setSize(50, 50);

        return button; // returning the button
    }

}
