/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reader.BufferedReaderDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongThanh
 * Ghi de sau moi lan flush
 */
public class BufferedWriterDemo {
     public static void main(String[] args) throws IOException {
        File file = new File("data.txt");

        try {
            FileWriter fout = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fout);
            String str ="Nguyễn Công Thành";
            for(int i=0; i< 10; i++){
                out.write( i + ". " + str);
                out.newLine();
            }
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(BufferedReaderDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
