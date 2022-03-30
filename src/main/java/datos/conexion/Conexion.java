package datos.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbinmobiliaria?serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";
    private static BasicDataSource datasource;
    private static Connection conn;

    //Pool de conexiones
    public static DataSource getDataSource() {
        if (datasource == null) {
            //se crea un objeto de tipo BasicDataSource. 
            //Esta clase se encuentra en la librería apache.commons.dbcd2
            datasource = new BasicDataSource();
            datasource.setUrl(JDBC_URL);
            datasource.setUsername(JDBC_USER);
            datasource.setPassword(JDBC_PASSWORD);
            //aqui definimos el tamaño del pool de conexiones
            datasource.setInitialSize(10);
        }
        return datasource;
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion.conn = getDataSource().getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return Conexion.conn;
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
