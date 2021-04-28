package jatekos;

import nyersanyag.Hordo;
import nyersanyag.Nyersanyag;

import java.util.HashMap;
import java.util.Map;

import static nyersanyag.Burgonya.BURGONYA;
import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hordo.HORDO;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;

public class Jatekos implements JatekElem {

    public static final String JATEKOS = "jatekos";

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
        return ehseg > 0 && szomjusag > 0;
    }

    public int keresHolmni(String holmi) {
        return holmik.getOrDefault(holmi, 0);
    }

    public void csokkentHolmi(String holmi, int mennyiseg) {
        holmik.put(holmi, holmik.get(holmi) - mennyiseg);
    }

    public void felvesz(JatekElem jatekElem) {
        if(jatekElem.tipus().equals(HORDO)){
            for (Nyersanyag nyersanyag :((Hordo)jatekElem).getTartalom()) {
                holmik.put(nyersanyag.tipus(), holmik.get(nyersanyag.tipus())  + 1);
            }
        } else {
            holmik.put(jatekElem.tipus(), holmik.get(jatekElem.tipus())  + 1);
        }
    }

    public void csokkentElet() {
        ehseg--;
        szomjusag--;
    }

    @Override
    public String tipus() {
        return JATEKOS;
    }
}
