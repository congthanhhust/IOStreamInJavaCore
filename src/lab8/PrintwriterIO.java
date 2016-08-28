/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author CongThanh
 * Ghi theo tung byte. Xoa du lieu cu.
 */
public class PrintwriterIO {

    public static void main(String[] args) throws IOException {
        FileOutputStream fo = null;
        PrintWriter pw = null;
        try {
            fo = new FileOutputStream("datacopy.txt");
            pw = new PrintWriter(fo);
            pw.println("Hello World");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            pw.close();
            fo.close();
        }

    }
}
