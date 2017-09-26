package com.es.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class BinaryTree {

    public static void main (String [] args) {

        //int array[] = { 11,3,25,1,5,3,8,9,12,21,5};
        //int array[] = {4,3,2,1,0,9,7,6,8 ,5};
        int array[] = { 4,3,2,1,0,9,8,7,6,5};
        Node root= null;
        for (int i=0; i<array.length; i++) {
            Node n = new Node(array[i]);
            if (root==null) {
                root = n;
            } else {
                root.insert(n);
            }
        }

        System.out.println("Tree balance factor is: " + root.getLevel());

        if (root!=null) {
            System.out.print("\nIn Order: ");
            root.inOrder();
            System.out.print("\nPre Order: ");
            root.preOrder();
            System.out.print("\nPost Order: ");
            root.postOrder();
            System.out.print("\nBFS: ");
            root.bfs();
        }
    }

}


class Node {

    private int data;

    private Node parent;

    private Node left;

    private Node right;

    private int level;


    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.level = 0;
    }


    /**
     * inserts a new node to the tree recursively
     * @param node to add
     * @return the level
     */
    public boolean insert(Node node) {
        //left child
        if (node.data<=this.data) {
            if (this.left==null) {
                this.left = node;
                node.parent = this;
                this.level= this.level -1;
                return Math.abs(this.level)==1;
            } else {

                boolean levelAdded = this.left.insert(node);
                this.level = this.level - (levelAdded?1:0);
                return levelAdded;
            }
        //right child
        } else {
            if (this.right==null) {
                this.right = node;
                node.parent = this;
                this.level= this.level+1;
                return Math.abs(this.level)==1;
            } else {
                boolean levelAdded = this.right.insert(node);
                this.level = this.level + (levelAdded?1:0);
                return levelAdded;
            }
        }
    }


    public void inOrder() {
        if (this.left!=null)
            this.left.inOrder();
        this.visit(this.visitor);
        if (this.right!=null)
            this.right.inOrder();
    }


    public void preOrder() {
        this.visit(this.visitor);
        if (this.left!=null)
            this.left.preOrder();
        if (this.right!=null)
            this.right.preOrder();
    }


    public void postOrder() {
        if (this.left!=null)
            this.left.postOrder();
        if (this.right!=null)
            this.right.postOrder();
        this.visit(this.visitor);
    }


    public void bfs() {
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            n.visit(this.visitor);
            if (n.left!=null)
                queue.add(n.left);
            if (n.right!=null)
                queue.add(n.right);
        }
    }


    private void visit(Consumer<Integer> c) {
        c.accept(this.data);
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLevel() {
        return  this.level;
    }



    private Consumer<Integer> visitor =  i -> System.out.print(i + " ");



}
