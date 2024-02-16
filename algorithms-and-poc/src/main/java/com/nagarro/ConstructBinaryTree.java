package com.nagarro;

import java.util.Arrays;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {2,1,3,4};
        int[] inorder = {1,2,3,4};
        TreeNode head = ConstructBinaryTree.buildTree(preorder,inorder);
        printTree(head);
    }

    public static void printTree(TreeNode node) {
        if(node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder[0], preorder, inorder);
    }

    private static TreeNode buildNode(int nodeValue, int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(nodeValue);
        int i = 0;
        while (inorder[i] != nodeValue) {
            i++;
        }
        int[] leftArray = Arrays.copyOfRange(inorder, 0, i);
        int[] rightArray = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        if (leftArray.length == 1) {
            node.left = new TreeNode(leftArray[0]);
        }
        else {
            if (leftArray.length != 0) {
                int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + leftArray.length);
                node.left = leftPreOrder.length != 0 ? buildNode(leftPreOrder[0], leftPreOrder, leftArray) : null;
            }
        }
        if (rightArray.length == 1) {
            node.right = new TreeNode(rightArray[0]);
        }
        else {
            if (rightArray.length != 0) {
                int[] rightPreOrder = Arrays.copyOfRange(preorder, leftArray.length + 1, preorder.length);
                node.right = rightPreOrder.length != 0 ? buildNode(rightPreOrder[0], rightPreOrder, rightArray) : null;
            }
        }
        return node;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
