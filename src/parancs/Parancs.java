package parancs;

import palya.Irany;
import palya.Mezo;
import palya.Palya;
import palya.Pozicio;

import static palya.Fold.FOLD_TIPUS;
import static palya.Jatekos.JATEKOS_TIPUS;
/**
 *
 * a palyan fogja vegrehajtani az adott parancsokat
 * visszater igazzal ha megfelelo helyen szeretnenk parancsot vegrehajtani
 */
public abstract class Parancs {
    /**
     * ha az adot parancs tamogatott akkor vegrehajtatja
     * @param palya
     */
    public void csinal(Palya palya) {
        if(tamogatott(palya)) {
            vegrehajt(palya);
        }
    }
    protected abstract boolean tamogatott(Palya palya);

    protected abstract void vegrehajt(Palya palya);

    /**
     * megnezi hogy a keresettTipusu mezo van e a jatekos mellett
     * @param palya
     * @param irany
     * @param keresettTipus
     * @return
     */
    boolean jatekosEsMellettVmi(Palya palya, Irany irany, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus().equals(keresettTipus) && mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS);
    }
    /**
     * megnezi hogy a keresettTipusu mezo van e a jatekos mellett es a jatekos hajon van e
     * @param palya
     * @param irany
     * @param keresettTipus
     * @return
     */
    boolean jatekosFoldonEsMellettVmi(Palya palya, Irany irany, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus().equals(keresettTipus)
                && mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS)
                && mezo.getMasodikLegfelso().tipus().equals(FOLD_TIPUS);
    }

    /**
     * keresettTipusu mezo van e ott
     * @param palya
     * @param keresettTipus
     * @return
     */
    boolean mezoTipusu(Palya palya, String keresettTipus) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(keresettTipus);
    }

}
