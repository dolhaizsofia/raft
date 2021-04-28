package parancs;

import palya.Fold;
import palya.Irany;
import palya.Mezo;
import palya.Palya;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Level.LEVEL;
import static palya.Jatekos.JATEKOS;
import static palya.Tenger.TENGER;

public class Bovites extends Parancs {

    private boolean valid = true;

    private Irany irany;

    public Bovites(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya palya) {
        if (!(palya.getJatekos().keresHolmni(DESZKA) >= 2 && palya.getJatekos().keresHolmni(LEVEL) >= 2) || !valid) {
            return;
        }

        palya.getJatekos().csokkentHolmi(DESZKA, 2);
        palya.getJatekos().csokkentHolmi(LEVEL, 2);

        foglalTerulet(palya);
        valid = false;
    }

    private void foglalTerulet(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        if (currI - 1 >= 0 && palya[currI-1][currJ].getLegfelso().tipus().equals(TENGER)) {
            palya[currI-1][currJ] = new Mezo(new Fold());
        } else if (currI + 1 < palya.length && palya[currI+1][currJ].getLegfelso().tipus().equals(TENGER)) {
            palya[currI+1][currJ] = new Mezo(new Fold());
        } else if (currJ - 1 >= 0 && palya[currI][currJ-1].getLegfelso().tipus().equals(TENGER)) {
            palya[currI][currJ-1] = new Mezo(new Fold());
        } else if (currJ + 1 < palya[0].length && palya[currI][currJ+1].getLegfelso().tipus().equals(TENGER)) {
            palya[currI][currJ+1] = new Mezo(new Fold());
        } else if(currI - 1 >= 0 && currJ + 1 < palya[0].length && palya[currI-1][currJ+1].getLegfelso().tipus().equals(TENGER)){
            palya[currI-1][currJ+1] = new Mezo(new Fold());
        } else if(currI - 1 >= 0 && currJ - 1 < palya[0].length && palya[currI-1][currJ-1].getLegfelso().tipus().equals(TENGER)){
            palya[currI-1][currJ-1] = new Mezo(new Fold());
        } else if(currJ + 1 < palya[0].length && currJ + 1 < palya[0].length && palya[currI+1][currJ+1].getLegfelso().tipus().equals(TENGER)){
            palya[currI+1][currJ+1] = new Mezo(new Fold());
        } else if (currJ + 1 < palya[0].length && currJ - 1 < palya[0].length && palya[currI+1][currJ-1].getLegfelso().tipus().equals(TENGER)){
            palya[currI+1][currJ-1] = new Mezo(new Fold());
        }
    }
}
