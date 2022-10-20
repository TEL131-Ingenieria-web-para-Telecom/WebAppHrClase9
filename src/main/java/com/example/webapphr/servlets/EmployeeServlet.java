package com.example.webapphr.servlets;

import com.example.webapphr.model.beans.Employee;
import com.example.webapphr.model.daos.DaoEmployee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoEmployee daoEmployee = new DaoEmployee();
        ArrayList<Employee> list = daoEmployee.listarEmpleadosOrdenadosSalario();

        request.setAttribute("listEmployees",list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaEmpleados.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
