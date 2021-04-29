package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 * megvizsgalja a palyat ha van hal es megsult visszater igazzal ha me nincs vagy meg nyers akkor hamissal
 */
public class EszikHal extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ_TIPUS)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultHal();
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszHal();
        palya.getJatekos().eszik();
    }
}
