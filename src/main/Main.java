package main;

import jatekos.Jatekos;
import palya.Palya;

import java.util.Scanner;

import static palya.Cselekves.keresKodAlapjan;

public class Main {

    public static void main(String[] args) {
        Palya palya = new Palya(35, 25);
        palya.rajzol();
        Jatekos jatekos = new Jatekos();
        Scanner olvaso = new Scanner(System.in);
        while (jatekos.isAlive()) {
            palya.frissit();
            palya.generalUjNyersanyagok();
            palya.ervenyesitHatasok(keresKodAlapjan(olvaso.nextInt()));
            palya.rajzol();
            jatekos.csokkentEgeszseg();
        }

    }
}
