package tiralabra;

import java.io.*;
import java.util.Scanner;

/**
 * The main class for controlling the Huffman construct.
 *
 */
public class Huffman {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main program. Demonstrates Huffman encoding by encoding and decoding
     * a specified text file and timing the operations.
     *
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Which file to demonstrate Huffpuffing on?");
        System.out.println("The file must be in the project folder");
        String fileName = scanner.nextLine();
        File fileHandle = new File(fileName);
        while (!fileHandle.exists()) {
            System.out.println("File not found");
            System.out.println("Please re-enter the name");
            fileName = scanner.nextLine();
            fileHandle = new File(fileName);
        }

        long encodeStart = System.currentTimeMillis();
        Reader fileReader = new Reader(fileHandle);
        fileReader.countCharacters();
        Tree tree = new Tree(fileReader);
        Writer fileWriter = new Writer(tree, "encoded", fileName);
        fileWriter.writeEncodedText();
        long encodeEnd = System.currentTimeMillis();
        System.out.println("Encoding done: " + (encodeEnd - encodeStart) + " milliseconds");

        long startTime = System.currentTimeMillis();
        fileWriter.decodeText();
        long endTime = System.currentTimeMillis();
        System.out.println("Decoding done: " + (endTime - startTime) + " milliseconds");

        System.out.println("Encoded information saved as encoded and decoded as decoded.txt");
    }
}
