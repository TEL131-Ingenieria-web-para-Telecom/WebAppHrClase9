package com.example.webapphr.servlets;

import java.io.*;

import com.example.webapphr.model.beans.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet","/usuario","/usuarios"})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        String idStr = request.getParameter("id");
        String vista = "";

        if(idStr == null){
            vista = "error.jsp";
        }else{
            try{
                int id = Integer.parseInt(idStr);
                if(id == 1){
                    vista = "listaEmpleadosX.jsp";
                }else{
                    vista = "index2.jsp";
                }
            }catch (NumberFormatException e){
                vista = "error.jsp";
            }
        }

        Employee e = new Employee();
        e.setEmployeeId(3);
        e.setFirstName("cesar");
        e.setLastname("lucho");
        e.setEmail("extra!!!");
        request.setAttribute("empleadoExtra",e);
        request.setAttribute("numero",5);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(vista);
        requestDispatcher.forward(request,response);
    }


}