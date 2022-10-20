<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.webapphr.model.beans.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listEmployees" scope="request" type="ArrayList<Employee>" />
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Hola mundo</h1>
        <table>
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
    </body>
</html>
