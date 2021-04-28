package parancs.mozgas;

import palya.*;
import parancs.Parancs;

import static palya.Jatekos.JATEKOS;

public class Mozgas extends Parancs {

    private Irany irany;
    private boolean valid = true;

    public Mozgas(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya p) {
        Mezo mezo = p.aktualisMezo();
        if (valid && mezo.getLegfelso().tipus().equals(JATEKOS)) {
            valid = false;
            return true;
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
