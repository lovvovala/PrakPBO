package backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Koneksi BERHASIL!");
        } else {
            System.out.println("Koneksi GAGAL!");
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/db_gym";
        String user = "postgres";
        String pass = "1237"; // Sesuaikan dengan password PostgreSQL-mu

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}