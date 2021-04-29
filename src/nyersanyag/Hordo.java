package nyersanyag;

import static nyersanyag.NyersanyagFactory.letrehozHordoTartalom;
/**
 *  eldonti a statikus metodusa  hogy valami nyersanyage
 */
public class Hordo extends Nyersanyag {

    public static final String HORDO = "hordo";

    private Nyersanyag[] tartalom = new Nyersanyag[5];

    public Hordo() {
        for (int i = 0; i < tartalom.length; i++) {
            tartalom[i] = letrehozHordoTartalom();
        }
    }

    public Nyersanyag[] getTartalom() {
        return tartalom;
    }

    @Override
    public String tipus() {
        return HORDO;
    }

}
