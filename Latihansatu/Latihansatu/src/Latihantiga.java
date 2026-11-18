import javax.swing.*;
import java.awt.event.*;
public class Latihantiga {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dua Input Text Field");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tambahkan input text field pertama
        JLabel label = new JLabel("Masukkan Nama:");
        label.setBounds(10, 10, 150, 20);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(20, 40, 150, 20);
        frame.add(textField);

        // Tambahkan input text field kedua
        JLabel label2 = new JLabel("Masukkan Umur:");
        label2.setBounds(10, 130, 150, 20);
        frame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(20, 160, 150, 20);
        frame.add(textField2);

        JButton button = new JButton("Tampilkan Nama dan Umur");
        button.setBounds(20, 190, 200, 20);
        frame.add(button);

        JLabel lblHasil = new JLabel("Hasil: -");
        lblHasil.setBounds(20, 220, 300, 20);
        frame.add(lblHasil);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String umur = textField2.getText();
                lblHasil.setText("Hasil: Nama - " + nama + ", Umur - " + umur);
            }
        });

        frame.setVisible(true);
    }
}

