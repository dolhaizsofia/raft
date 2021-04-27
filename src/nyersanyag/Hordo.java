package nyersanyag;

import static nyersanyag.NyersanyagFactory.letrehozHordoTartalom;

public class Hordo extends Nyersanyag {

    private Nyersanyag[] tartalom = new Nyersanyag[5];

    public Hordo() {
        for (int i = 0; i < tartalom.length; i++) {
            tartalom[i] = letrehozHordoTartalom();
        }
    }

    @Override
    public String getImageName() {
        return "hordo";
    }
}
