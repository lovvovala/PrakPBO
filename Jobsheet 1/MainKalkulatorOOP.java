import java.util.Scanner;

class Kalkulator {
    double angka1;
    double angka2;
    char operator;

    // Method untuk mengatur input
    public void setInput(double a1, char op, double a2) {
        this.angka1 = a1;
        this.operator = op;
        this.angka2 = a2;
    }

    // Method untuk memproses perhitungan
    public double hitung() {
        switch (this.operator) {
            case '+': return this.angka1 + this.angka2;
            case '-': return this.angka1 - this.angka2;
            case '*': return this.angka1 * this.angka2;
            case '/': return this.angka1 / this.angka2;
            default: 
                System.out.println("Operator tidak valid!");
                return 0;
        }
    }
}

public class MainKalkulatorOOP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Membuat objek kalkulator
        Kalkulator kal = new Kalkulator(); 

        System.out.println("Masukkan Angka 1, Operator (+ - * /), dan Angka 2 (pisahkan dengan Enter):");
        kal.setInput(input.nextDouble(), input.next().charAt(0), input.nextDouble());
        
        // Objek kalkulator memproses datanya sendiri
        System.out.println("Hasil: " + kal.hitung());
        
        input.close();
    }
}