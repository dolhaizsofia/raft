package parancs;

import parancs.mozgas.MozgasBalra;
import parancs.mozgas.MozgasFel;
import parancs.mozgas.MozgasJobbraFel;
import parancs.mozgas.MozgasLe;

import static palya.Irany.BALFEL;

public class ParancsFactory {

    public static Parancs letrehozParancs(int parancsKod) {
        switch (parancsKod) {
            case 2: return new MozgasLe();
            case 8: return new MozgasFel();
            case 4: return new MozgasBalra();
            case 9: return new MozgasJobbraFel();
            case 5: return new Bovites();
            case 0: return new Felvesz(BALFEL);
            default: return new NoOp();
        }

    }

}
