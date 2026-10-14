// User Profile class
class UserProfile{
    private int userId;
    private String password;
    private String name;
    private int age;
    private String emailId;
    private String doc;

    public UserProfile(int userId, String password, String name, int age, String emailId, String doc) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.doc = doc;
    }

    // Getter methods
    public int getUserId() {return userId;}
    public String getPassword() {return password;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getEmailId() {return emailId;}

    public void editProfile() {
        System.out.println("Profil " + name + " telah diperbarui.");
    }

    public void showDocuments() {
        System.out.println("Menampilkan dokumen milik " + name + ": " + doc);
    }
}

// Parent Class User
class User {
    protected UserProfile profile;

    public User(UserProfile profile) {
        this.profile = profile;
    }

    public void logIn(int userId, String password) {
        if (profile.getUserId() == userId && profile.getPassword().equals(password)) {
            System.out.println("Login berhasil. Selamat datang, " + profile.getName() + ".");
        } else {
            System.out.println("Login gagal. ID atau password salah.");
        }
    }

    public void recoverPassword() {
        System.out.println("Link pemulihan password telah dikirim ke " + profile.getEmailId());
    }

    public void logOut() {
        System.out.println(profile.getName() + " telah  berhasi log out.");
    }
}

// Child Class Customer
class Customer extends User {
    private boolean verification_status = false;

    public Customer(UserProfile profile) {
        super(profile);
    }

    public boolean getVerificationStatus() {
        return verification_status;
    }

    public void applyVerification(String doc) {
        System.out.println(profile.getName() + " mengajukan verifikasi dengan dokumen: " + doc);
        this.verification_status = true; // simulasi disejutui
    }
}


// Child Class Admin
class Admin extends User {
    public Admin(UserProfile profile) {
        super(profile);
    }

    public void updateVehicleDetails(int vehicle_id){
        System.out.println("Admin " + profile.getName() + " memperbarui detail kendaraan dengan ID: " + vehicle_id);
    }

    public void addVehicle(int vehicle_id){
        System.out.println("Admin " + profile.getName() + " menambahkan kendaraan baru ke dalam database armada");
    }

    public void retrieveComplaint(){
        System.out.println("Admin " + profile.getName() + " memeriksa daftar keluhan pelanggan");
    }

    public void verifyUser(){
        System.out.println("Admin " + profile.getName() + " memverifikasi akun Customer");
    }


}

// Main class
public class DemoSistemKendaraan {
    public static void main(String[] args) {
        // Membuat UserProfile
        UserProfile customerProfile = new UserProfile(101, "nindyacantik", "Nindya", 16, "nindya@email.com", "KartuPelajar_Nindya.pdf");
        UserProfile adminProfile = new UserProfile(777, "adminrahma", "Rahma Imoet", 14, "admin@email.com", "ID_Karyawan.pdf");

        System.out.println("=== DEMO CUSTOMER ===");
        Customer customer = new Customer(customerProfile);
        customer.logIn(101, "nindyacantik");
        customer.applyVerification("KartuPelajar_Nindya.pdf");
        System.out.println("Status Verifikasi: " + (customer.getVerificationStatus() ));
        customer.logOut();

        System.out.println("\n=== DEMO ADMIN ===");
        Admin admin = new Admin(adminProfile);
        admin.logIn(777, "adminrahma");
        admin.addVehicle(4);
        admin.updateVehicleDetails(4);
        admin.verifyUser();
        admin.logOut();
    }
}   
