package tiralabra;

import java.io.*;
import java.util.HashMap;

/**
 * The class used for reading a file.
 *
 */
public class Reader {

    private HashMap<Character, Integer> symbols;
    private FileReader lukija;
    private File handle;

    /**
     * Creates a new Reader.
     *
     * @param fileHandle the file to read
     */
    public Reader(File fileHandle) throws FileNotFoundException {
        handle = fileHandle;
        lukija = new FileReader(handle);
    }

    public HashMap<Character, Integer> getSymbols() {
        return symbols;
    }

    /**
     * Reads a single character and returns it. Some weirdness due to Windows'
     * newline char but should function correctly.
     *
     */
    public char readCharacter() throws IOException {
        int raw;
        raw = lukija.read();
        if (raw == '\r') {
            raw = lukija.read();
        }
        if (raw != -1) {
            char ch = (char) raw;
            return ch;
        } else {
            return '\r';
        }

    }

    /**
     * Puts the symbols with their frequencies into a hashmap.
     *
     */
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
