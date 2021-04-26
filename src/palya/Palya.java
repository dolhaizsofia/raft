package palya;

import jatekos.JatekElem;

public class Palya implements JatekElem {

    private Mezo[][] palya;

    public Palya() {
        this.palya = new Mezo[25][35];
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                palya[i][j] = new Mezo(new Tenger());
            }
        }
        palya[12][17] = new Mezo(new Fold());
        palya[12][18] = new Mezo(new Fold());
        palya[13][17] = new Mezo(new Fold());
        palya[13][18] = new Mezo(new Tenger());
        palya[13][18].lehelyez(new Fold());
        leMozgat(13, 18);
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

    private void leMozgat(int i, int j) {
        JatekElem jatekElem = palya[i][j].levesz();
        if (i < palya.length - 1) {
            palya[i + 1][j].lehelyez(jatekElem);
        }
    }

    private void felMozgat(int i, int j) {
        JatekElem jatekElem = palya[i][j].levesz();
        if (i > 0) {
            palya[i - 1][j].lehelyez(jatekElem);
        }
    }

    private void jobbraMozgat(int i, int j) {
        JatekElem jatekElem = palya[i][j].levesz();
        if (i < palya[i].length - 1) {
            palya[i][j + 1].lehelyez(jatekElem);
        }
    }

    private void balraMozgat(int i, int j) {
        JatekElem jatekElem = palya[i][j].levesz();
        if (j > 0) {
            palya[i][j - 1].lehelyez(jatekElem);
        }
    }

}
