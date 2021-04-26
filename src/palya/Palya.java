package palya;

import jatekos.JatekElem;
import nyersanyag.Level;
import nyersanyag.Nyersanyag;
import nyersanyag.NyersanyagFactory;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static nyersanyag.NyersanyagFactory.letrehozNyersanyag;
import static palya.Akcio.FRISSIT_PALYA;

public class Palya implements JatekElem {

    private Mezo[][] palya;
    //    jatekelem should have position???
    private int currI, currJ;

    public Palya() {
        this.palya = new Mezo[5][5];
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                palya[i][j] = new Mezo(new Tenger());
            }
        }
        palya[3][3] = new Mezo(new Fold());
//        palya[12][18] = new Mezo(new Fold());
//        palya[13][17] = new Mezo(new Fold());
//        palya[13][18] = new Mezo(new Tenger());
//        palya[13][18].lehelyez(new Fold());
//        leMozgat(13, 18);

        palya[0][1].lehelyez(new Level());
    }

    @Override
    public void rajzol() {
        for (Mezo[] sor : palya) {
            for (Mezo elem : sor) {
                elem.rajzol();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public void hatas(Akcio akcio, Palya palya) {

    }

    public void frissit() {
        for (int i = palya.length - 1; i >= 0; i--) {
            for (int j = 0; j < palya[i].length; j++) {
                currI = i;
                currJ = j;
                palya[i][j].getJatekElem().hatas(FRISSIT_PALYA, this);
            }
        }
    }

    public void generalUjNyersanyagok() {
        Random random = new Random();
        int nyersanyagSzam = random.nextInt(3 + 1);
        Set<Integer> hova = new HashSet<>();
        for (int i = 0; i < nyersanyagSzam; i++) {
            hova.add(random.nextInt(palya[0].length));
        }
        for (int oszlop: hova) {
            Nyersanyag nyersanyag = letrehozNyersanyag();
            palya[0][oszlop].lehelyez(letrehozNyersanyag());
        }
    }

//    private void leMozgat(int i, int j) {
//        JatekElem jatekElem = palya[i][j].levesz();
//        if (i < palya.length - 1) {
//            palya[i + 1][j].lehelyez(jatekElem);
//        }
//    }
//
//    private void felMozgat(int i, int j) {
//        JatekElem jatekElem = palya[i][j].levesz();
//        if (i > 0) {
//            palya[i - 1][j].lehelyez(jatekElem);
//        }
//    }
//
//    private void jobbraMozgat(int i, int j) {
//        JatekElem jatekElem = palya[i][j].levesz();
//        if (i < palya[i].length - 1) {
//            palya[i][j + 1].lehelyez(jatekElem);
//        }
//    }
//
//    private void balraMozgat(int i, int j) {
//        JatekElem jatekElem = palya[i][j].levesz();
//        if (j > 0) {
//            palya[i][j - 1].lehelyez(jatekElem);
//        }
//    }

    public void leMozgat() {
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya.length - 1) {
            palya[currI + 1][currJ].lehelyez(jatekElem);
        }
    }

    public void felMozgat() {
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI > 0) {
            palya[currI - 1][currJ].lehelyez(jatekElem);
        }
    }

    public void jobbraMozgat() {
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya[currI].length - 1) {
            palya[currI][currJ + 1].lehelyez(jatekElem);
        }
    }

    public void balraMozgat() {
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currJ > 0) {
            palya[currI][currJ - 1].lehelyez(jatekElem);
        }
    }

}
