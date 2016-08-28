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
 * Đọc theo từng mảng byte
 * @author CongThanh
 */
public class FileCopyUserBuffer {

    public static void main(String[] args) {
        File fileIn;
        FileInputStream in = null;
        FileOutputStream out = null;
        long startTime, elapsedTime;  // for speed benchmarking

        try {
            fileIn = new File("a.jpg");
            System.out.println("File size is " + fileIn.length() + " bytes");
            in = new FileInputStream(fileIn);
            out = new FileOutputStream("e.jpg");
            
            int[] bufSizeKB = {1, 2, 4, 8, 16, 32, 64, 256, 1024};  // in KB
            int bufSize;
            int numBytesRead;
            for (int run = 0; run < bufSizeKB.length; run++) {
                startTime = System.nanoTime();
                bufSize = bufSizeKB[run] * 1024;
                byte[] byteBuf = new byte[bufSize]; // 4K buffer     
                //your code
                while ((numBytesRead = in.read(byteBuf)) != -1) {
                    out.write(byteBuf, 0, numBytesRead);
                }
                elapsedTime = System.nanoTime() - startTime;
                System.out.format("%4dKB: ", bufSizeKB[run]);
                System.out.println((elapsedTime / 1000.0) + " nsec");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {            // always close the streams
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
