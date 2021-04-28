package parancs.mozgas;

import palya.Mezo;
import palya.Palya;
import parancs.Parancs;

import static palya.Jatekos.JATEKOS;

public abstract class MozgasParancs extends Parancs {

    private boolean valid = true;

    @Override
    protected boolean tamogatott(Palya p) {
        Mezo mezo = p.aktualisMezo();
        if(valid && mezo.getLegfelso().tipus().equals(JATEKOS)) {
            valid = false;
            return true;
        }
        return false;
    }

}
