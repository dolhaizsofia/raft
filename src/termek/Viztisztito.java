package termek;

import palya.JatekElem;

public class Viztisztito implements JatekElem {
    /** eldonti a statikus metodusa  hogy termek e
     *es eltarolja a termekhez tartozo informaciokat
     * es metodusokat
     */


    public static final String VIZ_TISZTITO = "viztisztito";

    private int vizMennyiseg = 0;

    public void novelVizMennyiseg() {
        vizMennyiseg++;
    }

    @Override
    public String tipus() {
        return VIZ_TISZTITO;
    }

    public boolean vanEgyPoharnyi() {
        return vizMennyiseg >= 25;
    }

    public void csokkentEgyPoharral() {
        vizMennyiseg -= 25;
    }
}
