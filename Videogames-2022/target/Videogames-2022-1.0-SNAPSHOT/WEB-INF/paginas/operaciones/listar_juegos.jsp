<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="juegos">
    <div class="container-fluid ">
        <div class="row justify-content-center">
            <div class="col-md-9">
                <div class="card w-100">
                    <div class="card-header">
                        <h4>Listado de Videojuegos</h4>
                    </div>
                    <table class="table table-striped table-primary text-center">
                        <thead>
                            <tr>
                                <th>Logo</th>
                                <th>Nombre</th>
                                <th>Primer Lanzamiento</th>
                                <th>Consola</th>
                                <th>Año</th>
                                <th>Último Lanzamiento</th>
                                <th>Consola</th>
                                <th>Año</th>
                                <th>Compañia</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="juego" items="${juegos}">
                                <tr>
                                    <td><img class="img-fluid h-100" src="${pageContext.request.contextPath}/ServletControlador?accion=mostrarImg&id_game=${juego.id_game}" alt="logo"></td>
                                    <td>${juego.name}</td>
                                    <td>${juego.first_release_title}</td>
                                    <td>${juego.first_release_console}</td>
                                    <td>${juego.first_release_year}</td>
                                    <td>${juego.last_release_title}</td>
                                    <td>${juego.last_release_console}</td>
                                    <td>${juego.last_release_year}</td>
                                    <td>${juego.company}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idJuego=${juego.id_game}" class="btn btn-info">
                                            Editar <i class="far fa-edit"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/operaciones/agregarJuegos.jsp"/>