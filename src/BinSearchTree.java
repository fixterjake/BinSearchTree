/**
 * Binary Search Tree
 * 
 * @author Jacob Boyles
 * @version 1.0
 */

public class BinSearchTree implements BinSearchTreeADT {

    /** Root for BST **/
    private BinNode root;
    /** Size of BST **/
    private int size;

    /**
     * Default constructor
     */
    public BinSearchTree() {
        root = null;
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
        // TODO Auto-generated method stub
        return null;
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
        Comparable temp = findHelp(root, c);
        if (temp != null) {
            root = removeHelp(root, c);
        }
        size--;
        return this;
    }

    /**
     * Method for finding a value.
     * 
     * @param rt
     *            Root of given tree.
     * @param key
     *            Key for comparing.
     * @return The value if found.
     */
    private Comparable findHelp(BinNode rt, Comparable key) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            return findHelp(rt.left(), key);
        }
        else if (rt.value().compareTo(key) == 0) {
            return rt.value();
        }
        else {
            return findHelp(rt.right(), key);
        }

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
    private BinNode addHelp(BinNode rt, Comparable e) {
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
    private BinNode removeHelp(BinNode rt, Comparable key) {
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

        if (rt.value().compareTo(c) > 0) {
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
        if (rt == null) {
            return "";
        }
        result += root.value();
        preorderHelp(rt.left());
        preorderHelp(rt.right());

        return result;
    }

}
