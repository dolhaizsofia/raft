package termek;

import palya.JatekElem;

/**
 * eldonti a statikus metodusa  hogy termek e
 * es eltarolja a termekhez tartozo informaciokat
 * es metodusokat
 */
public class Viztisztito implements JatekElem {

    public static final String VIZ_TISZTITO_TIPUS = "viztisztito";

    private int vizMennyiseg = 0;

    /**
     * noveli  a vizmennyiseget
     */
    public void novelVizMennyiseg() {
        vizMennyiseg++;
    }

    /**
     * feluldefinialja tipust
     *
     * @return
     */
    @Override
    public String tipus() {
        return VIZ_TISZTITO_TIPUS;
    }

    /**
     * van e mar egy pohar viz
     *
     * @return
     */
    public boolean vanEgyPoharnyi() {
        return vizMennyiseg >= 25;
    }

    /**
     * ha megitta a vizet a jatekos csokeni egy poharral a vizmenyiseget
     */
    public void csokkentEgyPoharral() {
        vizMennyiseg -= 25;
    }
}
