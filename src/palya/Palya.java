package palya;

import jatekos.Jatekos;
import parancs.Parancs;

public class Palya {

    private Jatekos jatekos;

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
        jatekos = new Jatekos();
        palya[middleHeight-1][middleWidth-1].lehelyez(jatekos);
        palya[middleHeight-1][middleWidth] = new Mezo(new Fold());
        palya[middleHeight][middleWidth-1] = new Mezo(new Fold());
        palya[middleHeight][middleWidth] = new Mezo(new Fold());
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

    public Pozicio getKovetkezoLepes(Irany irany){
        Pozicio elmozdulas=getElmozdulasIranyhoz(irany);
        return new Pozicio(currI+ elmozdulas.getY(),currJ+ elmozdulas.getX());
    }

    public Pozicio getElmozdulasIranyhoz(Irany irany){
        if (irany == Irany.FEL) {
            return new Pozicio(0,-1);
        } else if (irany == Irany.LE) {
            return new Pozicio(0,1);
        } else if (irany == Irany.BAL) {
            return new Pozicio(-1,0);
        } else if (irany == Irany.JOBB) {
            return new Pozicio(1,0);
        } else if (irany == Irany.BALFEL) {
            return new Pozicio(-1,-1);
        } else if (irany == Irany.BALLE) {
            return new Pozicio(-1,1);
        } else if (irany == Irany.JOBBLE) {
            return new Pozicio(1,1);
        } else if (irany == Irany.JOBBFEL) {
            return new Pozicio(1,-1);
        }
        return new Pozicio(0,0);
    }
}
