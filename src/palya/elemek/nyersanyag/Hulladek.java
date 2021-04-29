package palya.elemek.nyersanyag;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Hulladek extends Nyersanyag {

    public static final String HULLADEK_TIPUS = "hulladek";

    /**
     * @return palya.elemek.nyersanyag osztalyt tipus metodusanak felulirasa hogy hulladek tipust adjon vissza
     */
    @Override
    public String tipus() {
        return HULLADEK_TIPUS;
    }
}
