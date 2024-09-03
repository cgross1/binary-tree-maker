## Overview
This project is a Java application that allows users to input a binary tree in a parenthesized prefix format and then analyze various features of the tree. The tree is built and represented internally, and several properties can be calculated and displayed, including whether the tree is balanced, full, or proper. The project also includes a graphical user interface (GUI) for user interaction.

## Example 1
Given the input (A(G(j)(1))(z(5))), the tree will be constructed as follows:
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
