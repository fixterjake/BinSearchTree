import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Binary Search Tree JUnit Tests
 * @author Jacob Boyles
 * @version 1.0
 */

public class BinSearchTreeTest {
    
    /**
     * Test to make sure if tree is null countOf returns zero.
     */
    @Test
    public void testCountOfNull() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        int expected = 0;
        int actual = tree.countOf('a');
        assertEquals(expected, actual);
    }
    
    /**
     * Test to check that method returns four
     * when there are four nodes less than given character.
     */
    @Test
    public void testCountOfFew() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 4;
        int actual = tree.countOf('a');
        assertEquals( expected, actual);
    }

    /**
     * Test to check that method returns zero when 
     * no nodes are less than given character.
     */
    @Test
    public void testCountOfNone() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 0;
        int actual = tree.countOf('z');
        assertEquals(expected, actual);
    }
    
    /**
     * Test height is zero when tree is empty.
     */
    @Test
    public void testHeightZero() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        int expected = 0;
        int actual = tree.height();
        assertEquals(expected, actual);
    }
    
    /**
     * Height of default tree.
     */
    @Test
    public void testHeightFew() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree.add('d').add('b').add('a').add('c').add('f');
        int expected = 3;
        int actual = tree.height();
        assertEquals(expected, actual);
    }
    /**
     * Test for preorder.
     */
    @Test
    public void testPreorder() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree = (BinSearchTreeImp) tree.mkFull();
        String expected = "dbacfeg";
        String actual = tree.preorder();
        assertEquals(expected, actual);
    }
    
    /**
     * Test for mkFull.
     */
    @Test
    public void testMkFull() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree = (BinSearchTreeImp) tree.mkFull();
        BinSearchTreeImp treeTwo = new BinSearchTreeImp();
        treeTwo = (BinSearchTreeImp) tree.mkFull();
        String expected = tree.preorder();
        String actual = treeTwo.preorder();
        assertEquals(expected, actual);
    }
    
    /**
     * Test for a few BinNode methods
     */
    @Test
    public void testBinNode() {
        BinNode empty = new BinNode();
        assertNull(empty.value());
        BinNode lLeaf = new BinNode('b');
        BinNode rLeaf = new BinNode('c');
        BinNode root = new BinNode('a', rLeaf, rLeaf);
        assertTrue(lLeaf.isLeaf());
        assertTrue(rLeaf.isLeaf());
        assertFalse(root.isLeaf());
    }

    /**
     * Test removing the root of a tree.
     */
    @Test
    public void testRemoveSingleNode() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree.add('a');
        tree.remove('a');
        int expected = 0;
        assertEquals(expected, tree.getSize());
    }
    
    /**
     * Test removing a few nodes.
     */
    @Test
    public void testRemoveFewNodes() {
        BinSearchTreeImp tree = new BinSearchTreeImp();
        tree.add('d').add('b').add('a').add('c').add('f');
        tree.remove('a').remove('c').remove('f');
        int expected = 2;
        assertEquals(expected, tree.getSize());
    }
    
}
