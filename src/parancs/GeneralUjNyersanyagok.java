package parancs;

import palya.Palya;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static nyersanyag.NyersanyagFactory.letrehozNyersanyag;

public class GeneralUjNyersanyagok extends Parancs {

    private static Random random = new Random();

    private boolean valid = true;

    /**
     *
     * @param palya megvizsgalja a palyat hogy ott van e mar nyersanyag
     * @return visszater igazzal ha nincs meg ott semmi es hamisal ha van
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
     *
     * @param palya
     */

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
