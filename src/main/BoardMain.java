package main;

import jatekos.Jatekos;
import palya.Palya;

import java.util.Scanner;

import static java.lang.System.in;
import static palya.Cselekves.keresKodAlapjan;

public class BoardMain {

    public static void main(String[] args) {
        Palya palya = new Palya(25, 35);
        Board board = new Board(palya);

        Jatekos jatekos = new Jatekos();
        Scanner olvaso = new Scanner(in);
        while (jatekos.isAlive()) {
            palya.frissit();
            palya.generalUjNyersanyagok();
            palya.ervenyesitHatasok(keresKodAlapjan(olvaso.nextInt()));
            board.addComponentsToPane(board);
            jatekos.csokkentEgeszseg();
        }
    }
}
