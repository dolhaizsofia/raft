package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Viztisztito;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Viztisztito.VIZ_TISZTITO_TIPUS;

/**
 * ha van egy pohar tiszta vize es a viztisztito melet van akkor iszik es no a szomjusaga
 */
public class Iszik extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, VIZ_TISZTITO_TIPUS)
                && ((Viztisztito) mezo.getMasodikLegfelso()).vanEgyPoharnyi();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Viztisztito) mezo.getMasodikLegfelso()).csokkentEgyPoharral();
        palya.getJatekos().iszik();
    }
}
