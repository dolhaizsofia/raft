package parancs;

import palya.Irany;

import static palya.Irany.*;

/**
 * melyik szamkombinacioval milyen parancsot hajt vegre a jatek
 */
public class ParancsFactory {

    private ParancsFactory() {
    }

    /**
     * parancskodok
     * @param parancsKod kod
     * @return mit csinaljon az adott kodra
     */
    public static Parancs letrehozParancs(int parancsKod) {
        Irany irany = getIrany(parancsKod % 10);
        switch (parancsKod / 10) {
            case 0:
                return new Mozgas(irany);
            case 1:
                return new Felvesz(irany);
            case 2:
                return new LehelyezHalo(irany);
            case 3:
                return new LehelyezViztisztito(irany);
            case 4:
                return new LehelyezTuzhely(irany);
            case 5:
                return new Bovites(irany);
            case 90:
                return new Iszik();
            case 91:
                return new EszikHal();
            case 92:
                return new EszikBurgonya();
            case 93:
                return new Horgaszik();
            case 94:
                return new SutHal();
            case 95:
                return new SutBurgonya();
            default:
                return new NoOp();
        }
    }

    private static Irany getIrany(int parancsKod) {
        switch (parancsKod) {
            case 1:
                return BALLE;
            case 2:
                return LE;
            case 3:
                return JOBBLE;
            case 4:
                return BAL;
            case 6:
                return JOBB;
            case 7:
                return BALFEL;
            case 8:
                return FEL;
            case 9:
                return JOBBFEL;
            default:
                return NOOP;
        }
    }

}
