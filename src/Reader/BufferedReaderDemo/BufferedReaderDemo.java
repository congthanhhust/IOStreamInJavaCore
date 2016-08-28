/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reader.BufferedReaderDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class reads text from a character-input stream
 * Đọc được tiêng việt UTF-8
 * Read Char: Elapsed Time is 22.222905 msec.
 * Read Line: Elapsed Time is 1.131092 msec
 * @author CongThanh
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        long startTime, elapsedTime;  // for speed benchmarking
        File file = new File("data.txt");

        try {
            FileReader fin = new FileReader(file);
            BufferedReader in = new BufferedReader(fin);
            String str;
            int c;
            startTime = System.nanoTime();
            
            /* Đọc theo từng ký tự
            while((c = in.read())!=-1){
                System.out.print((char)c);
            }
            */
            
            //Đọc theo từng dòng
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("\nElapsed Time is " + (elapsedTime / 1000000.0) + " msec");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(BufferedReaderDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
