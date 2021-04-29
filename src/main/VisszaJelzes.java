package main;

import java.util.HashMap;
import java.util.Map;

import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Hal.HAL_TIPUS;

public class VisszaJelzes {
    private Integer korokSzama;
    private Integer szomjusag;
    private Integer ehseg;
    private Map<String, Integer> holmik;

    /**
     * feldolgoza hogy a jatekosnak hogy all menyire ehes, szomjas, menyi holmija van es mennyi kore van meg
     * @param korokSzama
     * @param szomjusag
     * @param ehseg
     * @param holmik
     */

    VisszaJelzes(int korokSzama, int szomjusag, int ehseg, Map<String, Integer> holmik) {
        this.korokSzama = korokSzama;
        this.szomjusag = szomjusag;
        this.ehseg = ehseg;
        this.holmik = holmik;
    }

    VisszaJelzes() {
        this.korokSzama = 1000;
        this.szomjusag = 100;
        this.ehseg = 100;holmik = new HashMap<>();
        holmik.put(DESZKA_TIPUS, 0);
        holmik.put(LEVEL_TIPUS, 0);
        holmik.put(HULLADEK_TIPUS, 0);
        holmik.put(BURGONYA_TIPUS, 0);
        holmik.put(HAL_TIPUS, 0);
    }

    String getKorokSzama() {
        return "korok szama: " + korokSzama.toString();
    }

    String getSzomjusag() {
        return "szomjusag: " + szomjusag.toString();
    }

    String getEhseg() {
        return "ehseg: " + ehseg.toString();
    }

    String getHolmik() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> e:holmik.entrySet()) {
            builder.append(e.getKey())
                    .append(": ")
                    .append(e.getValue())
                    .append("  ");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "korokSzama=" + korokSzama + "\n" +
                ", szomjusag=" + szomjusag + "\n" +
                ", ehseg=" + ehseg;
    }
}
