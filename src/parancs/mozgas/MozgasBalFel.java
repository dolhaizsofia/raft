package parancs.mozgas;

import palya.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasBalFel extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        balraFelMozgat(palya);
    }

    private void balraFelMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currJ > 0 && currI > 0) {
            palya[currI - 1][currJ - 1].lehelyez(jatekElem);
        }
    }

}
