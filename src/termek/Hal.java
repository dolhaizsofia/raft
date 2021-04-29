package termek;

import palya.JatekElem;

public class Hal implements JatekElem {

    public static final String HAL_TIPUS = "hal";

    private int atsultseg = 0;

    void novelAtsultseg() {
        atsultseg++;
    }

    public int getAtsultseg() {
        return atsultseg;
    }

    boolean kesz() {
        return atsultseg >= 25;
    }

    @Override
    public String tipus() {
        return HAL_TIPUS;
    }
}
