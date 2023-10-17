import java.util.Scanner;

public class Zadatak2 {

    public static int sumaCifara(int n){
        int suma=0;
        // skidamo cifru po cifru
        while(n!=0){
            suma+=n%10;
            n/=10;
        }

        return suma;
    }

    public static void main(String[] args) {
        Scanner unos=new Scanner(System.in);

        System.out.print("Unesite broj n: ");
        int n=unos.nextInt();

        System.out.println("Brojevi između 1 i " + n + " koji su djeljivi sa sumom svojih cifara su:");
        for (int i=1;i<=n;i++) {
            if (i%sumaCifara(i)==0) {
                System.out.print(i + " ");
            }
        }
    }
}
