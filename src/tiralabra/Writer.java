package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.LinkedList;

public class Writer {

    private String[] codes;
    private File handle;
    private FileOutputStream writer;
    private FileWriter fw;
    private FileInputStream fis;
    private Reader lukija;
    private int tavu;
    private int bits;
    private char ch;
    private Tree tree;
    private LinkedList<Boolean> ll;

    public Writer(Tree tree, String filename) throws FileNotFoundException, IOException {
        codes = tree.getCodes();
        this.tree = tree;
        handle = new File(filename);
        writer = new FileOutputStream(handle);
        File fileToRead = new File("testi.txt");
        lukija = new Reader(fileToRead);
        fis = new FileInputStream(handle);
        fw = new FileWriter("decoded.txt");
        ll = new LinkedList<>();
    }

    public void writeEncodedText() throws IOException {
        String code;
        ch = lukija.readCharacter();
        while (ch != '\r') {
            //System.out.print(ch);
            code = codes[ch];
            //System.out.println(ch);
            //System.out.println(code);
            for (int i = 0; i < code.length(); i++) {
                //System.out.println(Character.getNumericValue(code.charAt(i)));
                writeBit(Character.getNumericValue(code.charAt(i)));
            }
            ch = lukija.readCharacter();
            // System.out.println(ch);
        }
        System.out.println("Encoding done.");
        writer.close();
    }

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
                    //  System.out.println("Right!");
                }
                if (!b) {
                    node = node.getLeft();
                    //  System.out.println("Left!");
                }                
            }
            fw.write(node.getSymbol());
            System.out.println(node.getSymbol());
            node = tree.getRoot();
        }
        System.out.println("Decoding done.");
        fw.close();
    }

    private void writeBit(int bit) throws IOException {
        tavu <<= 1;
        if (bit == 1) {
            tavu |= 1;
        }
        bits++;
        if (bits == 8) {
            writer.write(tavu);
            //System.out.println("Kirjotan:" + tavu);
            tavu = 0;
            bits = 0;
        }
    }

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
