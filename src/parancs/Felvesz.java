package parancs;

import jatekos.JatekElem;
import palya.Irany;
import palya.Mezo;
import palya.Palya;

import static jatekos.Jatekos.JATEKOS;

public class Felvesz extends Parancs {

    private Irany irany;

    public Felvesz(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getJatekElem().tipus().equals(JATEKOS);
    }

//    todo egeszitsd ki
    @Override
    protected void vegrehajt(Palya p) {
        if (irany == Irany.BALFEL) {
            Mezo[][] palya = p.getTabla();
            int currI = p.getCurrI();
            int currJ = p.getCurrJ();
            JatekElem jatekElem = palya[currI-1][currJ-1].levesz();
            p.getJatekos().felvesz(jatekElem);
        }

    }
}
