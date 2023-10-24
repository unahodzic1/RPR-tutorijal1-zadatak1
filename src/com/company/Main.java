package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(args.length == 1){
            int a = Integer.parseInt(args[0]);
            System.out.println("Sinus broja iznosi: " + Racunanje.sinus(a,10));
            System.out.println("Faktorijel broja iznosi: " + Racunanje.faktorijel(a));
        }
        else{
            System.out.println("Ocekivan je ulaz velicine 1");
        }
    }
}
