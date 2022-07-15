package web;

import data.VideojuegosDAO;
import entity.Juegos;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        if(accion != null) {
            switch(accion) {
                case "editar":
                    editarJuego(req, res);
                    break;
                case "eliminar":
                    eliminarJuego(req, res);
                    break;
                case "mostrarImg":
                    mostrarImg(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null) {
            switch (accion) {
                case "insertar":
                    guardarJuego(req, res);
                    break;
                case "modificar":
                    modificarLibro(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Juegos> juegos = new VideojuegosDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("juegos", juegos);
        res.sendRedirect("videogames.jsp");
    }
    
    private void guardarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String serie_title = req.getParameter("serie_title");
        String first_title = req.getParameter("first_title");
        String first_title_console = req.getParameter("first_title_console");
        int first_title_year = Integer.parseInt(req.getParameter("first_title_year"));
        String last_title = req.getParameter("last_title");
        String last_title_console = req.getParameter("last_title_console");
        int last_title_year = Integer.parseInt(req.getParameter("last_title_year"));
        String company = req.getParameter("company");
        Part part = req.getPart("img");
        InputStream img = part.getInputStream();
        
        Juegos juego = new Juegos(serie_title, first_title, first_title_console, first_title_year, last_title, last_title_console, last_title_year, company);
        juego.setImg(img);
        int regMod = new VideojuegosDAO().create(juego);
        System.out.println("Insertados: " + regMod);
        accionDefault(req, res);
    }
    
    private void editarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idJuego = Integer.parseInt(req.getParameter("idJuego"));
        Juegos juego = new VideojuegosDAO().findGameById(idJuego);
        req.setAttribute("juego", juego);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarJuegos.jsp").forward(req, res);
    }
    
    private void modificarLibro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String serie_title = req.getParameter("serie_title");
        String first_title = req.getParameter("first_title");
        String first_title_console = req.getParameter("first_title_console");
        int first_title_year = Integer.parseInt(req.getParameter("first_title_year"));
        String last_title = req.getParameter("last_title");
        String last_title_console = req.getParameter("last_title_console");
        int last_title_year = Integer.parseInt(req.getParameter("last_title_year"));
        String company = req.getParameter("company");
        Part part = req.getPart("img");
        InputStream img = part.getInputStream();
        int idJuego= Integer.parseInt(req.getParameter("idJuego"));
        
        Juegos juego = new Juegos(idJuego, serie_title, first_title, first_title_console, first_title_year, last_title, last_title_console, last_title_year, company);
        juego.setImg(img);
        int regMod = new VideojuegosDAO().update(juego);
        System.out.println("Registros actualizados: " + regMod);
        accionDefault(req, res);
    }
    
    private void eliminarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id_game = Integer.parseInt(req.getParameter("idJuego"));
        
        int regDel = new VideojuegosDAO().delete(id_game);
        
        System.out.println("Registros eliminados: " + regDel);
        
        accionDefault(req, res);
    }
    
    private void mostrarImg(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id_game = Integer.parseInt(req.getParameter("id_game"));
        VideojuegosDAO vgDAO = new VideojuegosDAO();
        vgDAO.findImg(id_game, res);
    }
}
