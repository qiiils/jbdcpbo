import java.util.Scanner;

public class Transaksi {
    private static String username = "admin";
    private static String password = "admin";
    private static String captcha = "huf";

    public static void main(String[] args) {
        Config.connection();
        
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String un = scanner.nextLine().trim();
        System.out.print("Password: ");
        String pw = scanner.nextLine().trim();

        if (un.equals(username) && pw.equals(password)) {
           
            System.out.print("Masukkan captcha: ");
            String inputCaptcha = scanner.nextLine().trim();

        
            if (inputCaptcha.equalsIgnoreCase(captcha)) {
                System.out.println("Otentikasi berhasil. Selamat datang, " + un + "!");
            
            while(true){

            System.out.print("\n====== MENU ======\n"
            + "1. Buat Table\n"
            + "2. Tambah Transaksi\n"
            + "3. Lihat Data Barang\n"
            + "4. Hapus Data Barang\n"
            + "5. Update Data Barang\n"
            + "0. Exit\n"
            + "Pilih[1/2/3/4/5/0] : ");

            
            String pilihan = scanner.nextLine().trim();

            if( pilihan.equalsIgnoreCase("0") ){
                System.out.println("Terimakasih!!");
                break;
            }

            switch (pilihan) {
                case "1" :
                    try {
                    
                    View.createTable();

                } catch (Exception e) {
                    System.err.println("Input tidak valid. Pastikan input sesuai dengan tipe data yang diminta.");
                } 
                    
                    
                    break;
                case "2" :
                    View.tambahData();
                    break;
                case "3" :
                    View.getAllData();
                    break;
                case "4" :
                    View.deleteData();
                    break;
                case "5" :
                    View.updateData();
                    break;
                default:
                    System.out.println("Pilihan salah!!");
                    break;
                    
            }
                 
        }
         scanner.close();
            } else {
                System.out.println("Captcha tidak valid. Autentikasi gagal.");
            }
        } else {
            System.out.println("Nama pengguna atau kata sandi tidak valid. Autentikasi gagal.");
        }
    }
   
}
