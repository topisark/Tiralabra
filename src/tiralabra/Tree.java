package tiralabra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Tree {
    
    private HashMap<Character, Integer> symbols;
    private PriorityQueue<Node> prioq;
    
    public Tree(Reader r) {
        symbols = r.getSymbols();
        prioq = new PriorityQueue<>();
        iterateMap();
        createTree();
    }
    
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
        
    }
    
    private void addToQueue(Node s) {
        prioq.add(s);
    }

    private void iterateMap() {
        Set amountSet = symbols.entrySet();       //Varmaan olis parempiki tapa!
        Iterator iter = amountSet.iterator();
        while (iter.hasNext()) {
            Object object = iter.next();
            String stringRep = object.toString();
            char ch = stringRep.charAt(0);
            stringRep = stringRep.substring(2);            
            int moi = Integer.parseInt(stringRep);            
            Node newNode = new Node(ch, moi);
            addToQueue(newNode);
        }
    }
}
