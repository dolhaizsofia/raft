package parancs;

import palya.*;

import static palya.Jatekos.JATEKOS;

public class Mozgas extends Parancs {

    private Irany irany;
    private boolean valid = true;

    Mozgas(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya p) {
        Mezo mezo = p.aktualisMezo();
        if (valid && mezo.getLegfelso().tipus().equals(JATEKOS)) {
            valid = false;
            return p.palyanBelulE(irany);
        }
        return false;
    }

    @Override
    protected void vegrehajt(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();

        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        JatekElem jatekElem = palya[currI][currJ].levesz();
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(jatekElem);
    }

}
