package palya.elemek.nyersanyag;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Level extends Nyersanyag {

    public static final String LEVEL_TIPUS = "level";

    /**
     * @return palya.elemek.nyersanyag osztalyt tipus metodusanak felulirasa hogy level tipust adjon vissza
     */
    @Override
    public String tipus() {
        return LEVEL_TIPUS;
    }

}
