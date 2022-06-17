
package pkgprojectUAS;

import pkgRef.cTransaksi;


public class cProsesTransaksi {
    cTraansaksi front, rear;
    int jumlah;
  cProsesTransaksi(){
      front=rear=null;
      jumlah=0;
  }
  public cTraansaksi getFront(){
      return front;
  }
  public cTraansaksi getRear(){
      return rear;
  }
  public void AddTransaksi(cTraansaksi baru){
      if (rear==null) {
          rear=front=baru;
      }else{
          rear.next=baru;
          rear=baru;
      }
      System.out.println("Penambahan sukses");
  }
  public void showTransaksi(){
      int i=1;
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\t\t\t\t\tDaftar Transaksi\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\tNo\t|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|\tStatus\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      for (cTraansaksi t=front; t!=null; t=t.next) {
          System.out.print("|\t"+i+"\t|");
          System.out.print("\t"+t.getKode()+"\t|");
          System.out.print("\t"+t.getpembeli()+"\t|");
          System.out.print("\t"+t.getItem().getName()+"\t|");
          System.out.print("\t"+t.getjumlahbrg()+"\t|");
          System.out.println("\t"+t.getStatus()+"\t|");
          System.out.println(" ---------------------------------------------------------------------------------------------------");
          i++;
      }
  
  }
  public void showTransaksimember(){
      int i=1;
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\t\t\t\t\tDaftar Transaksi\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\tNo\t|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|\tStatus\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      for (cTraansaksi t=front; t!=null; t=t.next) {
          System.out.print("|\t"+i+"\t|");
          System.out.print("\t"+t.getKode()+"\t|");
          System.out.print("\t"+t.getpembeli()+"\t|");
          System.out.print("\t"+t.getItem().getName()+"\t|");
          System.out.print("\t"+t.getjumlahbrg()+"\t|");
          System.out.println("\t"+t.getStatus()+"\t|");
          System.out.println(" ---------------------------------------------------------------------------------------------------");
          i++;
      }
  
  }
  public void deleteTransaksi(int nomor){
      cTraansaksi t=front;
      cTraansaksi prev=null;
      int i=1;
      if (nomor==1) {
            if(t.next==null){
              front=rear=null;
             }
            else{
                front=front.next;
                t.next=null;
            }
              System.out.println("["+t.getItem().getName()+"]  dihapus..");
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
              System.out.println("["+t.getItem().getName()+"]  dihapus..");
          }
  }
   public void sambungTransaksi(cTraansaksi depan,cTraansaksi belakang){
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
     public int lihatPemasukan(){
      cTraansaksi t = front;
      int nominal = 0;
      for (; t!=null; t=t.next) {
          if (t.getStatus()==1) {
              nominal=nominal+t.getBarang().getPrice()*t.getjumlahbrg();
          }
      }
      return nominal;
  }

  public int lihatdiproses(){
       cTraansaksi t=front;
      int proses=0;
      for (; t!=null; t=t.next) {
          if (t.getStatus()==1) {
              proses++;
          }
      }
      return proses;
  }
}
