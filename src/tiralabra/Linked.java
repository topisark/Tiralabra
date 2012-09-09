package tiralabra;

/**
 * The links used in the linked list.
 *
 */
class Link {

    public boolean data;
    public Link next;

    /**
     * Creates a new link.
     *
     * @param the bit
     *
     */
    public Link(boolean data) {
        this.data = data;
    }
}

/**
 * A singly linked list used to store bits.
 *
 */
public class Linked {

    private Link head;
    private Link tail;
    private int size;

    /**
     * Creates a new linked list.
     *
     */
    public Linked() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     *
     */
    public int size() {
        return size;
    }

    /**
     * Adds a new link to the appropriate place.
     *
     * @param b the bit
     *
     */
    public void add(boolean b) {
        if (head == null) {
            head = tail = new Link(b);
            head.data = b;
            head.next = tail;
            tail = head;
        } else {
            tail.next = new Link(b);
            tail = tail.next;
            tail.data = b;
        }
        size++;
    }

    /**
     * Returns the bit of the first link and removes that link.
     *
     */
    public boolean poll() {
        boolean temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}
