package parancs;

import palya.Mezo;
import palya.Palya;

import static jatekos.Jatekos.JATEKOS;

public class LehelyezViztisztito extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getJatekElem().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya palya) {

    }
}