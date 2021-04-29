package palya;

import nyersanyag.Hordo;
import nyersanyag.Nyersanyag;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Math.min;
import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hordo.HORDO_TIPUS;
import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Hal.HAL_TIPUS;

/**
 * eldonti a statikus metodusa  hogy palya elem e
 * eltarolja hogy mennyi nyersanyaggal rendelkezet
 * hogy el e meg
 */
public class Jatekos implements JatekElem {

    public static final String JATEKOS_TIPUS = "jatekos";

    private int ehseg = 100;
    private int szomjusag = 100;
    private int cselekvesSzamlalo = 1000;

    private Map<String, Integer> holmik;

    public Jatekos() {
        holmik = new LinkedHashMap<>();
        holmik.put(DESZKA_TIPUS, 0);
        holmik.put(LEVEL_TIPUS, 0);
        holmik.put(HULLADEK_TIPUS, 0);
        holmik.put(BURGONYA_TIPUS, 0);
        holmik.put(HAL_TIPUS, 0);
    }

    public boolean isDead() {
        return ehseg <= 0 && szomjusag <= 0;
    }

    public boolean segitsegMegJott() {
        return cselekvesSzamlalo <= 0;
    }

    public int keresHolmni(String holmi) {
        return holmik.getOrDefault(holmi, 0);
    }

    public void csokkentHolmi(String holmi, int mennyiseg) {
        holmik.put(holmi, holmik.get(holmi) - mennyiseg);
    }

    public void felvesz(JatekElem jatekElem) {
        if (jatekElem.tipus().equals(HORDO_TIPUS)) {
            for (Nyersanyag nyersanyag : ((Hordo) jatekElem).getTartalom()) {
                holmik.put(nyersanyag.tipus(), holmik.get(nyersanyag.tipus()) + 1);
            }
        } else {
            holmik.put(jatekElem.tipus(), holmik.get(jatekElem.tipus()) + 1);
        }
    }

    public void csokkentElet() {
        ehseg--;
        szomjusag--;
    }

    public void csokkentCselekvesSzamlalo() {
        cselekvesSzamlalo--;
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

    public void setEhseg(int ehseg) {
        this.ehseg = ehseg;
    }

    public int getSzomjusag() {
        return szomjusag;
    }

    public void setSzomjusag(int szomjusag) {
        this.szomjusag = szomjusag;
    }

    public int getCselekvesSzamlalo() {
        return cselekvesSzamlalo;
    }

    public void setCselekvesSzamlalo(int cselekvesSzamlalo) {
        this.cselekvesSzamlalo = cselekvesSzamlalo;
    }

    public Map<String, Integer> getHolmik() {
        return holmik;
    }

    public String getFormazottCselekvesSzamlalo() {
        return "korok szama: " + cselekvesSzamlalo;
    }

    public String getFormazottSzomjusag() {
        return "szomjusag: " + szomjusag;
    }

    public String getFormazottEhseg() {
        return "ehseg: " + ehseg;
    }

    public String getFormazottHolmik() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> e : holmik.entrySet()) {
            builder.append(e.getKey())
                    .append(": ")
                    .append(e.getValue())
                    .append("  ");
        }
        return builder.toString();
    }

    @Override
    public String tipus() {
        return JATEKOS_TIPUS;
    }
}
