/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Le Hoang Anh
 */
public class Student {

    private String rollNumber;
    private String name;
    private int balance;
    private String updatedTime;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Student() {
    }

    public Student(String rollNumber, String name, int balance, String updatedTime) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.balance = balance;
        this.updatedTime = updatedTime;
    }

}
