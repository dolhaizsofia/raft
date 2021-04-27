package parancs;

import parancs.mozgas.MozgasLe;

public class ParancsFactory {

    public static Parancs letrehozParancs(int parancsKod) {
        switch (parancsKod) {
            case 2: return new MozgasLe();
            case 5: return new Bovites();
            default: return new NoOp();
        }

    }

}
