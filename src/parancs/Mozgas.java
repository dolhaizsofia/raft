package parancs;

import palya.*;

import static palya.Jatekos.JATEKOS_TIPUS;

public class Mozgas extends Parancs {

    private Irany irany;
    private boolean valid = true;

    Mozgas(Irany irany) {
        this.irany = irany;
    }

    /**
     *  megnezi hogy a jatekosunk mehet e arra amera az utasitas adta es ha igen akkor odamozgatja amugy nem hajtja vegre a cselekvest
     * @param p
     * @return
     */

    @Override
    protected boolean tamogatott(Palya p) {
        Mezo mezo = p.aktualisMezo();
        if (valid && mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS)) {
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
