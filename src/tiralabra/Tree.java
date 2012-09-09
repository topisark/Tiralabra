package tiralabra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * The tree used in Huffman coding.
 *
 */
public class Tree {

    private HashMap<Character, Integer> symbols;
    private PriorityQ prioq;
    private String[] codes;
    private Node root;

    /**
     * Creates a new tree.
     *
     * @param r the reader to use
     */
    public Tree(Reader r) {
        symbols = r.getSymbols();
        prioq = new PriorityQ();
        iterateMap();
        createTree();
    }

    /**
     * Returns the root of the tree.
     *
     * @return the root of the tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Finds Huffman codes for the symbols
     *
     * @return Huffman codes of the symbols
     */
    public String[] getCodes() {
        codes = new String[256];

        if (root != null) {
            if (root.isLeaf()) {
                codes[root.getSymbol()] = "0";
            } else {
                traverse(root, "");
            }
        }

        return codes;
    }

    /**
     * Creates the tree by combining nodes.
     *
     */
    private void createTree() {
        if (prioq.size() == 0) {
            System.out.println("No nodes in priority queue.");
            System.exit(0);
        }
        while (prioq.size() > 1) {
            Node left = prioq.poll();
            Node right = prioq.poll();
            Node combined = new Node(left, right);
            prioq.add(combined);
        }
        System.out.println("Tree constructed.");
        root = prioq.poll();
    }

    /**
     * Adds a node to the priority queue.
     *
     */
    private void addToQueue(Node s) {
        prioq.add(s);
    }

    /**
     * Iterates the map.
     *
     */
    private void iterateMap() {
        Set amountSet = symbols.entrySet();
        Iterator iter = amountSet.iterator();
        while (iter.hasNext()) {
            Object object = iter.next();
            String stringRep = object.toString();
            char ch = stringRep.charAt(0);
            stringRep = stringRep.substring(2);
            int num = Integer.parseInt(stringRep);
            Node newNode = new Node(ch, num);
            addToQueue(newNode);
        }
    }

    /**
     * Recursively obtains the Huffman code.
     *
     * @param koodi the Huffman code
     * @param root the root of the current tree
     */
    private void traverse(Node root, String koodi) {
        if (root.isLeaf()) {
            codes[root.getSymbol()] = koodi;
        } else {
            if (root.getLeft() != null) {
                traverse(root.getLeft(), koodi + "0");
            }
            if (root.getRight() != null) {
                traverse(root.getRight(), koodi + "1");
            }
        }
    }
}
