package backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_perpus";
    private static final String USER = "postgres";
    private static final String PASS = "1237"; 

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}