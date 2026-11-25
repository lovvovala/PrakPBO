package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberController {
    public static boolean simpanMember(MemberGym member) {
        String sql = "INSERT INTO member_gym (nama, usia, paket) VALUES (?, ?, ?)";

        try (Connection conn = TestKoneksi.getConnection()) {
            if (conn == null) {
                System.out.println("Koneksi null! Pastikan PostgreSQL menyala dan TestKoneksi benar.");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, member.getNama());
                stmt.setInt(2, member.getUsia());
                stmt.setString(3, member.getPaket());
                stmt.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Gagal simpan ke PostgreSQL: " + e.getMessage());
            return false;
        }
    }
}