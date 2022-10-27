package com.example.webapphr.servlets;

import com.example.webapphr.model.beans.Job;
import com.example.webapphr.model.daos.DaoJob;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "JobServlet", value = "/JobServlet")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "listar" : action;
        RequestDispatcher requestDispatcher;
        DaoJob daoJob = new DaoJob();
        String jobId;
        Job job;

        switch (action) {
            case "listar":
                request.setAttribute("lista", daoJob.lista());

                requestDispatcher = request.getRequestDispatcher("jobs/lista.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "crear":
                requestDispatcher = request.getRequestDispatcher("jobs/formCrear.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "editar":
                jobId = request.getParameter("id");
                job = daoJob.buscarPorId(jobId);

                if (job != null) { //abro el form para editar
                    request.setAttribute("job", job);
                    requestDispatcher = request.getRequestDispatcher("jobs/formEditar.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/JobServlet");
                }
                break;
            case "editarParcial":
                jobId = request.getParameter("id");
                job = daoJob.buscarPorId(jobId);

                if (job != null) { //abro el form para editar
                    request.setAttribute("job", job);
                    requestDispatcher = request.getRequestDispatcher("jobs/formEditarParcial.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/JobServlet");
                }
                break;
            case "borrar":  // JobServlet?action=borrar&id=50
                jobId = request.getParameter("id");
                daoJob.borrar(jobId);

                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        DaoJob daoJob = new DaoJob();

        switch (action) {
            case "guardar":
                String jobId = request.getParameter("jobId");
                String jobTitle = request.getParameter("jobTitle");
                String minSalaryStr = request.getParameter("minSalary");
                int minSalary = Integer.parseInt(minSalaryStr); //esto deben validar
                String maxSalaryStr = request.getParameter("maxSalary");
                int maxSalary = Integer.parseInt(maxSalaryStr); //falta validar

                Job job = new Job();
                job.setJobId(jobId);
                job.setJobTitle(jobTitle);
                job.setMinSalary(minSalary);
                job.setMaxSalary(maxSalary);
                daoJob.guardar(job);

                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;
            case "actualizar":
                String jobId1 = request.getParameter("jobId");
                String jobTitle1 = request.getParameter("jobTitle");
                String minSalaryStr1 = request.getParameter("minSalary");
                String maxSalaryStr1 = request.getParameter("maxSalary");
                try {
                    int minSalary1 = Integer.parseInt(minSalaryStr1);
                    int maxSalary1 = Integer.parseInt(maxSalaryStr1);
                    daoJob.actualizar(jobId1, jobTitle1, minSalary1, maxSalary1);

                    response.sendRedirect(request.getContextPath() + "/JobServlet");
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/JobServlet?action=editar&id=" + jobId1);
                }
                break;
            case "actualizarParcial":
                String jobId2 = request.getParameter("jobId");
                String jobTitle2 = request.getParameter("jobTitle");
                String minSalaryStr2 = request.getParameter("minSalary");
                int minSalary2 = Integer.parseInt(minSalaryStr2);

                try {
                    daoJob.actualizarParcial(jobId2, jobTitle2, minSalary2);
                    response.sendRedirect(request.getContextPath() + "/JobServlet");
                } catch (SQLException e) {
                    job = daoJob.buscarPorId(jobId2);

                    if (job != null) { //abro el form para editar
                        request.setAttribute("job", job);
                        request.setAttribute("error","El texto no puede tener mas de 255 caractéres");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobs/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/JobServlet");
                    }
                }

                break;
            case "buscar":
                String searchText = request.getParameter("searchText");

                ArrayList<Job> lista = daoJob.buscarPorJobTitle(searchText);
                request.setAttribute("lista", lista);
                request.setAttribute("searchText",searchText);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobs/lista.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }
}
