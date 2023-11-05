package ba.unsa.etf.rpr.lab3;
import ba.unsa.etf.rpr.lab3.Imenik;
import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

public class Imenik {

    private Map<String, TelefonskiBroj> imenik = new HashMap<>();

    // metode

    public void dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime){
        if(imenik.get(ime) != null){
            return imenik.get(ime).ispisi();
        }
        else return null;
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> x : imenik.entrySet()){
            if(x.getValue().equals(broj)){
                return x.getKey();
            }
        }

        return null;

    }

    public String naSlovo(char slovo){
        StringBuilder vrati = new StringBuilder();

        for(Map.Entry<String, TelefonskiBroj> x : imenik.entrySet()){
            if(x.getKey().charAt(0) == slovo){
                vrati.append(x.getKey()).append(" - ").append(x.getValue().ispisi()).append("\n");
            }
        }

        if(vrati.toString() == null) return null;
        return vrati.toString();

    }

    public Set<String> izGrada(Grad grad){
        Set<String> ljudiIzGrada = new TreeSet<>();

        for(Map.Entry<String, TelefonskiBroj> x : imenik.entrySet()){
            if(x.getValue() instanceof FiksniBroj){
                FiksniBroj fiksni = (FiksniBroj) x.getValue();

                if(fiksni.getGrad() == grad) ljudiIzGrada.add(x.getKey());
            }
        }

        return ljudiIzGrada;

    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad grad){
        Set<TelefonskiBroj> izGradaBr = new TreeSet<>(Comparator.comparing(TelefonskiBroj::ispisi));

        for(Map.Entry<String, TelefonskiBroj> x : imenik.entrySet()){
            if(x.getValue() instanceof FiksniBroj){
                FiksniBroj fiksni = (FiksniBroj) x.getValue();

                if(fiksni.getGrad() == grad){
                    izGradaBr.add(x.getValue());
                }
            }
        }

        return izGradaBr;

    }

}
