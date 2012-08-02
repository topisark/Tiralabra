package tiralabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

//Virheentarkistus?
public class Reader {

    private HashMap<String, Integer> symbols;

    public Reader(File fileHandle) throws FileNotFoundException, IOException {
        int raw;
        FileReader lukija = new FileReader("testi.txt");
        while ((raw = lukija.read()) != -1) {
            char ch = (char) raw;
            System.out.println(ch);
        }
        
        
        
        
        
        
        
    }
//        int amount;
//        String symbol;
//        Scanner fileReader = new Scanner(fileHandle);
//        while (fileReader.hasNext()) {
//            symbol = fileReader.next();
//            System.out.println(symbol);
//            if (symbols.containsKey(symbol)) {
//                amount = symbols.get(symbol);
//                symbols.put(symbol, amount + 1);
//            } else {
//                symbols.put(symbol, 1);
//            }
//        }
//        System.out.println(symbols.toString());
//    }
}
