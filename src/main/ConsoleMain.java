package main;

import jatekos.Jatekos;
import palya.Palya;

import java.util.Scanner;

import static palya.Cselekves.keresKodAlapjan;

public class ConsoleMain {

    public static void main(String[] args) {
        Palya palya = new Palya(10, 10);
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
