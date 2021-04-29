package palya;

import nyersanyag.Hordo;
import nyersanyag.Nyersanyag;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;
import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hordo.HORDO;
import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Hal.HAL_TIPUS;

public class Jatekos implements JatekElem {
    /**
     * eldonti a statikus metodusa  hogy palya elem e
     * eltarolja hogy mennyi nyersanyaggal rendelkezet
     * hogy el e meg
     */

    public static final String JATEKOS_TIPUS = "jatekos";

    private int ehseg = 100;
    private int szomjusag = 100;

    private Map<String, Integer> holmik;

    public Jatekos() {
        holmik = new HashMap<>();
        holmik.put(DESZKA_TIPUS, 0);
        holmik.put(LEVEL_TIPUS, 0);
        holmik.put(HULLADEK_TIPUS, 0);
        holmik.put(BURGONYA_TIPUS, 0);
        holmik.put(HAL_TIPUS, 0);
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
        return JATEKOS_TIPUS;
    }
}
