<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="job" type="com.example.webapphr.model.beans.Job" scope="request"/>
<% String error = (String) request.getAttribute("error");%>
<html>
    <head>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Editar trabajos</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                  integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                  crossorigin="anonymous">
        </head>
    <body>
        <div class='container'>
            <div class="row justify-content-center">
                <div class="col-md-6 col-sm-12 col-lg-4">
                    <h1>Editar trabajo parcialmente</h1>
                    <form method="post" action="<%=request.getContextPath()%>/JobServlet?action=actualizarParcial">
                        <input type="hidden" name="jobId" value="<%=job.getJobId()%>">
                        <div class="mb-3">
                            <label for="jobTitle" class="form-label">job title</label>
                            <input type="text" class="form-control <%=error!=null?"is-invalid":""%>" id="jobTitle"
                                   placeholder="job title" name="jobTitle" value="<%=job.getJobTitle()%>">
                            <% if (error != null) { %>
                            <div id="validationServer03Feedback" class="invalid-feedback">
                                <%=error%>
                            </div>
                            <% } %>
                        </div>
                        <div class="mb-3">
                            <label for="minSalary" class="form-label">Min salary</label>
                            <input type="text" class="form-control" id="minSalary"
                                   placeholder="min salary" name="minSalary" value="<%=job.getMinSalary()%>">
                        </div>
                        <div class="mb-3">
                            <label for="maxSalary" class="form-label">Max salary</label>
                            <input type="text" class="form-control" id="maxSalary" placeholder="max salary"
                                   name="maxSalary" value="<%=job.getMaxSalary()%>" disabled>
                        </div>
                        <button type="submit" class="btn btn-primary">Actualizar</button>
                        <a href="<%=request.getContextPath()%>/JobServlet" class="btn btn-danger">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
