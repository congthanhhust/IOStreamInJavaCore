/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.io.File;

/**
 *
 * @author CongThanh
 */
public class ListDirectoryRecusive {

    public static void listRecursive(File dir) {
        if (dir.isDirectory()) {
            File[] items = dir.listFiles();
            for (File item : items) {
                System.out.println(item.getAbsoluteFile());
                //if (item.isDirectory()) {
                //    listRecursive(item);
                //}
            }
        }
    }

    public static void main(String[] args) {
        File dir = new File("E:\\");
        listRecursive(dir);

    }
}
