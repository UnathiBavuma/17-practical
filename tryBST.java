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
        // Standard BST insert
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private tNode insertRec(tNode node, int value) {
        if (node == null) return new tNode(value);
        if (value < node.data) node.left = insertRec(node.left, value);
        else if (value > node.data) node.right = insertRec(node.right, value);
        return node;
    }

    // Check if tree is BST
    public boolean isBST() {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRec(tNode node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isBSTRec(node.left, min, node.data) && isBSTRec(node.right, node.data, max);
    }
