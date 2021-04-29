package termek;

import palya.JatekElem;

public class Halo implements JatekElem {
    /** eldonti a statikus metodusa  hogy termek e
     */

    public static final String HALO_TIPUS = "halo";

    @Override
    public String tipus() {
        return HALO_TIPUS;
    }
}
