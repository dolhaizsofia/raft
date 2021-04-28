package termek;

import nyersanyag.Nyersanyag;

public class Burgonya extends Nyersanyag {

    public static final String BURGONYA = "burgonya";

    private int atsultseg = 0;

    public void novelAtsultseg() {
        atsultseg++;
    }

    public int getAtsultseg() {
        return atsultseg;
    }

    public boolean kesz() {
        return atsultseg >= 25;
    }

    @Override
    public String tipus() {
        return BURGONYA;
    }
}
