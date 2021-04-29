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
        Jatekos jatekos = palya.getJatekos();
        Board board = new Board(palya);
        ParancsFeldolgozo parancsFeldolgozo = new ParancsFeldolgozo(palya);
        Scanner olvaso = new Scanner(in);

        while (jatekos.isAlive() && jatekos.segitsegNemJottMeg()) {
            List<Parancs> parancsok = new ArrayList<>();
            parancsok.add(letrehozParancs(olvaso.nextInt()));
            parancsok.add(new MozgatNyersanyag());
            parancsok.add(new GeneralUjNyersanyagok());
            parancsok.add(new LeveszEro());
            parancsok.add(new TisztitViz());
            parancsok.add(new SulEtel());
            parancsok.add(new HaloBegyujt());
            parancsok.add(new CapaMozgas());
            parancsFeldolgozo.vegrehajt(parancsok);
            invokeLater(() -> board.draw(board));
        }

        if (jatekos.isAlive()) showMessageDialog(board, "Nyertel!!!");
        else showMessageDialog(board, "Vesztettel!!!");
        board.dispose();
    }
}
