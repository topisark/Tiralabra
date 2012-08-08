package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Virheentarkistus?
public class Reader {

    private HashMap<Character, Integer> symbols;

    public Reader(File fileHandle) throws FileNotFoundException, IOException {
        int raw;
        int amount;
        symbols = new HashMap<>();
        FileReader lukija = new FileReader("testi.txt");
        while ((raw = lukija.read()) != -1) {
            char ch = (char) raw;
            if (symbols.containsKey(ch)) {
                amount = symbols.get(ch) + 1;
                symbols.put(ch, amount);
            } else {
                symbols.put(ch, 1);
            }
        }
    }

    public HashMap<Character, Integer> getSymbols() {
        return symbols;
    }
}
