package parancs;

import palya.*;

import static nyersanyag.Nyersanyag.nyersanyagE;
import static palya.Jatekos.JATEKOS_TIPUS;

public class Felvesz extends Parancs {

    private Irany irany;

    Felvesz(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return nyersanyagE(palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus())
                && mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS);
    }

    @Override
    protected void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        JatekElem jatekElem = p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].levesz();
        p.getJatekos().felvesz(jatekElem);
    }
}
