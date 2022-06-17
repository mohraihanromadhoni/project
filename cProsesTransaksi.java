

package pkgprojectUAS;


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
      double total=0,diskon;
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\t\t\t\t\tDaftar Transaksi\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      System.out.println("|\tNo\t|\tKode\t|\tPembeli\t|\tBarang\t\t|\tJumlah\t|\tStatus\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
      for (cTraansaksi t=front; t!=null; t=t.next) {
          System.out.print("|\t"+i+"\t|");
          System.out.print("\t"+t.getpembeli()+"\t|");
          System.out.print("\t"+t.getpembeli()+"\t|");
          System.out.print("\t"+t.getItem().getName()+"\t|");
          System.out.print("\t"+t.getjumlahbrg()+"\t|");
          System.out.println("\t"+t.getStatus()+"\t|");
          System.out.println(" ---------------------------------------------------------------------------------------------------");
          i++;
          total=total+(t.getItem().getPrice()*t.getjumlahbrg());
          
      }
      System.out.println("| Total Belanja  : "+total+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println("---------------------------------------------------------------------------------------------------");
      System.out.println("| Diskon 5%      : "+(0.05*total)+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println("---------------------------------------------------------------------------------------------------");
      System.out.println("| jumlah dibayar : "+(total-(0.05*total))+"\t\t\t\t\t\t\t\t\t\t|");
      System.out.println(" ---------------------------------------------------------------------------------------------------");
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
  public void prosesTransaksi(cTraansaksi t){
     //cek member
      t.setStatus(1);
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
  public double lihatpemasukan(){
      cTraansaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
          if (t.getStatus()==1) {
              //cek member berdasarkan data nama/kode pembeli
              nominal=nominal+t.getItem().getPrice()*t.getjumlahbrg();
              //System.out.println("Kode"+t.getKode());
              if (t.getpembeli().compareToIgnoreCase("21001")==0||t.getpembeli().compareToIgnoreCase("21002")==0||t.getpembeli().compareToIgnoreCase("21003")==0) {
                  System.out.println("Member!");
                  nominal=nominal-(0.05*nominal); 
              }
             
          }
      }
      return nominal;
  }
}

