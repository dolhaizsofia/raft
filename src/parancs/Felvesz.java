package parancs;

import palya.*;

import static palya.elemek.nyersanyag.Nyersanyag.nyersanyagE;
import static palya.elemek.Jatekos.JATEKOS_TIPUS;

/**
 * felveszi az adot nyersanyagot ha tudja
 */
public class Felvesz extends Parancs {

    private Irany irany;

    Felvesz(Irany irany) {
        this.irany = irany;
    }

    /**
     * megadott felteteleknek teljesulnie kell
     *
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return nyersanyagE(palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus())
                && mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS);
    }

    /**
     * vegrehajtja ha tamogatott
     *
     * @param p
     */
    @Override
    protected void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        JatekElem jatekElem = p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].levesz();
        p.getJatekos().felvesz(jatekElem);
    }
}
