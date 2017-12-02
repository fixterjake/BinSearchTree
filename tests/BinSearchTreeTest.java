import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Binary Search Tree JUnit Tests
 * @author Jacob Boyles
 * @version 1.0
 */

public class BinSearchTreeTest {
    
    @Test
    /**
     * Test to make sure if tree is null countOf returns zero.
     */
    public void testCountOfNull() {
        BinSearchTree tree = new BinSearchTree();
        int expected = 0;
        int actual = tree.countOf('a');
        assertEquals(expected, actual);
    }
    
    @Test
    /**
     * Test to check that method returns four
     * when there are four nodes less than given character.
     */
    public void testCountOfFew() {
        BinSearchTree tree = new BinSearchTree();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 4;
        int actual = tree.countOf('a');
        assertEquals( expected, actual);
    }
    
    @Test
    /**
     * Test to check that method returns zero when 
     * no nodes are less than given character.
     */
    public void testCountOfNone() {
        BinSearchTree tree = new BinSearchTree();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 0;
        int actual = tree.countOf('z');
        assertEquals(expected, actual);
    }
    
    @Test
    /**
     * Test height is zero when tree is empty.
     */
    public void heightZero() {
        BinSearchTree tree = new BinSearchTree();
        int expected = 0;
        int actual = tree.height();
        assertEquals(expected, actual);
    }
    
    @Test
    /**
     * Height of default tree.
     */
    public void heightFew() {
        BinSearchTree tree = new BinSearchTree();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 3;
        int actual = tree.height();
        assertEquals(expected, actual);
    }

}
