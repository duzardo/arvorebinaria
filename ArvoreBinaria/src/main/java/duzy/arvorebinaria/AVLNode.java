package duzy.arvorebinaria;

public class AVLNode {
    private int data, height;
    private AVLNode left, right;

    public AVLNode(int d) {
        this.data = d;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public int getHeight() {
        return height;
    }

    public AVLNode getLeft() {
        return left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }
}