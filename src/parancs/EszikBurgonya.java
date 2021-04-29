package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ;

public class EszikBurgonya extends Parancs {

    /**
     *
     * @param palya a aplyat vizsgalja
     * @return viszater hogy eheto e mar a burgony
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultBurgonya();
    }

    /**
     *
     * @param palya megvizsgalja a palyat es hogy ha eheto a burgonya megeszi
     */
    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszBurgonya();
        palya.getJatekos().eszik();
    }
}
