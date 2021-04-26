package main;

import jatekos.Jatekos;
import palya.Palya;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Palya palya = new Palya(5, 5);
        palya.rajzol();
        Jatekos jatekos = new Jatekos();
        Scanner olvaso =new Scanner(System.in);
        while (jatekos.isAlive()) {
            olvaso.nextInt();
            palya.frissit();
            palya.generalUjNyersanyagok();
            palya.rajzol();
            jatekos.csokkentEgeszseg();
        }

    }
}
