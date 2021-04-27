package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasFel extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        felMozgat(palya);
    }

    private void felMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI > 0) {
            palya[currI - 1][currJ].lehelyez(jatekElem);
        }
    }

}
