/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputStreamDemo.FilterInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @author CongThanh
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        File fileIn;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        long startTime, elapsedTime;  // for speed benchmarking

        //Đọc theo từng byte
        try {
            fileIn = new File("a.jpg");
            System.out.println("File size is " + fileIn.length() + " bytes");
            in = new BufferedInputStream(new FileInputStream(fileIn));
            out = new BufferedOutputStream(new FileOutputStream("e.jpg"));
            startTime = System.nanoTime();
            int byteRead;
            //int bufSize = 4 * 1024;
            //byte[] byteBuf = new byte[bufSize]; // 4K buffer
            //while ((byteRead = in.read(byteBuf)) != -1) {
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Read byte: Elapsed Time is " + (elapsedTime / 1000000.0) + " msec\n");

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
        
        //Đọc theo từng mảng byte
        try {
            fileIn = new File("a.jpg");
            System.out.println("File size is " + fileIn.length() + " bytes");
            in = new BufferedInputStream(new FileInputStream(fileIn));
            out = new BufferedOutputStream(new FileOutputStream("e.jpg"));
            startTime = System.nanoTime();
            int byteRead;
            int bufSize = 4 * 1024;
            byte[] byteBuf = new byte[bufSize]; // 4K buffer
            while ((byteRead = in.read(byteBuf)) != -1) {
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Read byte Array: Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");

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
