package main;

import java.util.HashMap;
import java.util.Map;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;
import static termek.Burgonya.BURGONYA;
import static termek.Hal.HAL;

public class VisszaJelzes {
    private Integer korokSzama;
    private Integer szomjusag;
    private Integer ehseg;
    private Map<String, Integer> holmik;

    public VisszaJelzes(int korokSzama, int szomjusag, int ehseg, Map<String, Integer> holmik) {
        this.korokSzama = korokSzama;
        this.szomjusag = szomjusag;
        this.ehseg = ehseg;
        this.holmik = holmik;
    }

    public VisszaJelzes() {
        this.korokSzama = 1000;
        this.szomjusag = 100;
        this.ehseg = 100;holmik = new HashMap<>();
        holmik.put(DESZKA, 0);
        holmik.put(LEVEL, 0);
        holmik.put(HULLADEK, 0);
        holmik.put(BURGONYA, 0);
        holmik.put(HAL, 0);
    }

    public String getKorokSzama() {
        return "korok szama: " + korokSzama.toString();
    }

    public String getSzomjusag() {
        return "szomjusag: " + szomjusag.toString();
    }

    public String getEhseg() {
        return "ehseg: " + ehseg.toString();
    }

    public String getHolmik() {
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
