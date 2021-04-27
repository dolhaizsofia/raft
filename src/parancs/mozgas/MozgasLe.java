package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasLe extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
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
