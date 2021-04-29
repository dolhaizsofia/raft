package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ;

public class EszikHal extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultHal();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszHal();
        palya.getJatekos().eszik();
    }
}
