package parancs;

import palya.*;
import termek.Viztisztito;

import static palya.Jatekos.JATEKOS;

public class LehelyezViztisztito extends Parancs {

    private Irany irany;

    public LehelyezViztisztito(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Viztisztito());
    }
}
