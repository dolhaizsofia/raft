package palya;

/**
 * eldonti a statikus metodusa  hogy palya elem e
 */
public class Capa implements JatekElem {

    public static final String CAPA_TIPUS = "capa";

    @Override
    public String tipus() {
        return CAPA_TIPUS;
    }

}
