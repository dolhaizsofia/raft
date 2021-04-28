package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Viztisztito;

import static termek.Viztisztito.VIZ_TISZTITO;

public class TisztitViz extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getJatekElem().tipus().equals(VIZ_TISZTITO);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        ((Viztisztito) palya.aktualisMezo().getJatekElem()).novelVizMennyiseg();
    }

}
