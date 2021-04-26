package palya;

import jatekos.JatekElem;

public class Palya implements JatekElem {

    private Mezo[][] palya;

    public Palya() {
        this.palya = new Mezo[25][35];
        for (int i= 0; i < palya.length; i++) {
            for (int j= 0; j < palya[i].length; j++) {
                palya[i][j] = new Mezo(new Tenger());
            }
        }
        palya[12][17] = new Mezo(new Fold());
        palya[12][18] = new Mezo(new Fold());
        palya[13][17] = new Mezo(new Fold());
        palya[13][18] = new Mezo(new Fold());
    }

    @Override
    public void rajzol() {
        for (Mezo[] sor: palya) {
            for (Mezo elem: sor) {
                elem.rajzol();
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}
