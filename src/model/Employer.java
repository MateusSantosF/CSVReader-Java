/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mateus
 */
public class Employer extends Person {

    private String department;

    public Employer(String department) {
        this.department = department;
    }

    public Employer(String department, int id, String firstName, String lastName, int age) {
        super(id, firstName, lastName, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
