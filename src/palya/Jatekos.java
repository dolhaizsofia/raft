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

    /**
     * jatekos tartalmaz egy HashMapet amibe nyersanyag tipusok es ertekeik vannak
     */
    public Jatekos() {
        holmik = new LinkedHashMap<>();
        holmik.put(DESZKA_TIPUS, 0);
        holmik.put(LEVEL_TIPUS, 0);
        holmik.put(HULLADEK_TIPUS, 0);
        holmik.put(BURGONYA_TIPUS, 0);
        holmik.put(HAL_TIPUS, 0);
    }

    /**
     *
     * @return szomjan vagy ehen halt e a jatekosunk
     */
    public boolean isDead() {
        return ehseg <= 0 && szomjusag <= 0;
    }

    /**
     * vege a jateknak mert lejatszotal 1000 lepest
     * @return
     */
    public boolean segitsegMegJott() {
        return cselekvesSzamlalo <= 0;
    }

    /**
     *
     * @param holmi nyersanyag fajta ami benne van a mapbe
     * @return van e ilyen holmilya az embernek
     */
    public int keresHolmni(String holmi) {
        return holmik.getOrDefault(holmi, 0);
    }

    /**
     *
     * @param holmi nyersanyag fajta ami benne van a mapbe
     * @param mennyiseg ha vett valamit a jatekos csokkenti hogy a mennyisegevel a holmi menyiseget
     */
    public void csokkentHolmi(String holmi, int mennyiseg) {
        holmik.put(holmi, holmik.get(holmi) - mennyiseg);
    }

    /**
     *
     * @param jatekElem felveszi a megfelelo nyersanyagot
     */
    public void felvesz(JatekElem jatekElem) {
        if (jatekElem.tipus().equals(HORDO_TIPUS)) {
            for (Nyersanyag nyersanyag : ((Hordo) jatekElem).getTartalom()) {
                holmik.put(nyersanyag.tipus(), holmik.get(nyersanyag.tipus()) + 1);
            }
        } else {
            holmik.put(jatekElem.tipus(), holmik.get(jatekElem.tipus()) + 1);
        }
    }

    /**
     * minden cselekvesnel csokkenti a szomjusagot es az ehseget
     */
    public void csokkentElet() {
        ehseg--;
        szomjusag--;
    }

    /**
     * minden cselekvesnel csokkeni a meg vegrehajthato cselekvesek szamat
     */
    public void csokkentCselekvesSzamlalo() {
        cselekvesSzamlalo--;
    }

    /**
     * iszik es noveli a szomjusagat
     */
    public void iszik() {
        szomjusag = min(szomjusag + 40, 100 + 1); //+1 a mostani kor miatt
    }

    /**
     * eszik es noveli a ehseget
     */
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

    /**
     * felulirja a tipust jatekos tipusra
     * @return
     */
    @Override
    public String tipus() {
        return JATEKOS_TIPUS;
    }
}
