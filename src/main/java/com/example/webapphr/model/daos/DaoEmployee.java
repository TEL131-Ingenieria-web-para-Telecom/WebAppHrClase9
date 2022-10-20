package com.example.webapphr.model.daos;

import com.example.webapphr.model.beans.Employee;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployee {

    public ArrayList<Employee> listarEmpleados(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Employee> lista = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            String sql = "select * from employees";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastname(rs.getString(3));
                employee.setEmail(rs.getString("email"));
                lista.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<Employee>  listarEmpleadosOrdenadosSalario(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Employee> lista = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            String sql = "select * from employees order by salary DESC";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastname(rs.getString(3));
                employee.setEmail(rs.getString("email"));
                lista.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

}
