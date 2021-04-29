package termek;

import palya.JatekElem;

/**
 * eldonti a statikus metodusa  hogy termek e
 * es eltarolja a termekhez tartozo informaciokat
 */
public class Hal implements JatekElem {

    public static final String HAL_TIPUS = "hal";

    private int atsultseg = 0;
    /**
     * noveli az halatsultseget
     */
    void novelAtsultseg() {
        atsultseg++;
    }

    public int getAtsultseg() {
        return atsultseg;
    }
    /**
     * megsult e mar a hal
     * @return
     */
    boolean kesz() {
        return atsultseg >= 25;
    }

    /**
     * feluldefinialja a tipust
     * @return
     */
    @Override
    public String tipus() {
        return HAL_TIPUS;
    }
}
