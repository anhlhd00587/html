/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.StudentController;
import entity.Student;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Le Hoang Anh
 */
public class MainThread {

    public static void main(String[] args) throws IOException {
//        StudentController studentController = new StudentController();
//        ArrayList<Student> list = studentController.readFileToArrayList();
//        for (int i = 0; i < list.size(); i++) {
//            Student get = list.get(i);
//            System.out.println("%10s %10s %10d %15s,st.get..");
//            System.out.println("");
//             studentController.readFile();
        StudentController controller = new StudentController();
        ArrayList<Student> list = controller.readFileToArrayList();
        for (int i = 0; i < list.size(); i++) {
            Student get = list.get(i);
            System.out.println("%10s %10s %10d %15s");
            
        }
    }
}
