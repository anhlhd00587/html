/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Le Hoang Anh
 */
public class StudentController {

    private ArrayList<Student> listStudent;
    private final String FILE_NAME = "danhsachnoptien.txt";

    public StudentController() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("A001", "Hùng", 100000, "20/04/2018"));
        listStudent.add(new Student("A002", "Ngọc", 10000, "20/04/2018"));
        listStudent.add(new Student("A003", "Đức", 10000, "20/04/2018"));
        listStudent.add(new Student("A001", "Hùng", 20000, "21/04/2018"));
        listStudent.add(new Student("A003", "Đức", 10000, "21/04/2018"));
        listStudent.add(new Student("D00498", "Đạt", 10000, "26/04/2018"));
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
//Đọc file

    public void readFile() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis);
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public ArrayList<Student> readFileToArrayList() throws FileNotFoundException, IOException {
        ArrayList<Student> listReadStudent = new ArrayList<>();
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis);
        boolean isFirsLine = true;

        try (BufferedReader br = new BufferedReader(isr)) {
            String line;

            while ((line = br.readLine()) != null) {
                if (isFirsLine) {
                    isFirsLine = false;
                    continue;

                }
                String[] splitArray = line.split("\\|");
                String rollNumber = splitArray[0].trim();
                String name = splitArray[1].trim();
                int balance = Integer.parseInt(splitArray[2].trim());
                String updatedTime = splitArray[3].trim();
                Student st = new Student(rollNumber, name, balance, updatedTime);

                listReadStudent.add(st);
            }
        }
        return listReadStudent;
    }
// Câu 1:Tạo file từ danh sách sinh viên

    public void generateFile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        try (BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.format(
                    "%15s %5s |  %15s %5s | %15s %5s | %15s %5s",
                    "Mã sinh viên",
                    "",
                    "Tên sinh viên",
                    "",
                    "Số tiền (VND)",
                    "",
                    "Ngày nộp",
                    ""));
            bw.newLine();
            for (Student student : listStudent) {
                bw.write(String.format(
                        "%15s %5s |  %15s %5s | %15s %5s | %15s %5s",
                        student.getRollNumber(),
                        "",
                        student.getName(),
                        "",
                        student.getBalance(),
                        "",
                        student.getUpdatedTime(),
                        ""));
                bw.newLine();
            }
        }
    }

}
