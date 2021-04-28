package parancs;

import palya.*;

import static palya.Jatekos.JATEKOS;
import static palya.Tenger.TENGER;

public abstract class Parancs {

    public void csinal(Palya palya) {
        if(tamogatott(palya)) {
            vegrehajt(palya);
        }
    }

    protected abstract boolean tamogatott(Palya palya);

    protected abstract void vegrehajt(Palya palya);

    boolean jatekosEsMellettVmi(Palya palya, Irany irany, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus().equals(keresettTipus) && mezo.getLegfelso().tipus().equals(JATEKOS);
    }

}
