<div class="modal fade" id="agregarJuegoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar videojuego</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <!-- El atributo action pide la url del cliente y le envia al controlador -->
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST"
                  class="was-validate" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="serie_title">Título de la serie</label>
                        <input class="form-control" type="text" name="serie_title" required="">
                    </div>
                    <div class="form-group">
                        <label for="first_title">Primer título</label>
                        <input class="form-control" type="text" name="first_title" required="">
                    </div>
                    <div class="form-group">
                        <label for="first_title_console">Consolas</label>
                        <input class="form-control" type="text" name="first_title_console" required="">
                    </div>
                    <div class="form-group">
                        <label for="first_title_year">Año de lanzamiento</label>
                        <input class="form-control" type="number" name="first_title_year" required="">
                    </div>
                    <div class="form-group">
                        <label for="last_title">Último título</label>
                        <input class="form-control" type="text" name="last_title" required="">
                    </div>
                    <div class="form-group">
                        <label for="last_title_console">Consolas</label>
                        <input class="form-control" type="text" name="last_title_console" required="">
                    </div>
                    <div class="form-group">
                        <label for="last_title_year">Año de lanzamiento</label>
                        <input class="form-control" type="number" name="last_title_year" required="">
                    </div>
                    <div class="form-group">
                        <label for="company">Compañia</label>
                        <input class="form-control" type="text" name="company" required="">
                    </div>
                    <div class="form-group">
                        <label for="img">Logo</label>
                        <input class="form-control" type="file" name="img">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>