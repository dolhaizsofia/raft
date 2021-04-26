package palya;

import jatekos.JatekElem;
import jatekos.Jatekos;
import nyersanyag.Nyersanyag;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static nyersanyag.NyersanyagFactory.letrehozNyersanyag;
import static palya.Cselekves.FRISSIT_PALYA;
import static palya.Cselekves.SEMMI;

public class Palya implements JatekElem {

    private static Random random = new Random();

    private Mezo[][] palya;
    //    jatekelem should have position???
    private int currI, currJ;

    public Palya(int height, int width) {
        this.palya = new Mezo[height][width];
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                palya[i][j] = new Mezo(new Tenger());
            }
        }
        int middleHeight = palya.length / 2;
        int middleWidth = palya[0].length / 2;
        palya[middleHeight-1][middleWidth-1] = new Mezo(new Fold());
        palya[middleHeight-1][middleWidth-1].lehelyez(new Jatekos());
        palya[middleHeight-1][middleWidth] = new Mezo(new Fold());
        palya[middleHeight][middleWidth-1] = new Mezo(new Fold());
        palya[middleHeight][middleWidth] = new Mezo(new Fold());
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
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        return SEMMI;
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
        int nyersanyagSzam = random.nextInt(3 + 1);
        Set<Integer> hova = new HashSet<>();
        for (int i = 0; i < nyersanyagSzam; i++) {
            hova.add(random.nextInt(palya[0].length));
        }
        for (int oszlop: hova) {
            palya[0][oszlop].lehelyez(letrehozNyersanyag());
        }
    }

    public void ervenyesitHatasok(Cselekves cselekves) {
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                currI = i;
                currJ = j;
                cselekves = palya[i][j].getJatekElem().hatas(cselekves, this);
            }
        }
    }

//    szmet es jatekos utkozik???
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
