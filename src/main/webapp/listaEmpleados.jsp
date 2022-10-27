<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.webapphr.model.beans.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listEmployees" scope="request" type="ArrayList<Employee>"/>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Lista de empleados</h1>
            <a href="<%=request.getContextPath()%>/JobServlet" class="btn btn-secondary">Ir a lista de Trabajos</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>id</th>
                        <th>nombre</th>
                        <th>apellido</th>
                        <th>email</th>
                    </tr>
                </thead>
                <tbody>
                    <% int i = 1;
                        for (Employee employee : listEmployees) { %>
                    <tr>
                        <td><%=i%>
                        </td>
                        <td><%=employee.getEmployeeId()%>
                        </td>
                        <td><%=employee.getFirstName()%>
                        </td>
                        <td><%=employee.getLastname()%>
                        </td>
                        <td><%=employee.getEmail()%>
                        </td>
                    </tr>
                    <% i++;
                    }

                    %>
                </tbody>
            </table>
            <% Date date = new Date(); %>

            <h6><%=date.toString()%>
            </h6>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
                crossorigin="anonymous"></script>
    </body>
</html>
