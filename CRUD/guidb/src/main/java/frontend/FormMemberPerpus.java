package frontend;

import backend.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormMemberPerpus extends JFrame {
    private JTextField txtNama, txtAlamat, txtHp, txtEmail, txtTanggal;
    private JComboBox<String> cmbJenis, cmbStatus;
    private JTable table;
    private DefaultTableModel model;
    private int idSelected = -1;

    public FormMemberPerpus() {
        setTitle("Form Anggota Perpustakaan");
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        loadData();
    }

    private void initComponents() {
        JLabel lblNama = new JLabel("Nama:");
        JLabel lblAlamat = new JLabel("Alamat:");
        JLabel lblHp = new JLabel("No HP:");
        JLabel lblJenis = new JLabel("Jenis Member:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblTanggal = new JLabel("Tanggal Daftar (YYYY-MM-DD):");
        JLabel lblStatus = new JLabel("Status:");

        txtNama = new JTextField();
        txtAlamat = new JTextField();
        txtHp = new JTextField();
        cmbJenis = new JComboBox<>(new String[]{"Reguler", "Premium", "VIP"});
        txtEmail = new JTextField();
        txtTanggal = new JTextField(LocalDate.now().toString()); // Default tanggal hari ini
        cmbStatus = new JComboBox<>(new String[]{"aktif", "tidak aktif"});

        JButton btnSimpan = new JButton("Simpan");
        JButton btnUpdate = new JButton("Update");
        JButton btnHapus = new JButton("Hapus");
        JButton btnReset = new JButton("Reset");

        btnSimpan.addActionListener(e -> simpan());
        btnUpdate.addActionListener(e -> update());
        btnHapus.addActionListener(e -> hapus());
        btnReset.addActionListener(e -> resetForm());

        model = new DefaultTableModel(
            new String[]{"ID", "Nama", "Alamat", "No HP", "Jenis", "Email", "Tgl Daftar", "Status"}, 0
        );
        table = new JTable(model);
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                isiForm();
            }
        });

        JPanel form = new JPanel(new GridLayout(7, 2, 10, 8));
        form.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));
        form.add(lblNama); form.add(txtNama);
        form.add(lblAlamat); form.add(txtAlamat);
        form.add(lblHp); form.add(txtHp);
        form.add(lblJenis); form.add(cmbJenis);
        form.add(lblEmail); form.add(txtEmail);
        form.add(lblTanggal); form.add(txtTanggal);
        form.add(lblStatus); form.add(cmbStatus);

        JPanel tombol = new JPanel();
        tombol.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));
        tombol.add(btnSimpan);
        tombol.add(btnUpdate);
        tombol.add(btnHapus);
        tombol.add(btnReset);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(tombol, BorderLayout.SOUTH);
    }

    // VALIDASI INPUT SESUAI TUGAS
    private boolean validasiInput() {
        String nama = txtNama.getText().trim();
        String alamat = txtAlamat.getText().trim();
        String noHp = txtHp.getText().trim();
        String email = txtEmail.getText().trim();
        String tanggal = txtTanggal.getText().trim();

        // 1. Nama tidak boleh kosong
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Validasi Error", JOptionPane.ERROR_MESSAGE);
            txtNama.requestFocus();
            return false;
        }

        // 2. Alamat minimal 10 karakter
        if (alamat.length() < 10) {
            JOptionPane.showMessageDialog(this, "Alamat minimal harus 10 karakter!", "Validasi Error", JOptionPane.ERROR_MESSAGE);
            txtAlamat.requestFocus();
            return false;
        }

        // 3. No HP harus angka (dan tidak kosong)
        if (noHp.isEmpty() || !noHp.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "No HP harus berupa angka dan tidak boleh kosong!", "Validasi Error", JOptionPane.ERROR_MESSAGE);
            txtHp.requestFocus();
            return false;
        }

        // 4. Email & Tanggal Daftar wajib terisi valid
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email tidak boleh kosong!", "Validasi Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        try {
            LocalDate.parse(tanggal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format Tanggal Daftar harus YYYY-MM-DD (contoh: 2026-11-25)!", "Validasi Error", JOptionPane.ERROR_MESSAGE);
            txtTanggal.requestFocus();
            return false;
        }

        return true;
    }

    // LOAD DATA KE TABEL (READ)
    private void loadData() {
        model.setRowCount(0);
        ArrayList<Member> list = MemberController.getAll();
        for (Member m : list) {
            model.addRow(new Object[]{
                m.getId(),
                m.getNama(),
                m.getAlamat(),
                m.getNoHp(),
                m.getJenisMember(),
                m.getEmail(),
                m.getTanggalDaftar(),
                m.getStatus()
            });
        }
    }

    // SIMPAN (CREATE)
    private void simpan() {
        if (!validasiInput()) return;

        Member m = new Member(
            txtNama.getText().trim(),
            txtAlamat.getText().trim(),
            txtHp.getText().trim(),
            cmbJenis.getSelectedItem().toString(),
            txtEmail.getText().trim(),
            txtTanggal.getText().trim(),
            cmbStatus.getSelectedItem().toString()
        );

        if (MemberController.tambah(m)) {
            JOptionPane.showMessageDialog(this, "Data anggota berhasil disimpan!");
            loadData();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // UPDATE
    private void update() {
        if (idSelected == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data pada tabel terlebih dahulu!");
            return;
        }
        if (!validasiInput()) return;

        Member m = new Member(
            idSelected,
            txtNama.getText().trim(),
            txtAlamat.getText().trim(),
            txtHp.getText().trim(),
            cmbJenis.getSelectedItem().toString(),
            txtEmail.getText().trim(),
            txtTanggal.getText().trim(),
            cmbStatus.getSelectedItem().toString()
        );

        if (MemberController.update(m)) {
            JOptionPane.showMessageDialog(this, "Data anggota berhasil diperbarui!");
            loadData();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // HAPUS (DELETE)
    private void hapus() {
        if (idSelected == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data pada tabel terlebih dahulu!");
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            if (MemberController.delete(idSelected)) {
                JOptionPane.showMessageDialog(this, "Data anggota berhasil dihapus!");
                loadData();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // AMBIL DATA DARI TABEL KE FORM
    private void isiForm() {
        int row = table.getSelectedRow();
        idSelected = Integer.parseInt(model.getValueAt(row, 0).toString());
        txtNama.setText(model.getValueAt(row, 1).toString());
        txtAlamat.setText(model.getValueAt(row, 2).toString());
        txtHp.setText(model.getValueAt(row, 3).toString());
        cmbJenis.setSelectedItem(model.getValueAt(row, 4).toString());
        txtEmail.setText(model.getValueAt(row, 5).toString());
        txtTanggal.setText(model.getValueAt(row, 6).toString());
        cmbStatus.setSelectedItem(model.getValueAt(row, 7).toString());
    }

    // RESET FORM
    private void resetForm() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtHp.setText("");
        cmbJenis.setSelectedIndex(0);
        txtEmail.setText("");
        txtTanggal.setText(LocalDate.now().toString());
        cmbStatus.setSelectedIndex(0);
        idSelected = -1;
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMemberPerpus().setVisible(true));
    }
}