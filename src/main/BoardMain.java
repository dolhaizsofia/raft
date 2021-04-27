package main;

import jatekos.Jatekos;
import palya.Palya;

import javax.swing.*;
import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showMessageDialog;
import static palya.Cselekves.keresKodAlapjan;

public class BoardMain {

    public static void main(String[] args) {
        Palya palya = new Palya(25, 35);
        Board board = new Board(palya);

        int cselekvesSzamlalo = 3;
        Jatekos jatekos = new Jatekos();
        Scanner olvaso = new Scanner(in);
        while (jatekos.isAlive()) {
            palya.frissit();
            palya.generalUjNyersanyagok();
            palya.ervenyesitHatasok(keresKodAlapjan(olvaso.nextInt()));
            board.addComponentsToPane(board);
            jatekos.csokkentEgeszseg();
            cselekvesSzamlalo--;
            if (cselekvesSzamlalo == 0) {
                showMessageDialog(board, "Nyertel!!!");
                board.dispose();
                break;
            }
        }
    }
}
