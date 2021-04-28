package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS;
import static termek.Tuz.TUZ;

public class EszikBurgonya extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS, TUZ)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultBurgonya();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszBurgonya();
        palya.getJatekos().eszik();
    }
}
