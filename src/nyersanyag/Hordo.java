package nyersanyag;

import static nyersanyag.NyersanyagFactory.letrehozHordoTartalom;

public class Hordo extends Nyersanyag {

    /** eldonti a statikus metodusa  hogy valami nyersanyage
     */

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
