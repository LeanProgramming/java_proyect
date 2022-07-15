package data;

import java.sql.*;

public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_java_crud?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement stm) throws  SQLException {
        stm.close();
    }
    
    public static void close(Connection cn) throws SQLException {
        cn.close();
    }
}
