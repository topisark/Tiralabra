package tiralabra;

/**
 * Priority queue used for Huffman coding.
 *
 */
public class PriorityQ {

    private Node[] heap;
    private int n;

    /**
     * Constructor for the priority queue
     *
     */
    public PriorityQ() {
        this.heap = new Node[256];
        this.n = 0;
    }

    /**
     * Returns the size of the queue.
     *
     * @return size of the queue
     */
    public int size() {
        return n;
    }

    /**
     * Adds a node to the priority queue.
     *
     * @param node the node to add
     */
    public void add(Node node) {
        int i = n;
        while (i > 0 && heap[parent(i)].getWeight() > node.getWeight()) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = node;
        n++;
    }

    /**
     * Deletes and returns the smallest node.
     *
     * @return the smallest node
     */
    public Node poll() {
        Node smallest = heap[0];
        n--;
        heap[0] = heap[n];
        heapify(0);
        return smallest;
    }

    /**
     * Returns the index of the parent.
     *
     * @param loc the index of the node
     * @return the index of the parent
     */
    private int parent(int loc) {
        return (loc - 1) / 2;
    }

    /**
     * Returns the index of the left child.
     *
     * @param loc the index
     * @return the index of the left child
     */
    private int left(int loc) {
        return 2 * loc + 1;
    }

    /**
     * Returns the index of the right child.
     *
     * @param loc the index
     * @return the index of the right child
     */
    private int right(int loc) {
        return 2 * (loc + 1);
    }

    /**
     * Heapify to keep the queue in priority order.
     *
     * @param i the index of the subtree to order
     */
    private void heapify(int i) {
        int min;
        int left = left(i);
        int right = right(i);

        if (right < n && heap[right].getWeight() < heap[left].getWeight()) {
            min = right;
        } else {
            min = left;
        }

        while (min < n && heap[i].getWeight() > heap[min].getWeight()) {
            Node tmp = heap[i];
            heap[i] = heap[min];
            heap[min] = tmp;
            i = min;
            left = left(i);
            right = right(i);
            if (right < n && heap[right].getWeight() < heap[left].getWeight()) {
                min = right;
            } else {
                min = left;
            }
        }
    }
}
