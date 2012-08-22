package tiralabra;

public class Node implements Comparable{
    
    private int symbol;
    private int weight;
    private Node left;
    private Node right;
    
    public Node(char ch, int i) {
        symbol = ch;
        weight = i;
    }
    
    public Node(Node l, Node r) {
        left = l;
        right = r;
        weight = l.getWeight() + r.getWeight();
    }
    
    public Node getLeft() {
        return left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getSymbol() {
        return symbol;
    }
    
    public boolean isLeaf() {
        return right == null && left == null;
    }

    @Override
    public int compareTo(Object o) {
        int otherAmount = ((Node) o).getWeight();
        return weight - otherAmount;
    }
    
}
