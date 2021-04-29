package parancs;

import palya.Mezo;
import palya.Palya;

import static palya.Jatekos.JATEKOS_TIPUS;
/**
 * ez az osztaly minden cselekvesnel az jatekosunk erejebol azaz szomjusagabol es esegebol
 */
public class LeveszEro extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentElet();
        palya.getJatekos().csokkentElet();
    }
}
