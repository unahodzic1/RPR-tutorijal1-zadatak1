import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args){
        System.out.println("Hello world!");
        int a, b;
        Scanner unos=new Scanner(System.in);
        System.out.println("Unesite prvi broj: ");
        a=unos.nextInt();
        System.out.println("Unesite drugi broj: ");
        b=unos.nextInt();
        System.out.println("Brojevi koje ste unijeli su: " + a + " i " + b);
    }
}
