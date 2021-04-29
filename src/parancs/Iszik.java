package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Viztisztito;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Viztisztito.VIZ_TISZTITO;

public class Iszik extends Parancs{

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, VIZ_TISZTITO)
                && ((Viztisztito) mezo.getMasodikLegfelso()).vanEgyPoharnyi();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Viztisztito) mezo.getMasodikLegfelso()).csokkentEgyPoharral();
        palya.getJatekos().iszik();
    }
}
