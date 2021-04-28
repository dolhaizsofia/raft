package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Burgonya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS;
import static termek.Burgonya.BURGONYA;
import static termek.Tuz.TUZ;

public class SutKrumpli extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS, TUZ)
                && palya.getJatekos().keresHolmni(BURGONYA) > 0;
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        palya.getJatekos().csokkentHolmi(BURGONYA, 1);
        ((Tuz) mezo.getMasodikLegfelso()).rarak(new Burgonya());
    }
}
