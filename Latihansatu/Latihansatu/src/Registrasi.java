import javax.swing.*;
import java.awt.event.*;
public class Registrasi {
   public static void main(String[] args) {
    JFrame frame = new JFrame("Form Registrasi Mahasiswa");
    frame.setSize(700, 500);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label1 = new JLabel("Nama:");
    label1.setBounds(10, 10, 150, 20);
    frame.add(label1);

    JTextField textField1 = new JTextField();
    textField1.setBounds(20, 40, 150, 20);
    frame.add(textField1);

    JLabel label2 = new JLabel("NIM:");
    label2.setBounds(10, 70, 150, 20);
    frame.add(label2);

    JTextField textField2 = new JTextField();
    textField2.setBounds(20, 100, 150, 20);
    frame.add(textField2);

    JLabel label3 = new JLabel("Prodi:");
    label3.setBounds(10, 130, 150, 20);
    frame.add(label3);

    JTextField textField3 = new JTextField();
    textField3.setBounds(20, 160, 150, 20);
    frame.add(textField3);

    JLabel label4 = new JLabel("Alamat:");
    label4.setBounds(10, 190, 150, 20);
    frame.add(label4);

    JTextField textField4 = new JTextField();
    textField4.setBounds(20, 220, 150, 20);
    frame.add(textField4);

    JLabel label5 = new JLabel("Asal Sekolah:");
    label5.setBounds(10, 250, 150, 20);
    frame.add(label5);

    JTextField textField5 = new JTextField();
    textField5.setBounds(20, 280, 150, 20);
    frame.add(textField5);

    JButton button1 = new JButton("Simpan");
    button1.setBounds(20, 310, 150, 20);
    frame.add(button1);

    JButton button2 = new JButton("Reset");
    button2.setBounds(20, 340, 150, 20);
    frame.add(button2);

    JTextArea textArea = new JTextArea();
    textArea.setBounds(200, 40, 350, 200);
    textArea.setEditable(false);
    frame.add(textArea);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = textField1.getText();
            String nim = textField2.getText();
            String prodi = textField3.getText();
            String alamat = textField4.getText();
            String asalSekolah = textField5.getText();
            textArea.setText("Nama: " + nama + "\nNIM: " + nim + "\nProdi: " + prodi + "\nAlamat: " + alamat + "\nAsal Sekolah: " + asalSekolah);

            // VALIDASI INPUT KOSONG
            if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty() || alamat.isEmpty() || asalSekolah.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Hentikan eksekusi jika ada field kosong
            } 

            // Jika valid: tampilkan data
            textArea.setText("Data berhasil disimpan:\n");
            textArea.append("Nama: " + nama + "\n");
            textArea.append("NIM :" + nim + "\n");
            textArea.append("Prodi: " + prodi + "\n");
            textArea.append("Alamat: " + alamat + "\n");
            textArea.append("Asal Sekolah: " + asalSekolah + "\n");

            JOptionPane.showMessageDialog(frame, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    });

    button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textArea.setText("");

        }
    });
    frame.setVisible(true);
   }
}
