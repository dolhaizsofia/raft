package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasJobbraFel extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        jobbraFelMozgat(palya);
    }

    private void jobbraFelMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya[currI].length - 1 && currI > 0) {
            palya[currI-1][currJ + 1].lehelyez(jatekElem);
        }
    }

}
