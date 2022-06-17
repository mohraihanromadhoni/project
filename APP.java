
package pkgprojectUAS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;
public class APP {
    public static void main(String[] args) {
        Scanner ac=new Scanner(System.in);
        //daftar barang
        cItem itm1= new cItem("gula    ",12000);
        cItem itm2= new cItem("kecap   ",7000);
        cItem itm3= new cItem("beras   ",15000);
        cItem itm4= new cItem("ketumbar",10000);
        cItem itm5= new cItem("jahe    ",8000);
        
        //id & password member
        int id1 = 21001, pass1 = 1234;
        int id2 = 21002, pass2 = 2345;
        int id3 = 21003, pass3 = 3456;
        int username, password;
        //membuat kode transaksi menggunakan tanggal dan bulan
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("MMdd");
        String formatdate = date.format(mydate);
        
        cProsesTransaksi jual = new cProsesTransaksi();
        int pilih=0, pilih1=0,pilih2=0,pilih3=0,pilih4=0;
        int jumlah=0;
        int kode=0;
        do{
            System.out.println("");
            System.out.println("\n App toko");
            System.out.println("1.Pembeli");
            System.out.println("2.Member");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("Pilih : ");
            pilih=ac.nextInt();
            switch(pilih){
                case 1://pembeli
                    kode++;
                    String kd=formatdate+String.valueOf(kode);
                    cProsesTransaksi beli = new cProsesTransaksi();
                    System.out.print("Masukkan Nama : ");
                    String nm = ac.next();
                    do{
                        System.out.println("\nAkun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Exit");
                        System.out.print("Pilih : ");
                        pilih1=ac.nextInt();
                        switch(pilih1){
                            case 1://tambah
                                cTraansaksi js = null;
                                System.out.println("\n Daftar Barang");
                                System.out.println("1.Gula");
                                System.out.println("2.Kecap");
                                System.out.println("3.Beras");
                                System.out.println("4.Ketumbar");
                                System.out.println("5.Jahe");
                                System.out.print("Pilih : ");
                                pilih2=ac.nextInt();
                                System.out.print("Jumlah :");
                                jumlah=ac.nextInt();
                                
                                switch(pilih2){
                                    case 1:                                     
                                        js = new cTraansaksi(kd,nm,itm1,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                       break;
                                    case 2:
                                        js = new cTraansaksi(kd,nm,itm2,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                       break;
                                    case 3:
                                        js = new cTraansaksi(kd,nm,itm3,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;
                                    case 4:
                                        js = new cTraansaksi(kd,nm,itm4,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;
                                    case 5:
                                        js = new cTraansaksi(kd,nm,itm5,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;    
                                    default:
                                        System.out.println("Pilihan Tidak Ada!!");
                                        break;
                                }
                                beli.AddTransaksi(js);
                                break;
                            case 2://hapus
                                beli.showTransaksi();
                                System.out.print("Pilih Nomor : ");
                                int hapus=ac.nextInt();
                                beli.deleteTransaksi(hapus);
                                break;
                            case 3://lihat
                                beli.showTransaksi();
                                break;
                            case 4://exit
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("selamat datang kembali");
                                break;
                        }
                    }while(pilih1!=4);
                    break;
                case 2://member
                    System.out.println("Akun Member");
                    System.out.println("1.Transaksi");
                    System.out.println("2.Ubah password");
                    System.out.print("Pilih : ");
                    pilih3=ac.nextInt();
                    if (pilih3==1) {
                     boolean cek = false;
                    do{
                        System.out.print("ID: ");
                        username = ac.nextInt();
                        System.out.print("PASSWORD :");
                        password = ac.nextInt();
                        if (username==id1 && password==pass1) {
                            cek=true;
                        }else if (username==id2 && password==pass2) {
                            cek=true;
                        }else if (username==id3 && password==pass3) {
                            cek=true;
                        }
                         if (cek == false) {
                            System.out.println("ID/PIN salah!");
                        } else {
                            break;
                        }
                        
                    }while(cek==false); 
                     if (cek == true) {
                            System.out.println("Selamat datang...");
                        }
                     kode++;
                     kd=formatdate+String.valueOf(kode);
                     beli = new cProsesTransaksi();
                    
                    do{
                        System.out.println("\nAkun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Exit");
                        System.out.print("Pilih : ");
                        pilih1=ac.nextInt();
                        switch(pilih1){
                            case 1://tambah
                                cTraansaksi js = null;
                                System.out.println("\n Daftar Barang");
                                System.out.println("1.Gula");
                                System.out.println("2.Kecap");
                                System.out.println("3.Beras");
                                System.out.println("4.Ketumbar");
                                System.out.println("5.Jahe");
                                System.out.print("Pilih : ");
                                pilih2=ac.nextInt();
                                System.out.print("Jumlah :");
                                jumlah=ac.nextInt();
                                
                                switch(pilih2){
                                    case 1:                                     
                                        js = new cTraansaksi(kd,String.valueOf(username),itm1,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                       break;
                                    case 2:
                                        js = new cTraansaksi(kd,String.valueOf(username),itm2,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                       break;
                                    case 3:
                                        js = new cTraansaksi(kd,String.valueOf(username),itm3,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;
                                    case 4:
                                        js = new cTraansaksi(kd,String.valueOf(username),itm4,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;
                                    case 5:
                                        js = new cTraansaksi(kd,String.valueOf(username),itm5,jumlah,0);
                                        System.out.println("Penambahan sukses");
                                        break;    
                                    default:
                                        System.out.println("Pilihan Tidak Ada!!");
                                        break;
                                }
                                beli.AddTransaksi(js);
                                break;
                            case 2://hapus
                                beli.showTransaksi();
                                System.out.print("Pilih Nomor : ");
                                int hapus=ac.nextInt();
                                beli.deleteTransaksi(hapus);
                                break;
                            case 3://lihat
                                beli.showTransaksi();
                                break;
                            case 4://exit
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("selamat datang kembali");
                                break;
                        }
                      }while(pilih1!=4);
                    }else if (pilih3==2) {
                        
                    }
                    
                    break;
                case 3://admin
                    break;
                case 4://pemilik
                    System.out.println("    Transaksi Diproses : " +jual.lihatdiproses());
                    System.out.println("    Pemasukan : " +jual.lihatPemasukan());
                    break;
                case 5://kembali
                    break;
            }
        }while(pilih!=5);
    }
}
