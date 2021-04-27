package jatekos;

import palya.Cselekves;
import palya.Palya;

import java.util.HashMap;
import java.util.Map;

import static nyersanyag.Burgonya.BURGONYA;
import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;
import static palya.Cselekves.SEMMI;

public class Jatekos implements JatekElem {

    public static final String JATEKOS = "jatekos";

    private int egeszseg = 10;
    private int ehseg = 100;
    private int szomjusag = 100;

    private Map<String, Integer> holmik;

    public Jatekos() {
        holmik = new HashMap<>();
        holmik.put(DESZKA, 0);
        holmik.put(LEVEL, 0);
        holmik.put(HULLADEK, 0);
        holmik.put(BURGONYA, 0);
    }

    public boolean isAlive() {
        return egeszseg > 0;
    }

    public void csokkentEgeszseg() {
        egeszseg--;
    }

    public int keresHolmni(String holmi) {
        return holmik.getOrDefault(holmi, 0);
    }

    public void csokkentHolmi(String holmi, int mennyiseg) {
        holmik.put(holmi, holmik.get(holmi) - mennyiseg);
    }

    @Override
    public String tipus() {
        return JATEKOS;
    }

    @Override
    public String getImageName() {
        return JATEKOS;
    }
}
