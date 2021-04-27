package palya;

import jatekos.JatekElem;

public class Tenger implements JatekElem {

    public static final String TENGER = "tenger";

    @Override
    public String tipus() {
        return TENGER;
    }

    @Override
    public String getImageName() {
        return TENGER;
    }
}
