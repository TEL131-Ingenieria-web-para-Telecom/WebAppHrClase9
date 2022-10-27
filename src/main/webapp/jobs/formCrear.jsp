<%--
  Created by IntelliJ IDEA.
  User: stuar
  Date: 27/10/22
  Time: 10:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Crear trabajos</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                  integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                  crossorigin="anonymous">
        </head>
    <body>
        <div class='container'>
            <div class="row justify-content-center">
                <div class="col-md-6 col-sm-12 col-lg-4">
                    <h1>Crear trabajo</h1>
                    <form method="post" action="<%=request.getContextPath()%>/JobServlet?action=guardar">
                        <div class="mb-3">
                            <label for="jobId" class="form-label">job id</label>
                            <input type="text" class="form-control" id="jobId" placeholder="job ID" name="jobId">
                        </div>
                        <div class="mb-3">
                            <label for="jobTitle" class="form-label">job title</label>
                            <input type="text" class="form-control" id="jobTitle" placeholder="job title" name="jobTitle">
                        </div>
                        <div class="mb-3">
                            <label for="minSalary" class="form-label">Min salary</label>
                            <input type="text" class="form-control" id="minSalary" placeholder="min salary" name="minSalary">
                        </div>
                        <div class="mb-3">
                            <label for="maxSalary" class="form-label">Max salary</label>
                            <input type="text" class="form-control" id="maxSalary" placeholder="max salary" name="maxSalary">
                        </div>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                        <a href="<%=request.getContextPath()%>/JobServlet" class="btn btn-danger">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
