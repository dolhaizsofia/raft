package main;

import palya.Jatekos;
import palya.Palya;
import parancs.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingUtilities.invokeLater;
import static parancs.ParancsFactory.letrehozParancs;

public class BoardMain {

    public static void main(String[] args) {
        Palya palya = new Palya(25, 35);
        Board board = new Board(palya);
        ParancsFeldolgozo parancsFeldolgozo = new ParancsFeldolgozo(palya);

        int cselekvesSzamlalo = 1000;
        Jatekos jatekos = new Jatekos();
        Scanner olvaso = new Scanner(in);
        while (jatekos.isAlive()) {
            List<Parancs> parancsok = new ArrayList<>();
            parancsok.add(letrehozParancs(olvaso.nextInt()));
            parancsok.add(new MozgatNyersanyag());
            parancsok.add(new GeneralUjNyersanyagok());
            parancsok.add(new LeveszEro());
            parancsok.add(new TisztitViz());
            parancsok.add(new SulEtel());
            parancsok.add(new HaloBegyujt());

            parancsFeldolgozo.vegrehajt(parancsok);

            cselekvesSzamlalo--;
            VisszaJelzes visszaJelzes = new VisszaJelzes(cselekvesSzamlalo,
                    palya.getJatekos().getSzomjusag(),
                    palya.getJatekos().getEhseg(),
                    palya.getJatekos().getHolmik());
            invokeLater(() -> board.draw(board, visszaJelzes));

            if(!palya.getJatekos().isAlive()) {
                showMessageDialog(board, "Vesztettel!!!");
                board.dispose();
                break;
            }

            if (cselekvesSzamlalo == 0) {
                showMessageDialog(board, "Nyertel!!!");
                board.dispose();
                break;
            }
        }
    }
}
