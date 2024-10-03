/*
 * Christopher Gross
 * 
 * InvalidTreeSyntax creates custom window with message to display errors for invalid inputs.
 */


import javax.swing.JOptionPane;

//thrown when invalid input string is supplied & Make Tree button is clicked
//exception should be caught in main class. JOptionPane should display with reason for invalid syntax

public class InvalidTreeSyntax extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTreeSyntax (String message) {
		super(message);
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}