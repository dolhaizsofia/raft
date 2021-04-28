package parancs;

import palya.Irany;
import palya.Mezo;
import palya.Palya;

import static palya.Jatekos.JATEKOS;

public class LehelyezViztisztito extends Parancs {

    private Irany irany;

    public LehelyezViztisztito(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getJatekElem().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya palya) {

    }
}
