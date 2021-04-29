package parancs;

import static palya.Irany.*;

/**
 * melyik szamkombinacioval milyen parancsot hajt vegre a jatek
 */
public class ParancsFactory {

    public static Parancs letrehozParancs(int parancsKod) {
        switch (parancsKod) {
            case 1:
                return new Mozgas(BALLE);
            case 2:
                return new Mozgas(LE);
            case 3:
                return new Mozgas(JOBBLE);
            case 4:
                return new Mozgas(BAL);
            case 6:
                return new Mozgas(JOBB);
            case 7:
                return new Mozgas(BALFEL);
            case 8:
                return new Mozgas(FEL);
            case 9:
                return new Mozgas(JOBBFEL);
            case 11:
                return new Felvesz(BALLE);
            case 12:
                return new Felvesz(LE);
            case 13:
                return new Felvesz(JOBBLE);
            case 14:
                return new Felvesz(BAL);
            case 16:
                return new Felvesz(JOBB);
            case 17:
                return new Felvesz(BALFEL);
            case 18:
                return new Felvesz(FEL);
            case 19:
                return new Felvesz(JOBBFEL);
            case 21:
                return new LehelyezHalo(BALLE);
            case 22:
                return new LehelyezHalo(LE);
            case 23:
                return new LehelyezHalo(JOBBLE);
            case 24:
                return new LehelyezHalo(BAL);
            case 26:
                return new LehelyezHalo(JOBB);
            case 27:
                return new LehelyezHalo(BALFEL);
            case 28:
                return new LehelyezHalo(FEL);
            case 29:
                return new LehelyezHalo(JOBBFEL);
            case 31:
                return new LehelyezViztisztito(BALLE);
            case 32:
                return new LehelyezViztisztito(LE);
            case 33:
                return new LehelyezViztisztito(JOBBLE);
            case 34:
                return new LehelyezViztisztito(BAL);
            case 36:
                return new LehelyezViztisztito(JOBB);
            case 37:
                return new LehelyezViztisztito(BALFEL);
            case 38:
                return new LehelyezViztisztito(FEL);
            case 39:
                return new LehelyezViztisztito(JOBBFEL);
            case 41:
                return new LehelyezTuzhely(BALLE);
            case 42:
                return new LehelyezTuzhely(LE);
            case 43:
                return new LehelyezTuzhely(JOBBLE);
            case 44:
                return new LehelyezTuzhely(BAL);
            case 46:
                return new LehelyezTuzhely(JOBB);
            case 47:
                return new LehelyezTuzhely(BALFEL);
            case 48:
                return new LehelyezTuzhely(FEL);
            case 49:
                return new LehelyezTuzhely(JOBBFEL);
            case 51:
                return new Bovites(BALLE);
            case 52:
                return new Bovites(LE);
            case 53:
                return new Bovites(JOBBLE);
            case 54:
                return new Bovites(BAL);
            case 56:
                return new Bovites(JOBB);
            case 57:
                return new Bovites(BALFEL);
            case 58:
                return new Bovites(FEL);
            case 59:
                return new Bovites(JOBBFEL);
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

}
