## Overview

This project is a Java application that allows users to input a binary tree in a parenthesized prefix format and then analyze various features of the tree. The tree is built and represented internally, and several properties can be calculated and displayed, including whether the tree is balanced, full, or proper. The project also includes a graphical user interface (GUI) for user interaction.

## Installation

1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone or download this repository.
3. Compile the Java files in the source directory.

## Usage

1. Run the main class to launch the GUI.
2. Enter a binary tree in the parenthesized prefix format (e.g., `(A(G(j)(1))(z(5)))`).
3. Use the buttons in the GUI to:
   - Construct the tree. 
   - Check if the tree is balanced, full, or proper.
   - Display the height of the tree.
   - Display the number of nodes.
   - Get the fully parenthesized inorder traversal.
  
> :memo: **Note:** You must construct the tree before any using any other function.

## Example 1
Given the input:
```(A(G(j)(1))(z(5)))```
the tree will be constructed as follows.
```
    A
   / \
  G   z
 / \   \
j   1   5
```
- **Balanced**: Yes
- **Full**: No
- **Proper**: No
- **Height**: 2
- **Number of Nodes**: 6
- **Inorder Traversal**: `((( j ) G ( 1 )) A (( 5 ) z ))`
