package com.company;
import java.lang.Math;

public class Racunanje {

    // funkcija Faktorijel
    public static int faktorijel(int n){
        int f = 1;
        for(int i = 1; i <= n; i++) f = f * i;

        return f;
    }

    // funkcija Sinus
    public static double sinus(double x, int n) {

        double sum = 0;
        for (int i = 1; i <= n; i++) sum += (Math.pow(-1, i-1) * Math.pow(x, 2 * i - 1) / faktorijel(2 * i - 1));

        return sum;
    }
}
