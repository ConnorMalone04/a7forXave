public class NodeBT<E extends Comparable<E>> extends BinaryTree<E> {
    private final E data;
    private final BinaryTree<E> left, right;
    private final int height;

    NodeBT (E data, BinaryTree<E> left, BinaryTree<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = Math.max(left.height(), right.height()) + 1;
    }

    // Access fields

    E getData () { return data; }
    BinaryTree<E> getLeftBT () { return left; }
    BinaryTree<E> getRightBT () { return right; }

    // Basic properties

    boolean isEmpty () { return false; }
    int height() { return height; }
    boolean isBalanced() { return Math.abs(left.height() - right.height()) < 2; }

    // Basic insert

    BinaryTree<E> insertBalanced(E elem) {
        /*
        /////// THIS WORKS I JUST WANTED THE SIMPLER ANSWER
        int dir = data.compareTo(elem);
        if (dir > 0) {
            if (left.height() < right.height()) {
                return new NodeBT<E>(data, left.insertBalanced(elem), right);
            }
            else {

                return new NodeBT<E>(data, right.insertBalanced(elem), left);
            }
        }
        else {
            if (right.height() < left.height()) {
                return new NodeBT<E>(data, left, right.insertBalanced(elem));
            }
            else {

                return new NodeBT<E>(data, right, left.insertBalanced(elem));
            }
        }*/

        return new NodeBT<E>(data, right, left.insertBalanced(elem));


    }

    // BST insertions, lookups, and deletions

    public BinaryTree<E> insertBST(E elem) {
        if (data.compareTo(elem) > 0) {
            return new NodeBT<>(data, left.insertBST(elem),right);
        }
        else {
            return new NodeBT<>(data, left, right.insertBST(elem));
        }
    }

    public boolean findBST(E elem) {
        if (data.compareTo(elem) == 0) {
            return true;
        }
        else if (data.compareTo(elem) == -1) {
            return left.findBST(elem);
        }
        else {
            return right.findBST(elem);
        }
    }

    // Printable interface

    public TreePrinter.PrintableNode getLeft() { return left.isEmpty() ? null : left; }
    public TreePrinter.PrintableNode getRight() { return right.isEmpty() ? null : right; }
    public String getText() { return String.valueOf(data); }

}

