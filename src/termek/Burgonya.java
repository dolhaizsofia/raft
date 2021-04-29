package termek;

import nyersanyag.Nyersanyag;

/** eldonti a statikus metodusa  hogy termek e
 *es eltarolja a termekhez tartozo informaciokat
 */
public class Burgonya extends Nyersanyag {

    public static final String BURGONYA_TIPUS = "burgonya";

    private int atsultseg = 0;

    /**
     * noveli az burgony atsultseget
     */
    void novelAtsultseg() {
        atsultseg++;
    }

    /**
     * megsult e mar a burgonya
     * @return
     */
    boolean kesz() {
        return atsultseg >= 25;
    }

    /**
     * tipust definial felul
     * @return
     */
    @Override
    public String tipus() {
        return BURGONYA_TIPUS;
    }
}
