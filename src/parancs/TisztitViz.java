package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Viztisztito;

import static termek.Viztisztito.VIZ_TISZTITO_TIPUS;

/**
 * vizet tisztit ha van viztisztito
 */
public class TisztitViz extends Parancs {
    /**
     * megadott felteteleknek teljesulnie kell
     *
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(VIZ_TISZTITO_TIPUS);
    }

    /**
     * ha tamogatott akkor vegrehajtja
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        ((Viztisztito) palya.aktualisMezo().getLegfelso()).novelVizMennyiseg();
    }

}
