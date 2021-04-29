package nyersanyag;

public class Deszka extends Nyersanyag {
    /** eldonti a statikus metodusa  hogy valami nyersanyage
     *
     */

    public static final String DESZKA_TIPUS = "deszka";


    @Override
    public String tipus() {
        return DESZKA_TIPUS;
    }
}
