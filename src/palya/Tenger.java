package palya;

import jatekos.JatekElem;

import static palya.Cselekves.SEMMI;

public class Tenger implements JatekElem {
    @Override
    public void rajzol() {
        System.out.print("T");
    }

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        return cselekves;
    }
}
