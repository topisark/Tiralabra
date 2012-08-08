package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    Node tree;
    File handle;
    FileOutputStream writer;

    public Writer(Node tree, String filename) throws FileNotFoundException, IOException {
        this.tree = tree;
        handle = new File(filename);
        writer = new FileOutputStream(handle);
        writeCode();
    }

    private void writeCode() throws IOException {
        boolean[] bits = {false, false, false, true, true, false, false, false};
        int data = 0;
        for (int i = 0; i < 8; i++) {
            if (bits[i]) {
                data += (1 << (7-i));
            }
        }
        System.out.println(data);
    }
}
