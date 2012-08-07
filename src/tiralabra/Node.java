package tiralabra;

public class Node implements Comparable{
    
    private char symbol;
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
    
    public int getWeight() {
        return weight;
    }
    
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int compareTo(Object o) {
        int otherAmount = ((Node) o).getWeight();
        return weight - otherAmount;
    }
    
}
