package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Huffman {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File testiTiedosto = new File("testi.txt");
        Reader lukija = new Reader(testiTiedosto);
        Tree puu = new Tree(lukija);
        Writer kirjottaja = new Writer(puu.getTree(), "koodattu");
    }
}