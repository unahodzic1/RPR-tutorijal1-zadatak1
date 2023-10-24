package ba.unsa.etf.rpr.lab2.zadatak3;
import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

public class Racunanje {

    public static Integer min(List<Integer> uneseniBrojevi){
        int minimum = Integer.MAX_VALUE;

        for(int i = 0; i < uneseniBrojevi.size(); i++){
            if(uneseniBrojevi.get(i) < minimum) minimum = uneseniBrojevi.get(i);
        }

        return minimum;
    }

    public static Integer max(List<Integer> uneseniBrojevi){
        int maksimum = Integer.MIN_VALUE;

        for(int i = 0; i < uneseniBrojevi.size(); i++){
            if(uneseniBrojevi.get(i) > maksimum) maksimum = uneseniBrojevi.get(i);
        }

        return maksimum;
    }

    public static Double mean(List<Integer> uneseniBrojevi){
        double sumaBrojeva = 0;
        double medijana = 0;

        for(int i = 0; i < uneseniBrojevi.size(); i++) sumaBrojeva = sumaBrojeva + uneseniBrojevi.get(i);

        medijana = sumaBrojeva / uneseniBrojevi.size();

        return medijana;
    }

    public static Double standardnaDevijacija(List<Integer> uneseniBrojevi){
        double medijana = Racunanje.mean(uneseniBrojevi);
        double standardnaDev = 0;

        for(int i = 0; i < uneseniBrojevi.get(i); i++) standardnaDev = standardnaDev + Math.pow(uneseniBrojevi.get(i)-medijana,2);

        double vrati = Math.sqrt(standardnaDev/uneseniBrojevi.size());

        return vrati;
    }
}
