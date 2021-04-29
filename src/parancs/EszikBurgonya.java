package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 *viszater igazzal hogy eheto e mar a burgony es megeszi
 */
public class EszikBurgonya extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ_TIPUS)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultBurgonya();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszBurgonya();
        palya.getJatekos().eszik();
    }
}
