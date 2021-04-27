package jatekos;

import palya.Cselekves;
import palya.Palya;

import java.util.HashMap;
import java.util.Map;

import static palya.Cselekves.*;

public class Jatekos implements JatekElem {

    private int egeszseg = 10;

    private Map<String, Integer> holmik = new HashMap<>();

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
        if (MOZGAS_BALRA == cselekves) {
            palya.balraMozgat();
        }
        if (MOZGAS_FEL == cselekves) {
            palya.felMozgat();
        }
        if (MOZGAS_LE == cselekves) {
            palya.leMozgat();
        }
        if (MOZGAS_BALFEL == cselekves) {
            palya.balfelMozgat();
        }
        if (MOZGAS_BALLE == cselekves) {
            palya.balleMozgat();
        }
        if (MOZGAS_JOBBFEL == cselekves) {
            palya.jobbfelMozgat();
        }
        if (MOZGAS_JOBBLE == cselekves) {
            palya.jobbleMozgat();
        }
        if (TERULET_BOVITES == cselekves) {
            palya.foglalTerulet();
        }
        return SEMMI;
    }

    @Override
    public String tipus() {
        return null;
    }

    @Override
    public String getImageName() {
        return "tenger";
    }
}
