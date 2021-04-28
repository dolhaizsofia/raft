package parancs;

import parancs.mozgas.MozgasBalra;
import parancs.mozgas.MozgasFel;
import parancs.mozgas.MozgasJobbraFel;
import parancs.mozgas.MozgasLe;

import static palya.Irany.*;

public class ParancsFactory {

    public static Parancs letrehozParancs(int parancsKod) {
        switch (parancsKod) {
            case 2:
                return new MozgasLe();
            case 8:
                return new MozgasFel();
            case 4:
                return new MozgasBalra();
            case 9:
                return new MozgasJobbraFel();
            //case 5:
               // return new Bovites();
            case 11:
                return new Felvesz(BALLE);
            case 12:
                return new Felvesz(LE);
            case 13: return new Felvesz(JOBBLE);
            case 14: return new Felvesz(BAL);
            case 16: return new Felvesz(JOBB);
            case 17: return new Felvesz(BALFEL);
            case 18: return new Felvesz(FEL);
            case 19: return new Felvesz(JOBBFEL);
            case 21: return new LehelyezHalo(BALLE);
            case 22: return new LehelyezHalo(LE);
            case 23: return new LehelyezHalo(JOBBLE);
            case 24: return new LehelyezHalo(BAL);
            case 26: return new LehelyezHalo(JOBB);
            case 27: return new LehelyezHalo(BALFEL);
            case 28: return new LehelyezHalo(FEL);
            case 29: return new LehelyezHalo(JOBBFEL);
            case 41: return new LehelyezTuzhely(BALLE);
            case 42: return new LehelyezTuzhely(LE);
            case 43: return new LehelyezTuzhely(JOBBLE);
            case 44: return new LehelyezTuzhely(BAL);
            case 46: return new LehelyezTuzhely(JOBB);
            case 47: return new LehelyezTuzhely(BALFEL);
            case 48: return new LehelyezTuzhely(FEL);
            case 49: return new LehelyezTuzhely(JOBBFEL);
            case 61: return new LehelyezViztisztito(BALLE);
            case 62: return new LehelyezViztisztito(LE);
            case 63: return new LehelyezViztisztito(JOBBLE);
            case 64: return new LehelyezViztisztito(BAL);
            case 66: return new LehelyezViztisztito(JOBB);
            case 67: return new LehelyezViztisztito(BALFEL);
            case 68: return new LehelyezViztisztito(FEL);
            case 69: return new LehelyezViztisztito(JOBBFEL);
            case 51: return new Bovites(BALLE);
            case 52: return new Bovites(LE);
            case 53: return new Bovites(JOBBLE);
            case 54: return new Bovites(BAL);
            case 56: return new Bovites(JOBB);
            case 57: return new Bovites(BALFEL);
            case 58: return new Bovites(FEL);
            case 59: return new Bovites(JOBBFEL);

            default: return new NoOp();
        }

    }

}
