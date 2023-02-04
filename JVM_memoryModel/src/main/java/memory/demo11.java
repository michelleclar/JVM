package memory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JVM
 * @description: string.intern
 * @author: Mr.Carl
 **/
public class demo11 {
    //-XX:StringTableSize=200000 -XX:+PrintStringTableStatistics
    //-Xsx500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=200000

    public static void main(String[] args) throws IOException {

        List<String> address = new ArrayList<>();
        System.in.read();
        for (int i = 0; i < 10; i++) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\idea-project\\workspaces\\JVM\\JVM_memoryModel\\src\\main\\resources\\linux.words"), "utf-8"))) {
                String line = null;
                long start = System.nanoTime();
                while (true) {
                    line = reader.readLine();
                    if(line == null) {
                        break;
                    }
                    address.add(line);
                }
                System.out.println("cost:" +(System.nanoTime()-start)/1000000);
            }
        }
        System.in.read();


    }
}
