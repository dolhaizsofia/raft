package palya;

/**
 * eldonti a statikus metodusa  hogy palya elem e
 */
public class Capa implements JatekElem {

    public static final String CAPA_TIPUS = "capa";

    /**
     * @return jatekelem osztaly tipus metodusanak felulirasa hogy capa tipust adjon vissza
     */
    @Override
    public String tipus() {
        return CAPA_TIPUS;
    }

}
