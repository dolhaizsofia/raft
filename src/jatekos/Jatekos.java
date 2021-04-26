package jatekos;

import palya.Cselekves;
import palya.Palya;

import static palya.Cselekves.MOZGAS_JOBBRA;
import static palya.Cselekves.SEMMI;

public class Jatekos implements JatekElem {
    private int egeszseg = 3;

    public boolean isAlive() {
        return egeszseg > 0;
    }

    public void csokkentEgeszseg() {
        egeszseg--;
    }

    @Override
    public void rajzol() {
        System.out.print("J");
    }

    @Override
    public Cselekves hatas(Cselekves cselekves, Palya palya) {
        if (MOZGAS_JOBBRA == cselekves) {
            palya.jobbraMozgat();
        }
        return SEMMI;
    }
}
