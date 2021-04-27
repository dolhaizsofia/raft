package parancs.mozgas;

import jatekos.JatekElem;
import palya.Mezo;
import palya.Palya;

public class MozgasBalra extends MozgasParancs {

    @Override
    public void vegrehajt(Palya palya) {
        balraMozgat(palya);
    }

    private void balraMozgat(Palya p) {
        Mezo[][] palya = p.getTabla();
        int currI = p.getCurrI();
        int currJ = p.getCurrJ();
        JatekElem jatekElem = palya[currI][currJ].levesz();
        if (currJ > 0) {
            palya[currI][currJ - 1].lehelyez(jatekElem);
        }
    }

}
