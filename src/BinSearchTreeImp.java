/**
 * Binary Search Tree
 * 
 * @author Jacob Boyles
 * @version 1.0
 */

public class BinSearchTreeImp implements BinSearchTreeADT {

    /** Root for BST **/
    private BinNode root;
    /** Size of BST **/
    private int size;

    /**
     * Default constructor
     */
    public BinSearchTreeImp() {
        root = null;
        size = 0;
    }
    
    /**
     * Constructor with given root.
     * @param root Given root.
     */
    public BinSearchTreeImp(BinNode root) {
        this.root = root;
        size = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#add(java.lang.Character)
     */
    @Override
    public BinSearchTreeADT add(Character c) {
        root = addHelp(root, c);
        size++;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#countOf(java.lang.Character)
     */
    @Override
    public Integer countOf(Character c) {
        return countOfHelp(root, c);
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#height()
     */
    @Override
    public Integer height() {
        return heightHelp(root);
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#mkFull()
     */
    @Override
    public BinSearchTreeADT mkFull() {
        BinNode a = new BinNode('a');
        BinNode c = new BinNode('c');
        BinNode b = new BinNode('b', a, c);
        BinNode e = new BinNode('e');
        BinNode g = new BinNode('g');
        BinNode f = new BinNode('f', e, g);
        BinNode d = new BinNode('d', b, f);
        BinSearchTreeImp full = new BinSearchTreeImp(d);
        return full;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#preorder()
     */
    @Override
    public String preorder() {
        return preorderHelp(root);
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#remove(java.lang.Character)
     */
    @Override
    public BinSearchTreeADT remove(Character c) {
        root = removeHelp(root, c);
        size--;
        return this;
    }

    /**
     * Method for inserting a value.
     * 
     * @param rt
     *            Root of given tree.
     * @param e
     *            Key for comparing
     * @return Root that was inserted.
     */
    private BinNode addHelp(BinNode rt, Character e) {
        if (rt == null) {
            rt = new BinNode(e);
            return rt;
        }
        if (rt.value().compareTo(e) >= 0) {
            rt.setLeft(addHelp(rt.left(), e));
        }
        else {
            rt.setRight(addHelp(rt.right(), e));
        }
        return rt;
    }

    /**
     * Method to delete the max from the tree.
     * 
     * @param rt
     *            Root of given tree.
     * @return Node that is deleted.
     */
    private BinNode deleteMax(BinNode rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }
    
    /**
     * Get max value in tree.
     * @param rt Given root.
     * @return Max value in tree.
     */
    private BinNode getMax(BinNode rt) {
        if (rt.right() == null) {
            return rt;
        }
        return getMax(rt.right());
    }

    /**
     * Method for removing a value.
     * 
     * @param rt
     *            Root of given tree.
     * @param key
     *            Key for comparing
     * @return Root that was removed
     */
    private BinNode removeHelp(BinNode rt, Character key) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.left(), key));
        }
        else if (rt.value().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.right(), key));
        }
        else {
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else {
                BinNode temp = getMax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    /**
     * Method to implement the countOf method
     * 
     * @param rt
     *            Given root
     * @param c
     *            Given character to compare
     * @return Number of nodes that are less than given node
     */
    private Integer countOfHelp(BinNode rt, Character c) {
        if (rt == null) {
            return 0;
        }

        int countRight = countOfHelp(rt.right(), c);
        int countLeft = countOfHelp(rt.left(), c);


        int compareTo = rt.value().compareTo(c);
        if (compareTo > 0) {
            return 1 + countRight + countLeft;
        }
        else {
            return countLeft + countRight;
        }
    }

    /**
     * Method to help find the height of a tree.
     * 
     * @param rt
     *            Given root.
     * @return Height of tree.
     */
    private Integer heightHelp(BinNode rt) {
        if (rt == null) {
            return 0;
        }
        return 1 + Math.max(heightHelp(rt.left()), heightHelp(rt.right()));
    }

    /**
     * Method to help get the preorder traversal of a tree.
     * 
     * @param rt
     *            Given root.
     * @return Preorder of tree.s
     */
    private String preorderHelp(BinNode rt) {
        String result = "";
        if (rt != null) {
            result += rt.value();
            result += this.preorderHelp(rt.left());
            result += this.preorderHelp(rt.right());
        }
        return result;
    }
    
    /**
     * Getter for tree size.
     * @return Size of tree.
     */
    public int getSize() {
        return size;
    }

}
