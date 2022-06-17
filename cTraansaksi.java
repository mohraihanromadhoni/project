

package pkgprojectUAS;


public class cTraansaksi {
    
    String kode;
    String pembeli;
    cItem barang;
    int jmlbrg;
    int status;
    cTraansaksi next;
    cTraansaksi(String k,String p,cItem b,int jml,int s){
        kode=k; pembeli=p; barang=b; jmlbrg=jml; status=s;
        next=null;
    }
    public void setStatus(int s){
        s=status;
    }
    public String getKode(){
        return kode;
    }
    public String getpembeli(){
        return pembeli;
    }
    public cItem getItem(){
        return barang;
    }
    public int getjumlahbrg(){
        return jmlbrg;
    }
    public int getStatus(){
        return status;
    }
    
    
}

