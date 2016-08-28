/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Để ghi nhiều đối tượng vào file. Cần sử dụng arraylist
 * @author CongThanh
 */
public class ReadWriteArrayObject {
    
    public static void main(String[] args) {
        MyStudent myStudent1 = new MyStudent("Nguyễn Công Thành", 22); // tao doi tuong myStudent
        MyStudent myStudent2 = new MyStudent("Lê Hoài Nam", 22);
        ArrayList<MyStudent> arrayOfStudents = new ArrayList<MyStudent>();
        arrayOfStudents.add(myStudent1);
        arrayOfStudents.add(myStudent2);
        
        //Ghi Object vao file
        try {   // dat try cacth de tranh ngoai le khi tao va viet File
            FileOutputStream f = new FileOutputStream("arrayOfStudents.dat"); // tao file f tro den student.dat
            ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
            oStream.writeObject(arrayOfStudents); // ghi MyStudent theo kieu Object vao file
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }

        //Doc Object tu file
        ArrayList<MyStudent> ms = null;

        try {   // dat try cacth de tranh ngoai le khi tao va doc File
            FileInputStream f = new FileInputStream("arrayOfStudents.dat"); // tao file f tro den student.dat
            ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
            // dung inStream doc theo Object, ep kieu tra ve la MyStudent
            ms = (ArrayList<MyStudent>) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }

        // Xuat KQ
        if(ms!=null){
            for(int i=0; i< ms.size(); i++){
                System.out.println("My name is " + ms.get(i).getName() + ". I am " + ms.get(i).getAge() + " years old");
            }
        }
        
    }
}



