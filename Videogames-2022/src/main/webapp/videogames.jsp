<!-- Directivas jsp -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c0e10b8f1.js" crossorigin="anonymous"></script>
        
        <title>Mejores Series de Videojuegos</title>
    </head>
    <body>
       
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/navegacion.jsp"/>
       
        <jsp:include page="/WEB-INF/paginas/operaciones/listar_juegos.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/pie_de_pagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
