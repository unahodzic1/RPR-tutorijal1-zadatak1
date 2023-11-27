package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class KolekcijaImenaIPrezimena implements IKolekcijaImena {
    private List<String> imena;
    private List<String> prezimena;

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    // metode

    public int getIndexNajduzegPara(){
        int vrati = 0;
        for(int i = 0; i < imena.size(); i++){
            if(imena.get(i).length() + prezimena.get(i).length() > imena.get(vrati).length() + prezimena.get(vrati).length()){
                vrati = i;
            }
        }

        return vrati;
    }

    public String getImeiPrezime(int index){
        return imena.get(index) + " " + prezimena.get(index);
    }

    @Override
    public String getNajduzeIme(){
        int indeks = getIndexNajduzegPara();
        return imena.get(indeks) + " " + prezimena.get(indeks);
    }

}
