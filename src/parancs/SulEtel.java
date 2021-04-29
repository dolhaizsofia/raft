package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static termek.Tuz.TUZ_TIPUS;

/**
 * ha van hal vagy burgonya a tuzhelyen akkor azt suti
 */
public class SulEtel extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getElemek().stream().anyMatch(e -> e.tipus().equals(TUZ_TIPUS));
    }

    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        mezo.getElemek()
                .stream()
                .filter(e -> e.tipus().equals(TUZ_TIPUS))
                .forEach(e -> ((Tuz) e).sul());
    }
}
