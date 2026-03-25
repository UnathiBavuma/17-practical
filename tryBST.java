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
    // Delete a node by value
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private tNode deleteRec(tNode node, int value) {
        if (node == null) return null;

        if (value < node.data) node.left = deleteRec(node.left, value);
        else if (value > node.data) node.right = deleteRec(node.right, value);
        else {
            // Node to delete
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Node with two children: Get inorder successor
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private int minValue(tNode node) {
        while (node.left != null) node = node.left;
        return node.data;
    }


