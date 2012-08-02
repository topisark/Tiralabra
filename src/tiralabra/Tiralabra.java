package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;

public class Tiralabra {

    public static void main(String[] args) throws FileNotFoundException {
        File testiTiedosto = new File("testi.txt");
        Reader testi = new Reader(testiTiedosto);
    }
}
