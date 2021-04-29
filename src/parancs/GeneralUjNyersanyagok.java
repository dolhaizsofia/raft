package parancs;

import palya.Palya;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static palya.elemek.nyersanyag.NyersanyagFactory.letrehozNyersanyag;

/**
 * uj nyersanyagokat general
 */
public class GeneralUjNyersanyagok extends Parancs {

    private static final Random random = new Random();

    private boolean valid = true;

    /**
     * feluldefinialja a szuloosztalyt
     *
     * @param palya
     * @return
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        if (valid) {
            valid = false;
            return true;
        }
        return false;
    }

    /**
     * feluldefinialja a szulo osztalyt
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        generalUjNyersanyagok(palya);
    }

    /**
     * uj gyersanyagokat general
     *
     * @param palya
     */
    private void generalUjNyersanyagok(Palya palya) {
        int nyersanyagSzam = random.nextInt(3 + 1);
        Set<Integer> hova = new HashSet<>();
        for (int i = 0; i < nyersanyagSzam; i++) {
            hova.add(random.nextInt(palya.getTabla()[0].length));
        }
        for (int oszlop : hova) {
            palya.getTabla()[0][oszlop].lehelyez(letrehozNyersanyag());
        }
    }
}
