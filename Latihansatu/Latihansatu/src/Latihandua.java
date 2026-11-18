import javax.swing.*;
import java.awt.event.*;
public class Latihandua {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Saya");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Masukkan Nama:");
        label.setBounds(10, 10, 150, 20);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(20, 40, 150, 20);
        frame.add(textField);

        JButton button = new JButton("Tampilkan Nama");
        button.setBounds(20, 70, 150, 20);
        frame.add(button);
      
        JLabel lblHasil = new JLabel("Hasil: -");
        lblHasil.setBounds(20, 100, 150, 20);
        frame.add(lblHasil);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                lblHasil.setText("Hasil: " + nama);
            }
        });

        frame.setVisible(true);
    }
}
