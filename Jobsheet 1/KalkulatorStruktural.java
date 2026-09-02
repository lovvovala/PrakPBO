import java.util.Scanner;

public class KalkulatorStruktural {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka pertama: ");
        double angka1 = input.nextDouble();

        System.out.print("Masukkan operator (+, -, *, /): ");
        char operator = input.next().charAt(0);

        System.out.print("Masukkan angka kedua: ");
        double angka2 = input.nextDouble();

        double hasil = hitung(angka1, operator, angka2);
        System.out.println("Hasil: " + hasil);
        
        input.close();
    }

    
    public static double hitung(double a, char op, double b) {
        double hasil = 0;
        switch (op) {
            case '+': hasil = a + b; break;
            case '-': hasil = a - b; break;
            case '*': hasil = a * b; break;
            case '/': hasil = a / b; break;
            default: System.out.println("Operator tidak valid!");
        }
        return hasil;
    }
}