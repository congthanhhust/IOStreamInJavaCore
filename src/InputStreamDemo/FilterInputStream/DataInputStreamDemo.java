/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputStreamDemo.FilterInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Khong doc duoc tieng viet
 * @author CongThanh
 */
public class DataInputStreamDemo {

    public static void main(String args[]) throws IOException {
        long startTime, elapsedTime;  // for speed benchmarking
        DataInputStream d = new DataInputStream(new FileInputStream("test.txt"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("test1.txt"));

        String count;
        while ((count = d.readLine()) != null) {
            String u = count.toUpperCase();
            System.out.println(u);
            out.writeBytes(u + "  ,");
        }
        d.close();
        out.close();
    }
}
