package parancs;

import palya.Irany;
import palya.Mezo;
import palya.Palya;
import palya.Pozicio;

import static palya.Fold.FOLD;
import static palya.Jatekos.JATEKOS;

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

    boolean jatekosFoldonEsMellettVmi(Palya palya, Irany irany, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus().equals(keresettTipus)
                && mezo.getLegfelso().tipus().equals(JATEKOS)
                && mezo.getMasodikLegfelso().tipus().equals(FOLD);
    }

    boolean mezoTipusu(Palya palya, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

}
