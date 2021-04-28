package parancs;

import palya.Mezo;
import palya.Palya;

import static jatekos.Jatekos.JATEKOS;

public class LeveszEro extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getJatekElem().tipus().equals(JATEKOS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentElet();
    }
}
