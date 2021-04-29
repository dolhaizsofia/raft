package palya.elemek;

import palya.JatekElem;

/**
 * eldonti hogy palya elem e
 */
public class Tenger implements JatekElem {

    public static final String TENGER_TIPUS = "tenger";

    /**
     * @return jatekelem osztaly tipus metodusanak felulirasa hogy tenger tipust adjon vissza
     */
    @Override
    public String tipus() {
        return TENGER_TIPUS;
    }
}
