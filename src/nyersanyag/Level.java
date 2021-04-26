package nyersanyag;

import palya.Akcio;
import palya.Palya;

public class Level extends Nyersanyag{
    @Override
    public void rajzol() {
        System.out.print("L");
    }

    @Override
    public void hatas(Akcio akcio, Palya palya) {
        if (Akcio.FRISSIT_PALYA == akcio) {
            palya.leMozgat();
        }
    }
}
