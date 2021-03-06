package parancs;

import palya.JatekElem;
import palya.Mezo;
import palya.Palya;

import java.util.Random;

import static palya.elemek.Capa.CAPA_TIPUS;
import static palya.elemek.Tenger.TENGER_TIPUS;

/**
 * palyat vizsgalja hogy oda mehet e a capa
 */
public class CapaMozgas extends Parancs {

    private static final Random random = new Random();

    private boolean valid = true;

    /**
     * @param palya palyat kap parameterul
     * @return ha capa es igaz akkor igaz ha nem capa kkor mindegy mert a capat akkarjuk mozgatni
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        return mezoTipusu(palya, CAPA_TIPUS) && valid;
    }

    /**
     * veletlencseruen generalt szammal adunk neki iranyt es emiat osze visza fog menni
     *
     * @param p
     */
    @Override
    protected void vegrehajt(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();

        int randI = random.nextInt(3) - 1;
        int randJ = random.nextInt(3) - 1;

        while (!tengerMezoE(p, currI + randI, currJ + randJ)) {
            randI = random.nextInt(3) - 1;
            randJ = random.nextInt(3) - 1;
        }

        JatekElem jatekElem = palya[currI][currJ].levesz();
        p.getTabla()[currI + randI][currJ + randJ].lehelyez(jatekElem);
        valid = false;
    }

    /**
     * lekezeli hogy ne mehesen ra a hajora
     *
     * @param palya
     * @param ujI
     * @param ujJ
     * @return
     */
    private boolean tengerMezoE(Palya palya, int ujI, int ujJ) {
        return palya.palyanBelulE(ujI, ujJ)
                && palya.getTabla()[ujI][ujJ]
                .getLegfelso()
                .tipus()
                .equals(TENGER_TIPUS);
    }
}
