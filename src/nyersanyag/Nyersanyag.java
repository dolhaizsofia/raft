package nyersanyag;

import jatekos.JatekElem;
import palya.Akcio;
import palya.Palya;

public abstract class Nyersanyag implements JatekElem {

    @Override
    public void hatas(Akcio akcio, Palya palya) {
        if (Akcio.FRISSIT_PALYA == akcio) {
            palya.leMozgat();
        }
    }

}
