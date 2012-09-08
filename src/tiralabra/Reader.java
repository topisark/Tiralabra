package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


//Virheentarkistus?
public class Reader {

    private HashMap<Character, Integer> symbols;
    private FileReader lukija;
    private File handle;
    
    public Reader(File fileHandle) throws FileNotFoundException {
        handle = fileHandle;
        lukija = new FileReader(handle);
    }

    public HashMap<Character, Integer> getSymbols() {
        return symbols;
    }

    public char readCharacter() throws IOException {
        int raw;
        raw = lukija.read();
        if (raw == '\r') {
            raw = lukija.read();
        }
        if (raw != -1) {
            char ch = (char) raw;
            return ch;
        }
        return '\r';
    }

    public void countCharacters() throws IOException, FileNotFoundException {
        int raw;
        int amount;
        symbols = new HashMap<>();
        lukija = new FileReader(handle);
        while ((raw = lukija.read()) != -1) {
            char ch = (char) raw;
            if (ch == '\r') {
                continue;
            }
            if (symbols.containsKey(ch)) {
                amount = symbols.get(ch) + 1;
                symbols.put(ch, amount);
            } else {
                symbols.put(ch, 1);
            }
        }
    }


}
