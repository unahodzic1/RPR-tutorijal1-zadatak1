package ba.unsa.etf.rpr.lab2.zadatak3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        List<Integer> uneseniBrojevi = new ArrayList<Integer>();

        System.out.println("Unesite brojeve: ");

        while(true){
            String procitano = unos.nextLine();

            if("stop".equalsIgnoreCase(procitano)){
                break;
            }

            uneseniBrojevi.add(Integer.valueOf(procitano));
        }

        System.out.println("Minimum je: " + Racunanje.min(uneseniBrojevi));
        System.out.println("Maksimum je: " + Racunanje.max(uneseniBrojevi));
        System.out.println("Medijana iznosi: " + Racunanje.mean(uneseniBrojevi));
        System.out.println("Standardna devijacija iznosi: " + Racunanje.standardnaDevijacija(uneseniBrojevi));
    }
}
