package nyersanyag;

public class Hulladek extends Nyersanyag{

    /** eldonti a statikus metodusa  hogy valami nyersanyage
     *
     */

    public static final String HULLADEK_TIPUS = "hulladek";

    @Override
    public String tipus() {
        return HULLADEK_TIPUS;
    }
}
