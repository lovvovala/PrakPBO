import javax.swing.*;
import java.awt.event.*;
public class Latihankeempat {
   public static void main(String[] args) {
    JFrame frame = new JFrame("Variasi Tombol");
    frame.setSize(600, 400);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label1 = new JLabel("Masukkan Nama:");
    label1.setBounds(10, 10, 150, 20);
    frame.add(label1);

    JTextField textField1 = new JTextField();
    textField1.setBounds(20, 40, 150, 20);
    frame.add(textField1);

    JLabel label2 = new JLabel("Masukkan Umur:");
    label2.setBounds(10, 70, 150, 20);
    frame.add(label2);

    JTextField textField2 = new JTextField();
    textField2.setBounds(20, 100, 150, 20);
    frame.add(textField2);

    // ==================================================
    JButton button1 = new JButton("Tampilkan");
    button1.setBounds(20, 130, 150, 20);
    frame.add(button1);

    JButton button2 = new JButton("Hapus");
    button2.setBounds(20, 160, 150, 20);
    frame.add(button2);

    JButton button3 = new JButton("Kosongkan");
    button3.setBounds(20, 190, 150, 20);
    frame.add(button3);

    JButton button4 = new JButton("Keluar");
    button4.setBounds(20, 220, 150, 20); 
    frame.add(button4);

    //=================================================
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = textField1.getText();
            String umur = textField2.getText();
            JOptionPane.showMessageDialog(frame, "Nama: " + nama + "\nUmur: " + umur);
        }
    });
    
    button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("");
            textField2.setText("");
        }
    });
    
    button3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("");
            textField2.setText("");
        }
    });
    
    button4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    frame.setVisible(true);
   } 
}
