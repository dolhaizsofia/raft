package parancs;

import palya.JatekElem;
import palya.Mezo;
import palya.Palya;

import java.util.Random;

import static palya.Capa.CAPA_TIPUS;
import static palya.Tenger.TENGER_TIPUS;

public class CapaMozgas extends Parancs {

    private static Random random = new Random();

    private boolean valid = true;

    /**
     *
     * @param palya a palyat vizsgalja
     * @return viszater hogy oda mehet e a capa
     */

    @Override
    protected boolean tamogatott(Palya palya) {
        return mezoTipusu(palya, CAPA_TIPUS) && valid;
    }

    /**
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

    private boolean tengerMezoE(Palya palya, int ujI, int ujJ) {
        return palya.palyanBelulE(ujI, ujJ)
                && palya.getTabla()[ujI][ujJ].getLegfelso().tipus().equals(TENGER_TIPUS);
    }
}
