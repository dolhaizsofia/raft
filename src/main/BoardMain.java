package main;

import palya.Jatekos;
import palya.Palya;

import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingUtilities.invokeLater;

public class BoardMain {

    public static void main(String[] args) {
        Palya palya = new Palya(25, 35);
        Jatekos jatekos = palya.getJatekos();
        Board board = new Board(palya);
        ParancsFeldolgozo parancsFeldolgozo = new ParancsFeldolgozo(palya);
        Scanner olvaso = new Scanner(in);

        while (jatekos.isAlive() && jatekos.segitsegNemJottMeg()) {
            parancsFeldolgozo.vegrehajt(olvaso.nextInt());
            invokeLater(() -> board.draw(board));
        }

        if (jatekos.isAlive()) showMessageDialog(board, "Nyertel!!!");
        else showMessageDialog(board, "Vesztettel!!!");
        board.dispose();
    }
}
