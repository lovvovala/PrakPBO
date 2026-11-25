package frontend;

import backend.MemberGym;
import backend.MemberController;
import javax.swing.*;
import java.awt.*;

public class FormRegistrasiGym extends JFrame {

    private JTextField txtNama;
    private JTextField txtUsia;
    private JComboBox<String> cmbPaket;
    private JButton btnSimpan;

    public FormRegistrasiGym() {
        setTitle("Form Registrasi Member Gym");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initComponents();
    }

    private void initComponents() {
        // ==========================
        // TITLE PANEL
        // ==========================
        JLabel title = new JLabel("FORM REGISTRASI GYM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        // ==========================
        // FORM PANEL
        // ==========================
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNama = new JLabel("Nama Lengkap:");
        JLabel lblUsia = new JLabel("Usia:");
        JLabel lblPaket = new JLabel("Paket Gym:");

        txtNama = new JTextField(20);
        txtUsia = new JTextField(20);

        // Disesuaikan dengan pilihan paket di db_gym milikmu
        String[] paketList = {"Bulanan", "3 Bulan", "Tahunan"};
        cmbPaket = new JComboBox<>(paketList);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setFont(new Font("Arial", Font.BOLD, 14));

        btnSimpan.addActionListener(e -> simpanData());

        // ===== ROW 1 =====
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(lblNama, gbc);

        gbc.gridx = 1;
        formPanel.add(txtNama, gbc);

        // ===== ROW 2 =====
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(lblUsia, gbc);

        gbc.gridx = 1;
        formPanel.add(txtUsia, gbc);

        // ===== ROW 3 =====
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(lblPaket, gbc);

        gbc.gridx = 1;
        formPanel.add(cmbPaket, gbc);

        // ===== BUTTON =====
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        formPanel.add(btnSimpan, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private void simpanData() {
        try {
            String nama = txtNama.getText().trim();
            String usiaStr = txtUsia.getText().trim();

            if (nama.isEmpty() || usiaStr.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Nama dan usia wajib diisi!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int usia = Integer.parseInt(usiaStr);
            String paket = cmbPaket.getSelectedItem().toString();

            MemberGym member = new MemberGym(nama, usia, paket);
            boolean berhasil = MemberController.simpanMember(member);

            if (berhasil) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke PostgreSQL!");
                txtNama.setText("");
                txtUsia.setText("");
                cmbPaket.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data! Cek koneksi PostgreSQL di TestKoneksi.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Usia harus berupa angka!",
                    "Kesalahan Input",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormRegistrasiGym().setVisible(true));
    }
}