import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FormRegistrasiGym {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Registrasi Gym");
        frame.setSize(600, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nama
        JLabel label1 = new JLabel("Nama:");
        label1.setBounds(20, 15, 150, 20);
        frame.add(label1);
        JTextField textField1 = new JTextField();
        textField1.setBounds(20, 40, 150, 25);
        frame.add(textField1);

        // Usia
        JLabel label2 = new JLabel("Usia:");
        label2.setBounds(20, 75, 150, 20);
        frame.add(label2);
        JTextField textField2 = new JTextField();
        textField2.setBounds(20, 100, 150, 25);
        frame.add(textField2);

        // Label Paket
        JLabel label3 = new JLabel("Paket:");
        label3.setBounds(20, 135, 150, 20);
        frame.add(label3);
        
        // Dropdown Paket
        String[] paketOptions = {"Bulanan", "3 Bulan", "Tahunan"};
        JComboBox<String> comboBoxPaket = new JComboBox<>(paketOptions);
        comboBoxPaket.setBounds(20, 160, 150, 25);
        frame.add(comboBoxPaket);

        // Tombol Simpan
        JButton button1 = new JButton("Simpan");
        button1.setBounds(20, 200, 150, 25);
        frame.add(button1);

        // Tombol Reset
        JButton button2 = new JButton("Reset");
        button2.setBounds(20, 235, 150, 25);
        frame.add(button2);

        // TextArea untuk menampilkan hasil
        JTextArea textArea = new JTextArea();
        textArea.setBounds(200, 40, 350, 220);
        textArea.setEditable(false);
        frame.add(textArea);

        // Event simpan ke PostgreSQL
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField1.getText().trim();
                String usiaStr = textField2.getText().trim();
                String paket = (String) comboBoxPaket.getSelectedItem();

                // Validasi input kosong
                if (nama.isEmpty() || usiaStr.isEmpty() || paket == null) {
                    JOptionPane.showMessageDialog(frame, "Harap isi semua field.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validasi input usia harus berupa angka
                int usia;
                try {
                    usia = Integer.parseInt(usiaStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Usia harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                try {
                   
                    Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/db_gym", 
                        "postgres", 
                        "1237"
                    );

                    // Query insert ke tabel member_gym
                    String sql = "INSERT INTO member_gym (nama, usia, paket) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, nama);
                    statement.setInt(2, usia);
                    statement.setString(3, paket);
                    statement.executeUpdate();
                    connection.close();

                    // Tampilkan hasil ke TextArea dan pop-up sukses
                    textArea.setText("REGISTRASI BERHASIL:\n");
                    textArea.append("Nama  : " + nama + "\n");
                    textArea.append("Usia  : " + usia + "\n");
                    textArea.append("Paket : " + paket + "\n");

                    JOptionPane.showMessageDialog(frame, "Member gym berhasil didaftarkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal menyimpan ke database!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Event Reset Form
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                comboBoxPaket.setSelectedIndex(0);
                textArea.setText("");
            }
        });

        frame.setVisible(true);
    }
}