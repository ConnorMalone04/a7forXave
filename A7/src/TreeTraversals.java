import java.util.*;
import java.util.function.Function;

public class TreeTraversals {

    static <E extends Comparable<E>> List<E> preOrderList(BinaryTree<E> tree) {
        List<E> list = new ArrayList<>();

        // Visit Root
        try {
            list.add(tree.getData());
        } catch (EmptyTreeE e) {
            return list;
        }

        // Visit Left
        try {
            list.addAll(preOrderList(tree.getLeftBT()));
        } catch (EmptyTreeE e) {
            throw new RuntimeException(e);
        }

        // Visit Right
        try {
            list.addAll(preOrderList(tree.getRightBT()));
        } catch (EmptyTreeE e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    static <E extends Comparable<E>> List<E> inOrderList(BinaryTree<E> tree) {
        List<E> list = new ArrayList<>();

        if (tree.isEmpty()) {
            return list;
        }
        // Visit Left
        try {
            list.addAll(inOrderList(tree.getLeftBT()));
        } catch (EmptyTreeE e) {
            return list;
        }

        // Visit Root
        try {
            list.add(tree.getData());
        } catch (EmptyTreeE e) {
            return list;
        }

        // Visit Right
        try {
            list.addAll(inOrderList(tree.getRightBT()));
        } catch (EmptyTreeE e) {
            return list;
        }
        return list;
    }

    static <E extends Comparable<E>> List<E> postOrderList(BinaryTree<E> tree) {
        List<E> list = new ArrayList<>();

        if (tree.isEmpty()) {
            return list;
        }
        // Visit Left
        try {
            list.addAll(postOrderList(tree.getLeftBT()));
        } catch (EmptyTreeE ignored) {}

        // Visit Right
        try {
            list.addAll(postOrderList(tree.getRightBT()));
        } catch (EmptyTreeE ignored) {
        }
        // Visit Root
        try {
            list.add(tree.getData());
        } catch (EmptyTreeE e) {
            return list;
        }
        return list;
    }

    static <E extends Comparable<E>> List<E> breadthFirstList (BinaryTree<E> tree) {
        List<E> list = new ArrayList<>();

        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {

            BinaryTree<E> tempNode = queue.poll();
            try {
                list.add(tempNode.getData());
            } catch (EmptyTreeE e) {
                continue;
            }

            // Enqueue left child
            try {
                queue.add(tempNode.getLeftBT());
            } catch (EmptyTreeE ignored) {
            }

            // Enqueue right child
            try {
                queue.add(tempNode.getRightBT());
            } catch (EmptyTreeE ignored) {
            }
        }
        return list;

    }

    static <E extends Comparable<E>, F extends Comparable<F>> BinaryTree<F>
    map (Function<E,F> f, BinaryTree<E> tree) {
        try {
            return new NodeBT<>(f.apply(tree.getData()),
                    map(f, tree.getLeftBT()),
                    map(f, tree.getRightBT()));
        } catch (EmptyTreeE e) {
                return new EmptyBT<>();
        }
    }

    static int sum (BinaryTree<Integer> tree) {
        try {
            int leftSum = sum(tree.getLeftBT());
            int rightSum = sum(tree.getRightBT());
            return tree.getData() + leftSum + rightSum;
        } catch (EmptyTreeE e) {
            return 0;
        }
    }

    static int mul (BinaryTree<Integer> tree) {
        try {
            int leftMul = mul(tree.getLeftBT());
            int rightMul = mul(tree.getRightBT());
            return tree.getData() * leftMul * rightMul;
        } catch (EmptyTreeE e) {
            return 1;
        }
    }
    static <E extends Comparable<E>> BinaryTree<E> mirror (BinaryTree<E> tree) {
        if (tree.isEmpty()) return tree;

        BinaryTree<E> newTree = new EmptyBT<>();
        try {
            newTree = new NodeBT<>(tree.getData(),mirror(tree.getRightBT()),mirror(tree.getLeftBT()));
        } catch (EmptyTreeE e) {
        }
        return newTree;
    }
}
