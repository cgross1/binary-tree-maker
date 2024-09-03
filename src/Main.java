/*
 * Christopher Gross
 * CMSC 350 / 6980
 * Project 3
 * 7/25/23
 * 
 * Main class creates GUI, takes in user input, and calls functions when buttons are clicked to interpret user input
 */


import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main {
	
	public static JTextField resultField;

	
	public static void main(String[] args) throws InvalidTreeSyntax {
		populateGUI();
	}
	
	
	//generates GUI for user to input binary tree and execute functions
	public static void populateGUI() {
		JFrame frame = new JFrame("Binary Tree Categorizer");
		
        JLabel inputLabel = new JLabel("Enter Tree:");
        JTextField inputField = new JTextField(30);
        JButton makeTreeButton = new JButton("Make Tree");
        JButton isBalancedButton = new JButton("Is Balanced?");
        JButton isFullButton = new JButton("Is Full?");
        JButton isProperButton = new JButton("Is Proper?");
        JButton heightButton = new JButton("Height");
        JButton nodesButton = new JButton("Nodes");
        JButton inoderButton = new JButton("Inorder");
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(30);
        resultField.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        JPanel line1 = new JPanel (new FlowLayout(FlowLayout.CENTER));
        line1.add(inputLabel);
        line1.add(inputField);
        
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        line2.add(makeTreeButton);
        line2.add(isBalancedButton);
        line2.add(isFullButton);
        line2.add(isProperButton);
        line2.add(heightButton);
        line2.add(nodesButton);
        line2.add(inoderButton);
        
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        line3.add(resultLabel);
        line3.add(resultField);
        
        panel.add(line1);
        panel.add(line2);
        panel.add(line3);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        
        //button listeners here. Each button calls their own function from BinaryTree class to execute
        makeTreeButton.addActionListener(e -> {
			try {
				resultField.setText(BinaryTree.makeTree(inputField.getText()));
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        isBalancedButton.addActionListener(e -> {
			try {
				resultField.setText(BinaryTree.isBalanced());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        isFullButton.addActionListener(e -> {
			try {
				resultField.setText(BinaryTree.isFull());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        isProperButton.addActionListener(e -> {
			try {
				resultField.setText(BinaryTree.isProper());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        heightButton.addActionListener(e -> {
			try {
				resultField.setText("Height: " + BinaryTree.getHeight());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        nodesButton.addActionListener(e -> {
			try {
				resultField.setText("Number of Nodes: " + BinaryTree.getNodes());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
        
        inoderButton.addActionListener(e -> {
			try {
				resultField.setText("Inorder: " + BinaryTree.getInorder());
			} catch (InvalidTreeSyntax e1) {
				e1.printStackTrace();
			}
		});
	}


}
