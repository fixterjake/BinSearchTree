/**
 * Binary Search Tree Node
 * @author Jacob Boyles
 * @version 1.0
 */
public class BinNode {
    
    /** Value held in the Node **/
    private Character value;
    /** Left Node **/
    private BinNode left;
    /** Right Node **/
    private BinNode right;
    
    /**
     * Default constructor.
     */
    public BinNode() {
        left = null;
        right = null;
    }
    
    /**
     * Constructor with value param.
     * @param value Given value
     */
    public BinNode(Character value) {
        left = null;
        right = null;
        this.value = value;
    }
    
    /**
     * Constructor with value, left, and right param.
     * @param value Given vlaue.
     * @param left Given left child.
     * @param right Given right child.
     */
    public BinNode(Character value, BinNode left, BinNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
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
    public void setValue(Character v) {
        this.value = v;
    }
    
    /**
     * Set the left node.
     * @param left Given left node.
     */
    public void setLeft(BinNode left) {
        this.left = left;
    }
    
    /**
     * Set the right node.
     * @param right Given right node.
     */
    public void setRight(BinNode right) {
        this.right = right;
    }
    
    /**
     * Getter for the node value
     * @return Value
     */
    public Character value() {
        return value;
    }
    
    /**
     * Tells if the node is a leaf or not
     * @return True or false depending on if the node is a leaf
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
