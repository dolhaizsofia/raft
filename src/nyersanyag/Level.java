package nyersanyag;

import palya.Cselekves;
import palya.Palya;

public class Level extends Nyersanyag{
    @Override
    public void rajzol() {
        System.out.print("L");
    }

    @Override
    public void hatas(Cselekves cselekves, Palya palya) {
        if (Cselekves.FRISSIT_PALYA == cselekves) {
            palya.leMozgat();
        }
    }
}
