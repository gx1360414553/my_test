package com.gx.binaryTree;

public class BinaryTree {
    private BinaryTreeNode root;

    //初始化二叉树
    public BinaryTree(){}

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    /**
     * 二叉树的清空：
     * 首先提供一个清空以某个节点为根节点的子树的方法，既递归地删除每个节点；
     * 接着提供一个删除树的方法，直接通过第一种方法删除到根节点即可
     */
    //清除某个子树的所有节点
    public void clear(BinaryTreeNode node){
        if(node!=null){
            clear(node.getLeftChirld());
            clear(node.getRightChirld());
            node = null; //删除节点
        }
    }
    //清空树
    public void clear(){
        clear(root);
    }

    //判断二叉树是否为空
    public boolean isEmpty(){
        return root == null;
    }

}
