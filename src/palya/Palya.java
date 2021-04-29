package palya;

import parancs.Parancs;

public class Palya {

    private Jatekos jatekos;

    private Mezo[][] palya;
    //    jatekelem should have position???
    private int currI;
    private int currJ;

    /**
     * osszerakja a palyat
     * @param height
     * @param width
     */

    public Palya(int height, int width) {
        this.palya = new Mezo[height][width];
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                palya[i][j] = new Mezo(new Tenger());
            }
        }
        int middleHeight = palya.length / 2;
        int middleWidth = palya[0].length / 2;
        palya[middleHeight - 1][middleWidth - 1] = new Mezo(new Fold());
        jatekos = new Jatekos();
        palya[middleHeight - 1][middleWidth - 1].lehelyez(jatekos);
        palya[middleHeight - 1][middleWidth] = new Mezo(new Fold());
        palya[middleHeight][middleWidth - 1] = new Mezo(new Fold());
        palya[middleHeight][middleWidth] = new Mezo(new Fold());
        palya[middleHeight - 1][middleWidth - 3].lehelyez(new Capa());
    }

    public void vegigMegy(Parancs parancs) {
        for (int i = palya.length - 1; i >= 0; i--) {
            for (int j = 0; j < palya[i].length; j++) {
                currI = i;
                currJ = j;
                parancs.csinal(this);
            }
        }
    }

    public Jatekos getJatekos() {
        return jatekos;
    }

    public int getCurrI() {
        return currI;
    }

    public int getCurrJ() {
        return currJ;
    }

    public Mezo[][] getTabla() {
        return palya;
    }

    public Mezo aktualisMezo() {
        return palya[currI][currJ];
    }

    public Pozicio getKovetkezoLepes(Irany irany) {
        Pozicio elmozdulas = getElmozdulasIranyhoz(irany);
        Pozicio ujPozicio = new Pozicio(currJ + elmozdulas.getX(), currI + elmozdulas.getY());
        return palyanBelulE(ujPozicio) ? ujPozicio : new Pozicio(currJ, currI);
    }

    public boolean palyanBelulE(Irany irany) {
        Pozicio elmozdulas = getElmozdulasIranyhoz(irany);
        Pozicio ujPozicio = new Pozicio(currJ + elmozdulas.getX(), currI + elmozdulas.getY());
        return palyanBelulE(ujPozicio);
    }

    public boolean palyanBelulE(int i, int j) {
        return (j >= 0 && j < palya[0].length) &&
                i >= 0 && i < palya.length;
    }

    private Pozicio getElmozdulasIranyhoz(Irany irany) {
        if (irany == Irany.FEL) {
            return new Pozicio(0, -1);
        } else if (irany == Irany.LE) {
            return new Pozicio(0, 1);
        } else if (irany == Irany.BAL) {
            return new Pozicio(-1, 0);
        } else if (irany == Irany.JOBB) {
            return new Pozicio(1, 0);
        } else if (irany == Irany.BALFEL) {
            return new Pozicio(-1, -1);
        } else if (irany == Irany.BALLE) {
            return new Pozicio(-1, 1);
        } else if (irany == Irany.JOBBLE) {
            return new Pozicio(1, 1);
        } else if (irany == Irany.JOBBFEL) {
            return new Pozicio(1, -1);
        }
        return new Pozicio(0, 0);
    }

    private boolean palyanBelulE(Pozicio pozicio) {
        return (pozicio.getX() >= 0 && pozicio.getX() < palya[0].length) &&
                pozicio.getY() >= 0 && pozicio.getY() < palya.length;
    }

}
