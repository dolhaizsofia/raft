package parancs;

import palya.Palya;
import termek.Hal;

import java.util.Random;

import static palya.Jatekos.JATEKOS_TIPUS;
import static palya.Tenger.TENGER_TIPUS;

public class Horgaszik extends Parancs {

    private static Random random = new Random();

    /**
     *
     * @param palya megvizsgalja a hogy az emberunk aki horgaszni szeretne vizbe van e
     * @return ha vizbe van hagyja horgaszni ha nem akkor nem csinal semmit
     */

    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.aktualisMezo().ellFelsoKetTipusat(JATEKOS_TIPUS, TENGER_TIPUS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        if (random.nextInt(4) == 1) {
            palya.getJatekos().felvesz(new Hal());
        }
    }
}
