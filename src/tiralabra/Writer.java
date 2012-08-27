package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    private String[] codes;
    private File handle;
    private FileOutputStream writer;
    private Reader lukija;
    private int tavu;
    private int bits;
    private char ch;

    public Writer(Tree tree, String filename) throws FileNotFoundException, IOException {
        codes = tree.getCodes();
        handle = new File(filename);
        writer = new FileOutputStream(handle);
        File fileToRead = new File("testi.txt");
        lukija = new Reader(fileToRead);
    }

    public void write() throws IOException {
        String code;
        ch = lukija.readCharacter();
        while (ch != '\r') {
            //System.out.print(ch);
            code = codes[ch];
            for (int i = 0; i < code.length(); i++) {
                writeBit((int) code.charAt(i));
            }
            ch = lukija.readCharacter();
        }
        System.out.println("Encoding done.");
    }

    private void writeBit(int bit) throws IOException {
        tavu <<= 1;
        if (bit == 1) {
            tavu |= 1;
        }
        bits++;
        if (bits == 8) {
            writer.write(tavu);
            tavu = 0;
            bits = 0;
        }
    }

    private int bitsToInt() throws IOException {
        boolean[] bits = {false, false, false, true, true, false, false, false};
        int data = 0;
        for (int i = 0; i < 8; i++) {
            if (bits[i]) {
                data += (1 << (7 - i));
            }
        }
        return data;
    }
}
