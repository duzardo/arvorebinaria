package duzy.arvorebinaria;

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode N) {
        if (N == null) return 0;
        return N.getHeight();
    }

    public int max(int a, int b) {
        if (a > b){
            return a;
        }
        else {
            return b;
        }
    }

    public AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    public AVLNode insert(AVLNode node, int data) {
        if (node == null) return new AVLNode(data);

        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        } else return node;

        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && data < node.getLeft().getData()) return rightRotate(node);
        if (balance < -1 && data > node.getRight().getData()) return leftRotate(node);
        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public AVLNode deleteNode(AVLNode root, int data) {
        if (root == null) return root;

        if (data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLNode temp = null;
                if (temp == root.getLeft()) temp = root.getRight();
                else temp = root.getLeft();

                if (temp == null) {
                    temp = root;
                    root = null;
                } else root = temp;
            } else {
                AVLNode temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNode(root.getRight(), temp.getData()));
            }
        }

        if (root == null) return root;

        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight())));

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft()) >= 0) return rightRotate(root);
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.getRight()) <= 0) return leftRotate(root);
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }

    public AVLNode search(AVLNode root, int data) {
        if (root == null || root.getData() == data) return root;
        if (root.getData() > data) return search(root.getLeft(), data);
        return search(root.getRight(), data);
    }

    public boolean contains(int data) {
        return search(root, data) != null;
    }

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }
}