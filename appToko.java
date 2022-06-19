package pkgUAS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class appToko {

    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        //daftar barang yang dijual
        cBarang brg1 = new cBarang("gula    ",10000);
        cBarang brg2 = new cBarang("kecap   ",7000);
        cBarang brg3 = new cBarang("jahe    ",8000);
        cBarang brg4 = new cBarang("kunyit  ",12000);
        cBarang brg5 = new cBarang("beras   ",15000);
        // set kode transaksi mennggunakan localdate
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("MMdd");
        String formatdate = date.format(mydate);
        //daftar member toko
        int id1 = 21001, pwd1 = 1234;
        int id2 = 21002, pwd2 = 2345;
        int id3 = 21003, pwd3 = 3456;
        // id& pass admin
        int pw1 = 1111, pas =2222;
        // id& pass pemilik
        int pw2=321, pas2=333;
        
        int id, pin,idpw,pinpw,idd,pid;
        //daftar antrian transaksi yang masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0, pilih2 = 0, pilih3 = 0,pilih4=0, jumlah = 0;
        int kode = 0;
        do {
            
            System.out.println("\n Aplikasi Toko Maju Sejahtera");
            System.out.println("1.Pembeli");
            System.out.println("2.Member");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("Pilih : ");
            pilih = ac.nextInt();
            switch (pilih) {
                case 1://pembeli
                    kode++;
                    String kd=formatdate+String.valueOf(kode);
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama : ");
                    String nama = ac.next();
                    do {
                        System.out.println("Akun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = ac.nextInt();
                        switch (pilih2) {
                            case 1://tambah
                                cTransaksi br = null;
                                System.out.println("Daftar Barang");
                                System.out.println("1.gula");
                                System.out.println("2.kecap");
                                System.out.println("3.jahe");
                                System.out.println("4.kunyit");
                                System.out.println("5.beras");
                                System.out.print("Pilih = ");
                                pilih3 = ac.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = ac.nextInt();
                                if (pilih3 == 1) {
                                    br = new cTransaksi(kd, nama, brg1, jumlah, 0);
                                } else if (pilih3 == 2) {
                                    br = new cTransaksi(kd, nama, brg2, jumlah, 0);
                                } else if (pilih3 == 3) {
                                    br = new cTransaksi(kd, nama, brg3, jumlah, 0);
                                } else if (pilih3 == 4) {
                                    br = new cTransaksi(kd, nama, brg4, jumlah, 0);
                                } else if (pilih3 == 5) {
                                    br = new cTransaksi(kd, nama, brg5, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                break;

                            case 2://hapus
                                beli.lihattransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = ac.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3://lihat
                                beli.lihattransaksi();
                                break;
                            case 4://kembali
                                //selesai sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getrear());
                                System.out.println("selamat datang kembali");
                                break;
                        }
                    } while (pilih2 != 4);
                    break;
                case 2://member
                    System.out.println("Akun Member ");
                    System.out.println("1.Ubah Password ");
                    System.out.println("2.Transaksi");
                    System.out.println("3.kembali");
                    System.out.print("pilih : ");
                    pilih4=ac.nextInt();
                    switch(pilih4){
                        case 1:
                            break;
                        case 2:
                            boolean valid = false;
                    do {
                        System.out.print("ID = ");
                        id = ac.nextInt();
                        System.out.print("PIN = ");
                        pin = ac.nextInt();
                        if (id == id1 && pin == pwd1) {
                            valid = true;
                        } else if (id == id2 && pin == pwd2) {
                            valid = true;
                        } else if (id == id3 && pin == pwd3) {
                            valid = true;
                        }
                        if (valid == false) {
                            System.out.println("ID/PIN salah!");
                        } else {
                            break;
                        }
                    } while (valid == false);
                    if (valid == true) {
                        System.out.println("selamat datang..");
                    }
                    kode++;
                    beli = new cDaftarTransaksi();

                    do {
                        System.out.println("Akun Member");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = ac.nextInt();
                        switch (pilih2) {
                            case 1://tambah
                                
                                kd=formatdate+String.valueOf(kode);
                                cTransaksi br = null;
                                System.out.println("Daftar Barang");
                                System.out.println("1.gula");
                                System.out.println("2.kecap");
                                System.out.println("3.jahe");
                                System.out.println("4.kunyit");
                                System.out.println("5.beras");
                                System.out.print("Pilih = ");
                                pilih3 = ac.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = ac.nextInt();
                                if (pilih3 == 1) {
                                    br = new cTransaksi(kd, String.valueOf(id), brg1, jumlah, 0);
                                } else if (pilih3 == 2) {
                                    br = new cTransaksi(kd, String.valueOf(id), brg2, jumlah, 0);
                                } else if (pilih3 == 3) {
                                    br = new cTransaksi(kd, String.valueOf(id), brg3, jumlah, 0);
                                } else if (pilih3 == 4) {
                                    br = new cTransaksi(kd, String.valueOf(id), brg4, jumlah, 0);
                                } else if (pilih3 == 5) {
                                    br = new cTransaksi(kd, String.valueOf(id), brg5, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                break;

                            case 2://hapus
                                beli.lihattransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = ac.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3://lihat
                                beli.lihatTransaksiMember();
                                break;
                            case 4://kembali
                                //selesai sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getrear());
                                System.out.println("selamat datang kembali");
                                break;
                        }
                    } while (pilih2 != 4);
                            break;
                        case 3:
                            System.out.println("kembali...");
                            break;
                    }
                    
                    break;
                case 3: //admin
                    System.out.print("Username : ");
                    idd=ac.nextInt();
                    System.out.print("Password : ");
                    pid=ac.nextInt();
                    if (idd==pw1 && pas==pas) {
                         System.out.println("Akun Admin");
                        jual.lihattransaksi();
                        //memproses setiap transaksi yang belum diproses
                        cTransaksi t = jual.getFront();
                        do {
                            if (t.getStatus() == 0) {
                                System.out.println("");
                                System.out.println(" -------------------------------------------------------------------");
                                System.out.println("|\t\t\t\tProses Transaksi\t\t\t|");
                                System.out.println(" -------------------------------------------------------------------");
                                System.out.println("|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|");
                                System.out.println(" -------------------------------------------------------------------");
                                System.out.print("|\t" + t.getKode()+"\t|\t");
                                System.out.print( t.getPembeli()+"\t|\t");
                                System.out.print( t.getBarang().getNama()+"\t|\t");
                                System.out.println( t.getJumlah()+"\t|");
                                System.out.println(" --------------------------------------------------------------------");
                                System.out.println("|\t\t\t---Pilih Aksi---\t\t\t\t|");
                                System.out.println(" --------------------------------------------------------------------");
                                System.out.print("|\t1.Diproses\t\t|");
                                System.out.println("\t\t2.selesai\t\t|");
                                System.out.println(" --------------------------------------------------------------------");
                                System.out.print("Pilih : ");
                                int aksi = ac.nextInt();
                                if (aksi == 1) {
                                    jual.prosesTransaksi(t);
                                    System.out.println("Berhasil Diproses..");
                                } else {
                                    break;
                                }
                            }
                            t = t.next;

                        } while (t != null);
                    }else{
                        System.out.println("username atau password anda salah!!");
                    }
                        
                   
                    break;
                case 4://pemilik
                    System.out.print("username : ");
                    idpw=ac.nextInt();
                    System.out.print("Password : ");
                    pinpw=ac.nextInt();
                    if (idpw==pw2 && pinpw==pas2) {
                        System.out.println("Selamat datang.... ");
                         int pilih5=0;
                         System.out.println("");
                        System.out.println("\nAkun Pemilik");
                        System.out.println("1.Laporan Penjualan");
                        System.out.println("2.Ubah Harga");
                        System.out.println("3.Menu Total");
                        System.out.println("4.belanja pembeli");
                        System.out.println("5.grafik penjualan");
                        System.out.println("6.Kembali");
                        System.out.print("pilih : ");
                        pilih5=ac.nextInt();
                        switch(pilih5){
                            case 1://laporan penjualan
                                System.out.println(" -----------------------------------------------------");
                                System.out.println("|\t\t\tAkun Pemilik\t\t\t|");
                                System.out.println(" -----------------------------------------------------");
                                System.out.println("|\tTransaksi Diproses\t|\tPemasukan\t|");
                                System.out.println(" -----------------------------------------------------");
                                System.out.print("|\t\t" + jual.lihatdiproses()+"\t\t|"); 
                                System.out.println("\t" + jual.lihatpemasukan()+"\t\t|");
                                System.out.println(" -----------------------------------------------------");
                                break;
                            case 2://ubah harga
                                break;
                            case 3://menu total
                                break;
                            case 4://belanja pembeli
                                break;
                            case 5://grafik penjualan
                                break;
                            case 6://kembali
                                System.out.println("kembali....");
                                break;
                        }
                        
                    }else {  
                        System.out.println("username atau password anda salah!!");
                    }
                    break;
                case 5:
                    System.out.println("Terima Kasih...");
                    break;

            }
        } while (pilih != 5);
    }
}
