package palya.elemek.nyersanyag;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Deszka extends Nyersanyag {

    public static final String DESZKA_TIPUS = "deszka";

    /**
     * @return palya.elemek.nyersanyag osztalyt tipus metodusanak felulirasa hogy deszka tipust adjon vissza
     */
    @Override
    public String tipus() {
        return DESZKA_TIPUS;
    }
}
