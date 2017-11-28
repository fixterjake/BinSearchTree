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
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#countOf(java.lang.Character)
     */
    @Override
    public Integer countOf(Character c) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#height()
     */
    @Override
    public Integer height() {
        // TODO Auto-generated method stub
        return null;
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
        String result = "";
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see BinSearchTreeADT#remove(java.lang.Character)
     */
    @Override
    public BinSearchTreeADT remove(Character c) {
        // TODO Auto-generated method stub
        return null;
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
    private BinNode insertHelp(BinNode rt, Comparable e) {
        if (rt == null) {
            return new BinNode(e);
        }
        if (rt.value().compareTo(e) >= 0) {
            rt.setLeft(insertHelp(rt.left(), e));
        }
        else {
            rt.setRight(insertHelp(rt.right(), e));
        }
        return rt;
    }
    
    /**
     * Method to delete the max from the tree.
     * @param rt Root of given tree.
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
     * @param rt Root of given tree.
     * @param key Key for comparing
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

}
