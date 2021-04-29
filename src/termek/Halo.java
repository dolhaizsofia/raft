package termek;

import palya.JatekElem;

/**
 * eldonti a statikus metodusa  hogy termek e
 */
public class Halo implements JatekElem {

    public static final String HALO_TIPUS = "halo";

    /**
     * feluldefinialja a tipust
     *
     * @return
     */
    @Override
    public String tipus() {
        return HALO_TIPUS;
    }
}
