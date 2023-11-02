import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceTest {

    @Test
    public void testInsertingSortedNumbersInBST() {
        /* 1. Create a list of 10000 sorted numbers. */
        List<Integer> sortedNumbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            sortedNumbers.add(i);
        }
        /* 2. Create an empty BST. */
        BinaryTree<Integer> bst = new EmptyBT<>();
        /* 3. Insert the numbers in the BST. */
        for (int i = 0; i < 1000; i++) {
            bst = bst.insertBST(i);
        }
        /* 4. Measure the time it takes to insert the numbers. */
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bst = bst.insertBST(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("BST: " + duration);
    }

    @Test
    public void testInsertingSortedNumbersInBBT() {

        BinaryTree<Integer> bbt = new EmptyBT<>();


        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bbt = bbt.insertBalanced(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("BST: " + duration);
    }

    @Test
    public void testRandomNumbersInBST() {
        BinaryTree<Integer> bst = new EmptyBT<>();

        Random rand = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            i = rand.nextInt(1000);
            bst = bst.insertBST(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("BST: " + duration);

    }

    @Test
    public void testRandomNumbersInBBT() {
        BinaryTree<Integer> bbt = new EmptyBT<>();

        Random rand = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            i = rand.nextInt(1000);
            bbt = bbt.insertBalanced(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("BST: " + duration);
    }
    @Test
    public void testFindingNumbersInBST() {
        BinaryTree<Integer> bst = new EmptyBT<>();

        for (int i = 0; i < 1000; i++) {
            bst = bst.insertBST(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bst.findBST(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("BST: " + duration);
    }

}