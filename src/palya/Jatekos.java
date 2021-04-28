package palya;

import nyersanyag.Hordo;
import nyersanyag.Nyersanyag;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;
import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hordo.HORDO;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;
import static termek.Burgonya.BURGONYA;
import static termek.Hal.HAL;

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
        holmik.put(HAL, 0);
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

    public void iszik() {
        szomjusag = min(szomjusag + 40, 100 + 1); //+1 a mostani kor miatt
    }

    public void eszik() {
        ehseg = min(ehseg + 60, 100 + 1);
    }

    public int getEhseg() {
        return ehseg;
    }

    public int getSzomjusag() {
        return szomjusag;
    }

    public Map<String, Integer> getHolmik() {
        return holmik;
    }

    @Override
    public String tipus() {
        return JATEKOS;
    }
}
