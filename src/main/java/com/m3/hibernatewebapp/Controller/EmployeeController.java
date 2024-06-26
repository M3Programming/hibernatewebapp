/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m3.hibernatewebapp.Controller;

import com.m3.hibernatewebapp.DAO.EmployeeDAO;
import com.m3.hibernatewebapp.Model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MJ
 */
@WebServlet("/")
public class EmployeeController extends HttpServlet{
    
    private EmployeeDAO employeeDAO;
    
    public void init(){
        employeeDAO = new EmployeeDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        add(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("add_employee.jsp");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add method is the context path in jsp form action
    private void add(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");//this should be the same in the name in jsp form
        String lastName = request.getParameter("lastName");
        String department = request.getParameter("department");
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartment(department);
        employeeDAO.saveEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_success.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
