package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasJobbraLe extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        jobbraLeMozgat(palya);
    }

    private void jobbraLeMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currI < palya[currI].length - 1 && currI < palya.length - 1) {
            palya[currI+1][currJ + 1].lehelyez(jatekElem);
        }
    }

}
