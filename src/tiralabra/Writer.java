package tiralabra;

import java.io.*;

/**
 * The class used for writing to files.
 *
 *
 */
public class Writer {

    private String[] codes;
    private File handle;
    private FileOutputStream writer;
    private FileWriter fw;
    private FileInputStream fis;
    private Reader lukija;
    private int tavu, bits;
    private char ch;
    private Tree tree;
    private Linked ll;

    /**
     * Creates a new Writer.
     *
     * @param filename the name of the encoded file
     * @param readFile the name of the file to read from
     * @param tree the tree used to encode data
     *
     */
    public Writer(Tree tree, String filename, String readFile) throws FileNotFoundException, IOException {
        codes = tree.getCodes();
        this.tree = tree;
        handle = new File(filename);
        writer = new FileOutputStream(handle);
        File fileToRead = new File(readFile);
        lukija = new Reader(fileToRead);
        fis = new FileInputStream(handle);
        fw = new FileWriter("decoded.txt");
        ll = new Linked();
    }

    /**
     * Writes the encoded text into a file.
     *
     */
    public void writeEncodedText() throws IOException {
        String code;
        ch = lukija.readCharacter();
        while (ch != '\r') {
            code = codes[ch];
            for (int i = 0; i < code.length(); i++) {
                writeBit(Character.getNumericValue(code.charAt(i)));
            }
            ch = lukija.readCharacter();
            if (ch == '\r') {
            }
        }
        writer.close();
    }

    /**
     * Decodes encoded text.
     *
     */
    public void decodeText() throws IOException {
        Node node = tree.getRoot();
        int read;
        boolean[] bits;
        while (fis.available() > 0) {
            read = fis.read();
            bits = byteToBits(read);
            for (boolean b : bits) {
                ll.add(b);
            }
        }
        while (ll.size() > 0) {
            boolean b;
            while (!node.isLeaf() && ll.size() > 0) {
                b = ll.poll();
                if (b) {
                    node = node.getRight();
                }
                if (!b) {
                    node = node.getLeft();
                }
            }
            if (node.getSymbol() == '\n') {
                fw.write('\r');
                fw.write('\n');
            } else {
                fw.write(node.getSymbol());
            }
            node = tree.getRoot();
        }
        fw.close();
    }

    /**
     * Writes bits one byte at a time.
     *
     */
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

    /**
     * Converts bytes into bit arrays.
     * 
     * @return a boolean array storing bits
     *
     */
    private boolean[] byteToBits(int byteToConvert) {
        if (byteToConvert < 0 || 255 < byteToConvert) {
            throw new IllegalArgumentException();
        }
        boolean[] booleanBits = new boolean[8];
        for (int i = 0; i < 8; i++) {
            booleanBits[i] = ((byteToConvert & (1 << (7 - i))) != 0);
        }
        return booleanBits;
    }
}
