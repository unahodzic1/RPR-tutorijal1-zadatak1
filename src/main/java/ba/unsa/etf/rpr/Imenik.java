package ba.unsa.etf.rpr;
import java.util.*;

public class Imenik {
    private Map<String,TelefonskiBroj> brojevi = new HashMap<String, TelefonskiBroj>();

    public void dodaj(String ime,TelefonskiBroj broj){this.brojevi.put(ime,broj);}

    String dajBroj(String ime){
        TelefonskiBroj br = this.brojevi.get(ime);
        if(br == null) return null;
        return br.ispisi();
    }
    String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> m : this.brojevi.entrySet())//kolekcija svih elemenata u mapi kao uređeni par str br
            if(m.getValue().ispisi().equals(broj.ispisi()))return m.getKey();//posto nema compare metoda s ispisom se provj jesul isti br
        return null;
    }
    String naSlovo(char s){
        StringBuilder bulider = new StringBuilder();
        int i = 1;
        for(Map.Entry<String,TelefonskiBroj> m : this.brojevi.entrySet()) {
            if (m.getKey().startsWith(String.valueOf(s))) {
                bulider.append(i).append(". ").append(m.getKey()).append(" - ").append(m.getValue().ispisi()).append(System.lineSeparator());
            }
            i++;
        }
        return bulider.toString();
    }
    Set<String> izGrada(Grad g){
        Set<String> s = new TreeSet<String>();//TreeSet impl seta daje sortirano po abecedi, kako se el dodaju tako ih oni i sortiraju nevazan nacin unosa
        for(Map.Entry<String, TelefonskiBroj> m : this.brojevi.entrySet())
            if(jeLiIzGrada(m.getValue(), g)) s.add(m.getKey());

        return s;
    }
    Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> s = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>(){
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });

        for(Map.Entry<String, TelefonskiBroj> m : this.brojevi.entrySet()){
            if(jeLiIzGrada(m.getValue(),g))s.add(m.getValue());
        }
        return s;
    }

    private boolean  jeLiIzGrada(TelefonskiBroj br, Grad g){
        if (br instanceof FiksniBroj)return g.equals(((FiksniBroj)br).getGrad());// da bi bio iz gr mora biti fiksni br
        return false;
    }

    public Map<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }

    public void setBrojevi(Map<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }
    @Override
    public String toString()
    {
        StringBuilder s=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String, TelefonskiBroj> m: this.brojevi.entrySet())
        {
            s.append(brojac).append(". ")
                    .append(m.getKey())
                    .append(" - ")
                    .append(m.getValue().ispisi())
                    .append(System.lineSeparator());
            brojac++;
        }
        return s.toString();
    }

}
