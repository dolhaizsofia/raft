package palya;

import jatekos.JatekElem;

import static palya.Cselekves.SEMMI;

public class Fold implements JatekElem {
    @Override
    public void rajzol() {
        System.out.print("F");
    }

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        return cselekves;
    }
}
