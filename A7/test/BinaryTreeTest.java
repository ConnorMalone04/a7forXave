import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void insertBST() {
        Collection<Integer> elems;
        BinaryTree<Integer> btree, otree;


        elems = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        btree = BinaryTree.mkBalanced(elems);
        assertTrue(btree.isBalanced());
        assertEquals(4, btree.height());

        TreePrinter.print(btree);

        elems = Arrays.asList(1, 2, 3, 4, 5);
        btree = BinaryTree.mkBalanced(elems);
        otree = BinaryTree.mkBST(elems);

        TreePrinter.print(btree);
        TreePrinter.print(otree);
    }

    @Test
    void mapsum () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        assertEquals(120, TreeTraversals.sum(bst));
        assertEquals(120, TreeTraversals.sum(btree));

        BinaryTree<Integer> mapped = TreeTraversals.map(x -> x * 2, btree);
        BinaryTree<Integer> mappedBST = TreeTraversals.map(x -> x * 2, bst);
        TreePrinter.print(mapped);
        assertEquals(240, TreeTraversals.sum(mappedBST));
        assertEquals(240, TreeTraversals.sum(mapped));

    }

    @Test
    void mul () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        assertEquals(120, TreeTraversals.mul(btree));
        assertEquals(120, TreeTraversals.mul(bst));

        BinaryTree<Integer> mapped = TreeTraversals.map(x -> x * 2, btree);
        BinaryTree<Integer> mappedBST = TreeTraversals.map(x -> x * 2, bst);

        TreePrinter.print(mapped);
        assertEquals(3840, TreeTraversals.mul(mappedBST));
        assertEquals(3840, TreeTraversals.mul(mapped));
    }

    @Test
    void mirror () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        TreePrinter.print(TreeTraversals.mirror(btree));
        List<Integer> l = TreeTraversals.inOrderList(btree);
        List<Integer> r = TreeTraversals.inOrderList(TreeTraversals.mirror(btree));
        List<Integer> lBST = TreeTraversals.inOrderList(bst);
        List<Integer> rBST = TreeTraversals.inOrderList(TreeTraversals.mirror(bst));
        for (int i = 0; i < l.size(); i++) {
            assertEquals(l.get(i), r.get(r.size() - i - 1));
        }
        for (int i = 0; i < lBST.size(); i++) {
            assertEquals(lBST.get(i), rBST.get(rBST.size() - i - 1));
        }
    }

    @Test
    public void testTraversals() {
        BinaryTree<Integer> bst = new EmptyBT<>();
        BinaryTree<Integer> mt = new EmptyBT<>(); // mt = empty

        bst = new NodeBT(1,
                new NodeBT(5,
                        new NodeBT(4, mt,mt),
                        new NodeBT(2,mt,mt)),
                new NodeBT(3,
                        new NodeBT(6, mt,mt),
                        new NodeBT(7,mt,mt)));
        /*

                1
              /   \
             5     3
            / \   / \
           4   2 6   7

         */
        ArrayList<Integer> preOrder = new ArrayList<>(){{
            add(1); add(5); add(4); add(2); add(3); add(6); add(7);
        }};
        ArrayList<Integer> inOrder = new ArrayList<>(){{
            add(4); add(5); add(2); add(1); add(6); add(3); add(7);
        }};
        ArrayList<Integer> postOrder = new ArrayList<>(){{
            add(4); add(2); add(5); add(6); add(7); add(3); add(1);
        }};
        ArrayList<Integer> breadthFirstOrder= new ArrayList<>(){{
            add(1); add(5); add(3); add(4); add(2); add(6); add(7);
        }};
        TreePrinter.print(bst);

        assertEquals(preOrder, TreeTraversals.preOrderList(bst));
        assertEquals(inOrder, TreeTraversals.inOrderList(bst));
        assertEquals(postOrder, TreeTraversals.postOrderList(bst));
        assertEquals(breadthFirstOrder, TreeTraversals.breadthFirstList(bst));
    }

}