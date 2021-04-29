package palya.elemek;

import palya.JatekElem;

/**
 * eldonti a statikus metodusa  hogy palya elem e
 */
public class Fold implements JatekElem {

    public static final String FOLD_TIPUS = "fold";

    /**
     * @return jatekelem osztaly tipus metodusanak felulirasa hogy fold tipust adjon vissza
     */
    @Override
    public String tipus() {
        return FOLD_TIPUS;
    }

}
