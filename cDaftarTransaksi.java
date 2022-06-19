
package pkgUAS;


public class cDaftarTransaksi {
  cTransaksi front,rear;
  int jumlah;
  cDaftarTransaksi(){
      front=rear=null;
      jumlah=0;
  }
  public cTransaksi getFront(){
    return front;  
  }
  public cTransaksi getrear(){
      return rear;
  }
  public void tambahTransaksi(cTransaksi baru){
      if (rear==null) {
         front=rear=baru; 
      }
      else{
          rear.next=baru;
          rear=baru;
      }
      System.out.println("Penambahan Sukses...");
  }
  public void lihattransaksi(){
      int i=1;
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\t\t\t\t\tDaftar Transaksi\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\tNo\t|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|\tStatus\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      for (cTransaksi t=front; t!=null; t=t.next) {
          System.out.print("|\t"+i+"\t|");
          System.out.print("\t"+t.getKode()+"\t|");
          System.out.print("\t"+t.getPembeli()+"\t|");
          System.out.print("\t"+t.barang.getNama()+"\t|");
          System.out.print("\t"+t.getJumlah()+"\t|");
          System.out.println("\t"+t.getStatus()+"\t|");
          System.out.println(" ---------------------------------------------------------------------------------------------------");
          i++;
      }
      
  }
  public void lihatTransaksiMember(){
       int i=1;
      double total=0,diskon;
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\t\t\t\t\tDaftar Transaksi\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\tNo\t|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|\tStatus\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      for (cTransaksi t=front; t!=null; t=t.next) {
          System.out.print("|\t"+i+"\t|");
          System.out.print("\t"+t.getKode()+"\t|");
          System.out.print("\t"+t.getPembeli()+"\t|");
          System.out.print("\t"+t.getBarang().getNama()+"\t|");
          System.out.print("\t"+t.getJumlah()+"\t|");
          System.out.println("\t"+t.getStatus()+"\t|");
          System.out.println(" ---------------------------------------------------------------------------------------------------");
          i++;
          total=total+(t.getBarang().getHarga()*t.getJumlah());
          
      }
      System.out.println("| Total Belanja  : "+total+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("| Diskon 5%      : "+(0.05*total)+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("| jumlah dibayar : "+(total-(0.05*total))+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      
  }
  public void hapusTransaksi(int nomor){
          cTransaksi t=front;
          cTransaksi prev=null;
          int i=1;
          if (nomor==1) {
            if(t.next==null){
              front=rear=null;
             }
            else{
                front=front.next;
                t.next=null;
            }
              System.out.println("[\t"+t.getBarang().getNama()+"]  dihapus....");
          }
          else{
              for (;t!=null ;t=t.next) {
                  if (i==nomor) {
                      break;
                  }
                  i++;
                  prev=t;
              }//dihapus diujung belakang
              if (t.next==null) {
                  rear=prev;
                  rear.next=null;
              }
              else{
                  prev.next=t.next;
                  t.next=null;
              }
              System.out.println("["+t.getBarang().getNama()+"]  dihapus..");
          }
      }
  public void sambungTransaksi(cTransaksi depan,cTransaksi belakang){
     //sambungkan transaksi
      
      if (rear==null) {//transaksi toko masih kosong
          front=depan;
          rear=belakang;
      }else{
          rear.next=depan;
          //update posisi rear
          rear=belakang; 
      }
      
     
  }
  public void prosesTransaksi(cTransaksi t){
     //cek member
      t.setstatus(1);
  }
  public void prosesTransaksimember(cTransaksi t){
      //mendapatkan diskon
  }
  public double lihatpemasukan(){
      cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
          if (t.getStatus()==1) {
              //cek member berdasarkan data nama/kode pembeli
              nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
              //System.out.println("Kode"+t.getKode());
              if (t.getPembeli().compareToIgnoreCase("10")==0||t.getPembeli().compareToIgnoreCase("11")==0||t.getPembeli().compareToIgnoreCase("12")==0) {
                  System.out.println("Member!");
                  nominal=nominal-(0.1*nominal); 
              }
             
          }
      }
      return nominal;
  }
  public int lihatdiproses(){
       cTransaksi t=front;
      int proses=0;
      for (; t!=null; t=t.next) {
          if (t.getStatus()==1) {
              proses++;
          }
      }
      return proses;
  }
}

