import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View {
    public static Scanner input = new Scanner(System.in);
    
  
  public static void createTable() {
    // Memanggil method dari kelas Config untuk menciptakan tabel
    Config.createTransaksiTable();
    System.out.println("Tabel transaksi berhasil dibuat.");
    System.out.println("\nTekan Enter untuk melanjutkan...");
    try {
        System.in.read();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  
  public static void tambahData() {
    Date HariSekarang = new Date();
    Scanner scanner = new Scanner(System.in);

    System.out.print("input invoiceNumber: ");
    String invoiceNumber = scanner.nextLine();

    System.out.print("imput customerName: ");
    String customerName = scanner.nextLine();

    System.out.print("imput NoHP: ");
    String NoHP = scanner.nextLine();

    System.out.print("input Address: ");
    String address = scanner.nextLine();

    System.out.print("input itemName: ");
    String itemName = scanner.nextLine();

    System.out.print("input price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();

    System.out.print("input quantity: ");
    int quantity = scanner.nextInt();
    scanner.nextLine();

    Faktur invoice = new Faktur(invoiceNumber, customerName, itemName, price, quantity, NoHP, address);
    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
    
    System.out.println("============MINIMARKET============");
    System.out.println("Tanggal \t\t: " + ft.format(HariSekarang));
    System.out.println("Waktu\t\t\t: " + format.format(HariSekarang));
    System.out.println("Nomor Faktur\t\t: " + invoice.getInvoiceNumber());
    System.out.println("==========Data Pelanggan==========");
    System.out.println("Nama Pelanggan\t\t: " + invoice.getCustomerName());
    System.out.println("No Handphone\t\t: " + invoice.getnoHP());
    System.out.println("Alamat\t\t\t: " + invoice.getaddress());
    System.out.println("============Data Barang============");
    System.out.println("Nama Barang\t\t: " + invoice.getItemName());
    System.out.println("Harga Barang\t\t: " + invoice.getPrice());
    System.out.println("Jumlah Barang\t\t: " + invoice.getQuantity());
    System.out.println("Total Bayar\t\t: " + invoice.calculateTotal());
    System.out.println("===============Kasir===============");
    String myString = "Nabil";
    String uppercaseString = myString.toUpperCase();
    System.out.println("Kasir\t\t\t: " + uppercaseString);

    if (Config.tambahData(invoiceNumber, customerName, itemName, price, quantity, NoHP, address)) {
        System.out.println("Data Barang berhasil ditambahkan!!");
        
        // Menunggu pengguna menekan Enter sebelum melanjutkan
        System.out.println("\nTekan Enter untuk melanjutkan...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        View.getAllData(); // Menampilkan semua data setelah menambahkan
    } else {
        System.out.println("Data Barang gagal ditambahkan!!");
    }

    scanner.close();
}
    public static void getAllData()
  {
    //  pesan header
    System.out.println("\n::: DATA BARANG :::");
    // data semua barangnya
    System.out.println(Config.getAllData());
  }

  public static void deleteData()
  {
    System.out.println("\n:::DELETE DATA BARANG :::");
    System.out.print("Masukkan ID Barang : ");
    int invoiceNumber = input.nextInt();

    if( Config.deleteData(invoiceNumber) ){
      System.out.println("Data Barang Berhasil Dihapus!!");
      getAllData();
    }else{
      System.out.println("Data Barang Gagal Dihapus!!");
    }

  }

  public static void updateData()
  {
    System.out.println("\n::: UPDATE DATA BARANG :::");
    System.out.print("Masukkan invoiceNumber : ");
    int invoiceNumber = input.nextInt();
    System.out.println("\nGanti Data Barang\n");
    System.out.print("Nama Barang (Kosongkan jika tidak ingin mengganti datanya) : ");
    String itemName = input.nextLine();
    itemName = input.nextLine();

    System.out.print("Banyak Barang (isi 0 jika tidak ingin merubah data) : ");
    int quantity = input.nextInt();
    
    System.out.print("Harga Barang (isi 0 jika tidak ingin merubah data) : ");
    int price = input.nextInt();

    if( Config.updateData(invoiceNumber, itemName, quantity, price) ){
      System.out.println("Data barang berhasil dirubah!!");
      View.getAllData();
    }else{
      System.out.println("Data barang gagal dirubah!!");
    }

  }
}
