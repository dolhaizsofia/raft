package palya;

import jatekos.JatekElem;

public class Palya implements JatekElem {

    private JatekElem[][] palya;

    public Palya() {
        this.palya = new JatekElem[25][35];
        for (int i= 0; i < palya.length; i++) {
            for (int j= 0; j < palya[i].length; j++) {
                palya[i][j] = new Tenger();
            }
        }
        palya[12][17] = new Fold();
        palya[12][18] = new Fold();
        palya[13][17] = new Fold();
        palya[13][18] = new Fold();
    }

    @Override
    public void rajzol() {
        for (JatekElem[] sor: palya) {
            for (JatekElem elem: sor) {
                elem.rajzol();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
