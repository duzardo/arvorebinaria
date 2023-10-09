package duzy.arvorebinaria;

import java.util.Random;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node insertRec(Node root, Integer data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    public void insert(Integer data) {
        root = insertRec(root, data);
    }

    public Node removeRec(Node root, int data) {
        if (root == null) return root;

        if (data < root.getData()) {
            root.setLeft(removeRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(removeRec(root.getRight(), data));
        } else {
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();

            root.setData(minValue(root.getRight()));
            root.setRight(removeRec(root.getRight(), root.getData()));
        }
        return root;
    }

    public int minValue(Node root) {
        int minValue = root.getData();
        while (root.getLeft() != null) {
            minValue = root.getLeft().getData();
            root = root.getLeft();
        }
        return minValue;
    }

    public void remove(int data) {
        root = removeRec(root, data);
    }

    public Node search(Node root, int data) {
        if (root == null || root.getData() == data) return root;
        if (root.getData() > data) return search(root.getLeft(), data);
        return search(root.getRight(), data);
    }

    public boolean contains(int data) {
        return search(root, data) != null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}