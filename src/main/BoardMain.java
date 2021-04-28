package main;

import jatekos.Jatekos;
import palya.Palya;
import parancs.GeneralUjNyersanyagok;
import parancs.MozgatNyersanyag;
import parancs.Parancs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showMessageDialog;
import static parancs.ParancsFactory.letrehozParancs;

public class BoardMain {

    public static void main(String[] args) {
        Palya palya = new Palya(25, 35);
        Board board = new Board(palya);
        ParancsFeldolgozo parancsFeldolgozo = new ParancsFeldolgozo(palya);

        int cselekvesSzamlalo = 100;
        Jatekos jatekos = new Jatekos();
        Scanner olvaso = new Scanner(in);
        while (jatekos.isAlive()) {
            List<Parancs> parancsok = new ArrayList<>();
            parancsok.add(letrehozParancs(olvaso.nextInt()));
            parancsok.add(new MozgatNyersanyag());
            parancsok.add(new GeneralUjNyersanyagok());

            parancsFeldolgozo.vegrehajt(parancsok);
            board.draw(board);
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
