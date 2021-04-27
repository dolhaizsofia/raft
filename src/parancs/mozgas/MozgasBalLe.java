package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasBalLe extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        balraLeMozgat(palya);
    }

    private void balraLeMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currJ > 0 && currI < palya.length - 1) {
            palya[currI+1][currJ - 1].lehelyez(jatekElem);
        }
    }

}
