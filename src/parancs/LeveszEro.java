package parancs;

import palya.Mezo;
import palya.Palya;

import static palya.Jatekos.JATEKOS;

public class LeveszEro extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentElet();
    }
}
