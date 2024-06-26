/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m3.hibernatewebapp.Model;

import jakarta.persistence.*;




/**
 *
 * @author MJ
 */
@Entity
@Table(name="employee")
public class Employee {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int empid;
   
   @Column(name="Employeefname")
   private String firstName;
   
   @Column(name="Employeelname")
   private String lastName;
   
   @Column(name="Employeedept")
   private String department;
   
   public Employee(){
       
   }

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
   
}
