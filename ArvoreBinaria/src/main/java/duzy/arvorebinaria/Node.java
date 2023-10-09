package duzy.arvorebinaria;

public class Node {
    private Integer data;
    private Node left, right;

    public Node(int item) {
        this.data = item;
        this.left = null;
        this.right = null;
    }
    
   public Node(){
        this.data = null;
        this.left = null;
        this.right = null;
   }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}