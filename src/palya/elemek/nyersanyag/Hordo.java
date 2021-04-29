package palya.elemek.nyersanyag;

import static palya.elemek.nyersanyag.NyersanyagFactory.letrehozHordoTartalom;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Hordo extends Nyersanyag {

    public static final String HORDO_TIPUS = "hordo";

    private final Nyersanyag[] tartalom = new Nyersanyag[5];

    /**
     * feltolti a hordot
     */
    public Hordo() {
        for (int i = 0; i < tartalom.length; i++) {
            tartalom[i] = letrehozHordoTartalom();
        }
    }

    public Nyersanyag[] getTartalom() {
        return tartalom;
    }

    /**
     * @return palya.elemek.nyersanyag osztalyt tipus metodusanak felulirasa hogy hordo tipust adjon vissza
     */
    @Override
    public String tipus() {
        return HORDO_TIPUS;
    }

}
