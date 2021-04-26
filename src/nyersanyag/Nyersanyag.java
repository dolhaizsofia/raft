package nyersanyag;

import jatekos.JatekElem;
import palya.Cselekves;
import palya.Palya;

import static palya.Cselekves.FRISSIT_PALYA;

public abstract class Nyersanyag implements JatekElem {

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        if (FRISSIT_PALYA == cselekves) {
            palya.leMozgat();
        }
        return cselekves;
    }

}
