package data;

import entity.Juegos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpServletResponse;


public class VideojuegosDAO {
    private static final String SQL_CREATE = "INSERT INTO best_games_series(name, first_release_title, first_release_console, first_release_year,"
            + "last_release_title, last_release_console, last_release_year, company, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM best_games_series";
    private static final String SQL_UPDATE_IMG = "UPDATE best_games_series SET img = ? WHERE id_game = ?";
    private static final String SQL_UPDATE_LASTGAME = "UPDATE best_games_series SET last_release_title = ?, last_release_console = ?, last_release_year = ? WHERE id_game = ?";
    private static final String SQL_UPDATE= "UPDATE best_games_series SET name = ?, first_release_title = ?, first_release_console = ?, first_release_year = ?,"
            + "last_release_title=?, last_release_console = ?, last_release_year = ?, company = ?, img = ? WHERE id_game = ?";
    private static final String SQL_DELETE = "DELETE FROM best_games_series WHERE id_game = ?";
    private static final String SQL_READ_BY_ID = "SELECT * FROM best_games_series WHERE id_game = ?";
    
    public List<Juegos> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Juegos juego;
        List <Juegos> juegos = new ArrayList();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id_game = rs.getInt("id_game");
                String name = rs.getString("name");
                String first_release_title = rs.getString("first_release_title");
                String first_release_console = rs.getString("first_release_console");
                int first_release_year = rs.getInt("first_release_year");
                String last_release_title = rs.getString("last_release_title");
                String last_release_console = rs.getString("last_release_console");
                int last_release_year = rs.getInt("last_release_year");
                String company = rs.getString("company");
    
                juego = new Juegos(id_game, name, first_release_title, first_release_console, first_release_year, last_release_title, last_release_console, last_release_year, company);
                juego.setImg(rs.getBinaryStream("img"));
                
                juegos.add(juego);
            }
            
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return juegos;
    }
    
    public void findImg(int id, HttpServletResponse res) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        res.setContentType("image/");
        try {
            outputStream = res.getOutputStream();
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
       
            while(rs.next()) {
               inputStream = rs.getBinaryStream("img");
            }
            
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while((i = bufferedInputStream.read()) != -1 ) {
                bufferedOutputStream.write(i);
            }
            
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }
    
    public Juegos findGameById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Juegos juego = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id_game = rs.getInt("id_game");
                String name = rs.getString("name");
                String first_release_title = rs.getString("first_release_title");
                String first_release_console = rs.getString("first_release_console");
                int first_release_year = rs.getInt("first_release_year");
                String last_release_title = rs.getString("last_release_title");
                String last_release_console = rs.getString("last_release_console");
                int last_release_year = rs.getInt("last_release_year");
                String company = rs.getString("company");
                
                juego = new Juegos(id_game, name, first_release_title, first_release_console, first_release_year, last_release_title, last_release_console, last_release_year, company);
                juego.setImg(rs.getBinaryStream("img"));
            }
            
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return juego;
    }
    
    public int create(Juegos juego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, juego.getName());
            stmt.setString(2, juego.getFirst_release_title());
            stmt.setString(3, juego.getFirst_release_console());
            stmt.setInt(4, juego.getFirst_release_year());
            stmt.setString(5, juego.getLast_release_title());
            stmt.setString(6, juego.getLast_release_console());
            stmt.setInt(7, juego.getLast_release_year());
            stmt.setString(8, juego.getCompany());
            stmt.setBlob(9, juego.getImg());
            registros = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    
    public int update(Juegos juego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, juego.getName());
            stmt.setString(2, juego.getFirst_release_title());
            stmt.setString(3, juego.getFirst_release_console());
            stmt.setInt(4, juego.getFirst_release_year());
            stmt.setString(5, juego.getLast_release_title());
            stmt.setString(6, juego.getLast_release_console());
            stmt.setInt(7, juego.getLast_release_year());
            stmt.setString(8, juego.getCompany());
            stmt.setBlob(9, juego.getImg());
            stmt.setInt(10, juego.getId_game());
            registros = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int delete(int id_juego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
    
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_juego);
            registros = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch(SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
