package nyersanyag;
/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Level extends Nyersanyag {

    public static final String LEVEL_TIPUS = "level";

    @Override
    public String tipus() {
        return LEVEL_TIPUS;
    }

}
