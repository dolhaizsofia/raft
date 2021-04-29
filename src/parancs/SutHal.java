package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Hal;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Hal.HAL_TIPUS;
import static termek.Tuz.TUZ;

public class SutHal extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ)
                && palya.getJatekos().keresHolmni(HAL_TIPUS) > 0;
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        palya.getJatekos().csokkentHolmi(HAL_TIPUS, 1);
        ((Tuz) mezo.getMasodikLegfelso()).rarak(new Hal());
    }

}
