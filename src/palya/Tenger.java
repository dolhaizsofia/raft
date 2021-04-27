package palya;

import jatekos.JatekElem;

public class Tenger implements JatekElem {
    @Override
    public void rajzol() {
        System.out.print("T");
    }

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        return cselekves;
    }

    @Override
    public String tipus() {
        return "tenger";
    }

    @Override
    public String getImageName() {
        return "tenger";
    }
}
