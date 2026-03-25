class tNode {
    int data;
    tNode left, right;

    tNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    tNode root;

    BST() {
        root = null;
    }
