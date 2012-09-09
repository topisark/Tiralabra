package tiralabra;

/**
 * The node used in creating the Huffman tree. Implements Comparable so that the
 * nodes can be placed in order in the priority queue.
 *
 */
public class Node implements Comparable {

    private int symbol;
    private int weight;
    private Node left;
    private Node right;

    /**
     * Creates a new node.
     *
     * @param ch the symbol of the node
     * @param weight the frequency of the node's symbol
     */
    public Node(char ch, int weight) {
        symbol = ch;
        this.weight = weight;
    }

    /**
     * Creates a new node.
     *
     * @param l the left child of the node
     * @param r the right child of the node
     */
    public Node(Node l, Node r) {
        left = l;
        right = r;
        weight = l.getWeight() + r.getWeight();
    }

    /**
     * Returns the left child of a node.
     *
     * @return the left child
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Returns the right child of a node.
     *
     * @return the right child
     */
    public Node getRight() {
        return right;
    }

    /**
     * Returns the weight of a node.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the symbol of a node.
     *
     * @return the symbol
     */
    public int getSymbol() {
        return symbol;
    }

    /**
     * Determines if the node is a leaf.
     *
     * @return true if a leaf, false if not
     */
    public boolean isLeaf() {
        return right == null && left == null;
    }

    /**
     * Compares the weights of nodes.
     *
     * @return the results of the comparison
     */
    @Override
    public int compareTo(Object o) {
        int otherAmount = ((Node) o).getWeight();
        return weight - otherAmount;
    }
}
