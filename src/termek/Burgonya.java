package termek;

import nyersanyag.Nyersanyag;

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
