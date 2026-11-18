import javax.swing.*;
import java.awt.event.*;

public class Latihanlima {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel judul = new JLabel("KALKULATOR");
        judul.setBounds(160, 15, 150, 25);
        frame.add(judul);

        JLabel label1 = new JLabel("Angka 1:");
        label1.setBounds(30, 55, 100, 25);
        frame.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(130, 55, 220, 25);
        frame.add(textField1);

        JLabel label2 = new JLabel("Angka 2:");
        label2.setBounds(30, 95, 100, 25);
        frame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(130, 95, 220, 25);
        frame.add(textField2);

        JLabel label3 = new JLabel("Hasil:");
        label3.setBounds(30, 135, 100, 25);
        frame.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(130, 135, 220, 25);
        textField3.setEditable(false); // Agar hasil tidak bisa diedit manual
        frame.add(textField3);

        // ==================================================
        // Penataan tombol rapi 2 baris (masing-masing 3 tombol)
        JButton button1 = new JButton("Tambah");
        button1.setBounds(30, 185, 100, 30);
        frame.add(button1);

        JButton button2 = new JButton("Kurang");
        button2.setBounds(145, 185, 100, 30);
        frame.add(button2);

        JButton button3 = new JButton("Kali");
        button3.setBounds(260, 185, 100, 30);
        frame.add(button3);

        JButton button4 = new JButton("Bagi");
        button4.setBounds(30, 230, 100, 30);
        frame.add(button4);

        JButton button5 = new JButton("Reset");
        button5.setBounds(145, 230, 100, 30);
        frame.add(button5);

        JButton button6 = new JButton("Keluar");
        button6.setBounds(260, 230, 100, 30);
        frame.add(button6);

        // ==================================================
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cek Reset & Keluar DULU sebelum membaca angka agar tidak error saat kolom kosong
                if (e.getSource() == button5) {
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    return;
                } else if (e.getSource() == button6) {
                    System.exit(0);
                }

                // Blok try-catch untuk menangkap error jika input kosong atau bukan angka
                try {
                    double angka1 = Double.parseDouble(textField1.getText());
                    double angka2 = Double.parseDouble(textField2.getText());
                    double hasil = 0;

                    if (e.getSource() == button1) {
                        hasil = angka1 + angka2;
                    } else if (e.getSource() == button2) {
                        hasil = angka1 - angka2;
                    } else if (e.getSource() == button3) {
                        hasil = angka1 * angka2;
                    } else if (e.getSource() == button4) {
                        hasil = angka1 / angka2;
                    }

                    textField3.setText(String.valueOf(hasil));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid. Harap masukkan angka.");
                }
            }
        };

        // Daftarkan actionListener ke semua tombol agar bisa diklik
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);

        frame.setVisible(true);
    }
}