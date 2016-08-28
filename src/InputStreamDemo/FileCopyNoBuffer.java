/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream Read 1 byte mỗi lần
 *
 * @author CongThanh
 */
public class FileCopyNoBuffer {

    public static void main(String[] args) {
        File fileIn;
        FileInputStream in = null;
        FileOutputStream out = null;
        long startTime, elapsedTime;  // for speed benchmarking

        //Đọc và copy 2 file ảnh
        try {
            fileIn = new File("a.jpg");
            System.out.println("File size is " + fileIn.length() + " bytes");
            in = new FileInputStream(fileIn);
            out = new FileOutputStream("e.jpg");

            startTime = System.nanoTime();
            int byteRead;
            // Read a unsigned byte (0-255) and padded to 32-bit int
            while ((byteRead = in.read()) != -1) {
                // Write the least significant byte, drop the upper 3 bytes
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {       // always close the streams
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
