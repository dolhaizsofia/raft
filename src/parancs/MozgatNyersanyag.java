package parancs;

import palya.JatekElem;
import palya.Mezo;
import palya.Palya;
import termek.Halo;

import static nyersanyag.Nyersanyag.nyersanyagE;
import static palya.Tenger.TENGER_TIPUS;

/**
 * minden lepesnel lemozgatja eggyel a nyersanyagokat ha oda mehet nyersanyag
 */
public class MozgatNyersanyag extends Parancs {
    /**
     * megnezi hogy mehet e oda nyersanyag
     * @param palya
     * @return
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return nyersanyagE(mezo.getLegfelso().tipus());
    }

    @Override
    protected void vegrehajt(Palya palya) {
        leMozgat(palya);
    }

    /**
     * lemozgatja minden lepesnel a nyersanyagokat
     * @param p
     */
    private void leMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya.length - 1
                && (palya[currI + 1][currJ].getLegfelso().tipus().equals(TENGER_TIPUS)
                || palya[currI + 1][currJ].getLegfelso().tipus().equals(Halo.HALO_TIPUS))) {
            palya[currI + 1][currJ].lehelyez(jatekElem);
        }
    }

}
