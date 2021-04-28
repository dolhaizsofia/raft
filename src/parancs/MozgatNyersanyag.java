package parancs;

import palya.JatekElem;
import palya.Mezo;
import palya.Palya;

import static nyersanyag.Nyersanyag.nyersanyagE;

public class MozgatNyersanyag extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return nyersanyagE(mezo.getJatekElem().tipus());
    }

    @Override
    protected void vegrehajt(Palya palya) {
        leMozgat(palya);
    }

    private void leMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya.length - 1) {
            palya[currI + 1][currJ].lehelyez(jatekElem);
        }
    }

}
