package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Huffman {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File testiTiedosto = new File("testi.txt");
        Reader testi = new Reader(testiTiedosto);
        Tree koodaaja = new Tree(testi);
        
    }
}
