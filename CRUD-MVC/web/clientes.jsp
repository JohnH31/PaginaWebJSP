<%-- 
    Document   : clientes
    Created on : 12/09/2022, 07:33:32 PM
    Author     : Usuario Local
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GruposPermisos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    </head>
    <body>
        <div class="d d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=clientes" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${grupos.getId()}" name="txtid" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NIT</label>
                            <input type="text" name="txtnit" value="${grupos.getNit()}" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text" name="txtno" value="${grupos.getNombre()}" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label>APELLIDOS</label>
                            <input type="text" name="txtap" value="${grupos.getApellido()}" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label>TELEFONO</label>
                            <input type="text" name="txtte" value="${grupos.getTel()}" class="form-control"><br>
                        </div>
                        <input type="submit" name="accion" value="Guardar" class="btn bg-info"> 
                        <input type="submit" name="accion" value="Actualizar" class="btn bg-success"> 
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NIT</th>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>TELEFONO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${datos}">
                            <tr>
                                <td>${dato.getId()}</td>
                                <td>${dato.getNit()}</td>
                                <td>${dato.getNombre()}</td>
                                <td>${dato.getApellido()}</td>
                                <td>${dato.getTel()}</td>
                                <td>
                                    <a style="margin-left: 10px; border: none" class="btn btn-warning" href="Controlador?menu=clientes&accion=Editar&id=${dato.getId()}">Editar</a>
                                    <a style="margin-left: 10px; border: none" class="btn btn-danger" href="Controlador?menu=clientes&accion=Delete&id=${dato.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

    </body>
</html>
