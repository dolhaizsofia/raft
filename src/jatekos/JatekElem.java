package jatekos;

import palya.Cselekves;
import palya.Palya;

public interface JatekElem {
    void rajzol();
    Cselekves hatas(Cselekves cselekves, Palya palya);
    String tipus();
    String getImageName();
}
