package parancs;

import palya.Palya;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static nyersanyag.NyersanyagFactory.letrehozNyersanyag;
/**
 * uj nyersanyagokat general
 */
public class GeneralUjNyersanyagok extends Parancs {

    private static Random random = new Random();

    private boolean valid = true;

    @Override
    protected boolean tamogatott(Palya palya) {
        if (valid) {
            valid = false;
            return true;
        }
        return false;
    }

    @Override
    protected void vegrehajt(Palya palya) {
        generalUjNyersanyagok(palya);
    }

    private void generalUjNyersanyagok(Palya palya) {
        int nyersanyagSzam = random.nextInt(3 + 1);
        Set<Integer> hova = new HashSet<>();
        for (int i = 0; i < nyersanyagSzam; i++) {
            hova.add(random.nextInt(palya.getTabla()[0].length));
        }
        for (int oszlop: hova) {
            palya.getTabla()[0][oszlop].lehelyez(letrehozNyersanyag());
        }
    }
}
