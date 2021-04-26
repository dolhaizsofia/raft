package nyersanyag;

import jatekos.JatekElem;
import palya.Cselekves;
import palya.Palya;

public abstract class Nyersanyag implements JatekElem {

    @Override
    public void hatas(Cselekves cselekves, Palya palya) {
        if (Cselekves.FRISSIT_PALYA == cselekves) {
            palya.leMozgat();
        }
    }

}
