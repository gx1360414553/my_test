package com.gx.tree;

public class TreeMain {
    static boolean isBalanced = true;
    public static void main(String[] args) {
        //求树的最大深度
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(1);
        TreeNode node14 = new TreeNode(1);
        TreeNode node15 = new TreeNode(1);
        TreeNode node16 = new TreeNode(1);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;
        node5.left = node11;
        node5.right = node12;
        node6.left = node13;
        node6.right = node14;

        node7.left = node15;
        node8.right = node16;

        int treeDepth = treeDepth(root);
        System.out.println("树的深度：" + treeDepth);
        boolean isBalanced_solution = IsBalanced_Solution(root);
        System.out.println("isBalanced_solution = " + isBalanced_solution);
    }

    //树的深度
    public static int treeDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(treeDepth(node.left), treeDepth(node.right) + 1);
    }

    //是否为平衡树
    public static boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public static int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        System.out.println("right = " + right);
        System.out.println("left = " + left);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;

    }
}
