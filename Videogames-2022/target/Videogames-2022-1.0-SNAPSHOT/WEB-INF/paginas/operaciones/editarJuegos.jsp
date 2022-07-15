<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c0e10b8f1.js" crossorigin="anonymous"></script>
        
        <title>Libreria</title>
    </head>
    <body>
       
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idJuego=${juego.id_game}"
              method="POST" class="was-validated" enctype="multipart/form-data">
            <jsp:include page="/WEB-INF/paginas/comunes/editarNav.jsp"/>
            
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Título: ${juego.name} </h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="serie_title">Título de la serie</label>
                                        <input class="form-control" type="text" name="serie_title" required="" value="${juego.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="first_title">Primer título</label>
                                        <input class="form-control" type="text" name="first_title" required="" value="${juego.first_release_title}">
                                    </div>
                                    <div class="form-group">
                                        <label for="first_title_console">Consolas</label>
                                        <input class="form-control" type="text" name="first_title_console" required="" value="${juego.first_release_console}">
                                    </div>
                                    <div class="form-group">
                                        <label for="first_title_year">Año de lanzamiento</label>
                                        <input class="form-control" type="number" name="first_title_year" required="" value="${juego.first_release_year}">
                                    </div>
                                    <div class="form-group">
                                        <label for="last_title">Último título</label>
                                        <input class="form-control" type="text" name="last_title" required="" value="${juego.last_release_title}">
                                    </div>
                                    <div class="form-group">
                                        <label for="last_title_console">Consolas</label>
                                        <input class="form-control" type="text" name="last_title_console" required="" value="${juego.last_release_console}">
                                    </div>
                                    <div class="form-group">
                                        <label for="last_title_year">Año de lanzamiento</label>
                                        <input class="form-control" type="number" name="last_title_year" required="" value="${juego.last_release_year}">
                                    </div>
                                    <div class="form-group">
                                        <label for="company">Compañia</label>
                                        <input class="form-control" type="text" name="company" required="" value="${juego.company}">
                                    </div>
                                    <div class="form-group">
                                        <label for="img">Logo</label>
                                        <input class="form-control" type="file" name="img" value="${juego.img}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        
        <jsp:include page="/WEB-INF/paginas/comunes/pie_de_pagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>