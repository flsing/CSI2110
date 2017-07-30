/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * Test class for tree traversal lab
 * @author Lachlan Plant
 */
public class TestTree {
    
    
    public static void testPreorder(LinkedBinarySearchTree<Integer> tree, String expected){
        System.out.println("Expected Result: "+expected);
        tree.printPreorderRecursive();
        System.out.println();
        System.out.print("Preorder Printing with Iterator: ");
        Iterator i = tree.preorderIterator();
        while(i.hasNext()){
            System.out.print(i.next().toString()+", ");
        }
        System.out.println();
        System.out.print("Printing First 5 Elements: ");
        i = tree.preorderIterator();
        for(int j = 0; j < 5; j++){
            System.out.print(i.next().toString()+", ");
        }
        System.out.println();
    }


    
    public static void testInorder(LinkedBinarySearchTree<Integer> tree, String expected){
        System.out.println("Expected Result: "+expected);
        tree.printInorderRecursive();
        System.out.println();
        System.out.print("Inorder Printing with Iterator: ");
        Iterator i = tree.inorderIterator();
        while(i.hasNext()){
            System.out.print(i.next().toString()+", ");
        }
        System.out.println();
        System.out.print("Inorder Printing with For Each Loop: ");
        for(Integer e: tree){
            System.out.print(e.toString()+", ");
        }
        System.out.println();
    }   
    
    public static void testPostorder(LinkedBinarySearchTree<Integer> tree, String expected){
        System.out.println("Expected Result: "+expected);
        tree.printPostorderRecursive();
        System.out.println();
    }
    
    public static void main(String[] args){
        System.out.println("Testing binary search tree printing");
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
        int[] temp = {3,5,7,1,4,2,51,17,43,28,47,89,6};
        for(int i = 0; i< temp.length;i++){
            tree.add(temp[i]);
        }
        testPreorder(tree,"3, 1, 2, 5, 4, 7, 6, 51, 17, 43, 28, 47, 89,");
        System.out.println();
        testInorder(tree,"1, 2, 3, 4, 5, 6, 7, 17, 28, 43, 47, 51, 89,");
        System.out.println();
        testPostorder(tree,"2, 1, 4, 6, 28, 47, 43, 17, 89, 51, 7, 5, 3,");
    }
}
