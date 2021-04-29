package parancs;

import palya.JatekElem;
import palya.Palya;

import static nyersanyag.Nyersanyag.nyersanyagE;
import static termek.Halo.HALO_TIPUS;

public class HaloBegyujt extends Parancs {

    /**
     *
     * @param palya megvizsgalja a palyat
     * @return ha nyersanyag kerölt a halora azt atadja a jatekosnak
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        return nyersanyagE(palya.aktualisMezo().getLegfelso().tipus())
                && palya.aktualisMezo().getMasodikLegfelso().tipus().equals(HALO_TIPUS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        JatekElem jatekElem = palya.aktualisMezo().levesz();
        palya.getJatekos().felvesz(jatekElem);
    }

}
