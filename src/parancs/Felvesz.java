package parancs;

import palya.JatekElem;
import palya.Irany;
import palya.Mezo;
import palya.Palya;
import palya.Pozicio;

import static palya.Jatekos.JATEKOS;

public class Felvesz extends Parancs {

    private Irany irany;

    public Felvesz(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    protected void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        JatekElem jatekElem = p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].levesz();
        p.getJatekos().felvesz(jatekElem);
    }
}
