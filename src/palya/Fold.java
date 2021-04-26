package palya;

import jatekos.JatekElem;

public class Fold implements JatekElem {
    @Override
    public void rajzol() {
        System.out.print("F");
    }

    @Override
    public void hatas(Akcio akcio, Palya palya) {

    }
}
