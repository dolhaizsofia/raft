package parancs;

import jatekos.JatekElem;
import palya.Irany;
import palya.Mezo;
import palya.Palya;
import palya.Pozicio;

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
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        JatekElem jatekElem = p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].levesz();
        p.getJatekos().felvesz(jatekElem);
    }
}
