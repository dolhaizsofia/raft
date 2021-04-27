package palya;

import jatekos.JatekElem;

public class Fold implements JatekElem {
    @Override
    public void rajzol() {
        System.out.print("F");
    }

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        return cselekves;
    }

    @Override
    public String tipus() {
        return "fold";
    }

    @Override
    public String getImageName() {
        return "fold";
    }
}
