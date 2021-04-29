package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Burgonya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Tuz.TUZ;
/**
 * ha van burgonya es felrakjuk sutni akkor megsuti
 */
public class SutBurgonya extends Parancs {
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ)
                && palya.getJatekos().keresHolmni(BURGONYA_TIPUS) > 0;
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        palya.getJatekos().csokkentHolmi(BURGONYA_TIPUS, 1);
        ((Tuz) mezo.getMasodikLegfelso()).rarak(new Burgonya());
    }
}
