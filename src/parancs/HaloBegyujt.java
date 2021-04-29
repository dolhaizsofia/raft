package parancs;

import palya.JatekElem;
import palya.Palya;

import static nyersanyag.Nyersanyag.nyersanyagE;
import static termek.Halo.HALO_TIPUS;

/**
 * ha a halohoz erkezik egy nyersanyag azt begyujti
 */
public class HaloBegyujt extends Parancs {
    /**
     * megadott felteteleknek teljesulnie kell
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        return nyersanyagE(palya.aktualisMezo().getLegfelso().tipus())
                && palya.aktualisMezo().getMasodikLegfelso().tipus().equals(HALO_TIPUS);
    }

    /**
     * lerakja a halot
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        JatekElem jatekElem = palya.aktualisMezo().levesz();
        palya.getJatekos().felvesz(jatekElem);
    }

}
