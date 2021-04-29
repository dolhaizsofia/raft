package termek;

import nyersanyag.Nyersanyag;

/**
 * eldonti a statikus metodusa  hogy termek e
 * es eltarolja a termekhez tartozo informaciokat
 */
public class Burgonya extends Nyersanyag {

    public static final String BURGONYA_TIPUS = "burgonya";

    private int atsultseg = 0;

    void novelAtsultseg() {
        atsultseg++;
    }

    boolean kesz() {
        return atsultseg >= 25;
    }

    @Override
    public String tipus() {
        return BURGONYA_TIPUS;
    }
}
