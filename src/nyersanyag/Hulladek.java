package nyersanyag;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Hulladek extends Nyersanyag {

    public static final String HULLADEK_TIPUS = "hulladek";

    @Override
    public String tipus() {
        return HULLADEK_TIPUS;
    }
}
