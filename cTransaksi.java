
package pkgUAS;


public class cTransaksi {
    String kode;
    String pembeli;
    cBarang barang;
    int jumlahbrg;
    int status;
    cTransaksi next;
  cTransaksi (String k, String p, cBarang b, int j, int s){
        kode=k; pembeli=p; barang=b; jumlahbrg=j; status=s;
        next=null;
    }
  public void setstatus(int s){
      status=s;
    }
  public String getKode(){
    return kode;
    }
  public String getPembeli(){
      return pembeli;
    }
  public cBarang getBarang(){
      return barang;
    }
  public int getJumlah(){
      return jumlahbrg;
    }
  public int getStatus(){
      return status;
   }
}
