package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Viztisztito;

import static termek.Viztisztito.VIZ_TISZTITO;
/**
 * vizet tisztit ha van viztisztito
 */
public class TisztitViz extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(VIZ_TISZTITO);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        ((Viztisztito) palya.aktualisMezo().getLegfelso()).novelVizMennyiseg();
    }

}
