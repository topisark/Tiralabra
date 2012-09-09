package tiralabra;

class Link {

    public boolean data;
    public Link next;

    public Link(boolean data) {
        this.data = data;
    }
}

public class Linked {

    private Link head;
    private Link tail;
    private int size;

    public Linked() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

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
    
    public boolean poll() {
        boolean temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}
