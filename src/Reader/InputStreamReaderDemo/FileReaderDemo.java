/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reader.InputStreamReaderDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ví dụ về FileReader và FileWriter
 * @author CongThanh
 */
public class FileReaderDemo {

    public static void main(String[] args) throws IOException {
        long startTime, elapsedTime;  // for speed benchmarking
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("data.txt");
            outputStream = new FileWriter("datacopy.txt");
            int c;
            startTime = System.nanoTime();
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
                outputStream.write(c);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("\nElapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
