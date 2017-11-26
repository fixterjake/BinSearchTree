/**
 * Binary Search Tree Node
 * @author Jacob Boyles
 * @version 1.0
 */
public class BinNode {
    
    /** Value held in the Node **/
    Object value;
    /** Left Node **/
    BinNode left;
    /** Right Node **/
    BinNode right;
    
    /**
     * Default constructor for BinNode
     * @param value Given value
     */
    public BinNode(Object value) {
        this.value = value;
        left = null;
        right = null;
    }
    
    /**
     * Getter for the left child
     * @return Left node
     */
    public BinNode left() {
        return left;
    }
    
    /**
     * Getter for right child
     * @return Right node
     */
    public BinNode right() {
        return right;
    }
    
    /**
     * Setter for the node value
     * @param v Given value to set
     */
    public void setValue(Object v) {
        this.value = v;
    }
    
    /**
     * Getter for the node value
     * @return Value
     */
    public Object value() {
        return value;
    }
    
    /**
     * Tells if the node is a leaf or not
     * @return True or false depending on if the node is a leaf
     */
    public boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
