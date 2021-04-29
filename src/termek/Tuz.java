package termek;

import palya.JatekElem;

import java.util.ArrayList;
import java.util.List;

/** eldonti a statikus metodusa  hogy termek e
 *es eltarolja a termekhez tartozo informaciokat
 * es metodusokat
 */
public class Tuz implements JatekElem {

    private List<Burgonya> burgonyak;
    private List<Hal> halak;

    public static final String TUZ_TIPUS = "tuz";

    public Tuz() {
        burgonyak = new ArrayList<>();
        halak = new ArrayList<>();
    }

    /**
     * rarakja a burgonyat
     * @param b
     */
    public void rarak(Burgonya b) {
        burgonyak.add(b);
    }

    /**
     * rarakja a halat
     * @param h
     */
    public void rarak(Hal h) {
        halak.add(h);
    }

    /**
     * van e mar megsult hal
     * @return
     */
    public boolean vanSultHal() {
        for (Hal h: halak) {
            if (h.kesz()) {
                return true;
            }
        }
        return false;
    }

    /**
     * van e mar megsult burgonya
     * @return
     */
    public boolean vanSultBurgonya() {
        for (Burgonya b: burgonyak) {
            if (b.kesz()) {
                return true;
            }
        }
        return false;
    }

    /**
     * suti a burgonyat es a halat
     */
    public void sul() {
        for (Burgonya b: burgonyak) {
            b.novelAtsultseg();
        }
        for (Hal h: halak) {
            h.novelAtsultseg();
        }
    }

    /**
     * ha megsult a burgony leveszi
     */
    public void leveszBurgonya() {
        for (Burgonya b: burgonyak) {
            if (b.kesz()) {
                burgonyak.remove(b);
                break;
            }
        }
    }

    /**
     * meg lehet enni a halat akkor leveszi
     */
    public void leveszHal() {
        for (Hal h: halak) {
            if (h.kesz()) {
                halak.remove(h);
                break;
            }
        }
    }
    /**
     * feluldefinialja a tipust
     * @return
     */
    @Override
    public String tipus() {
        return TUZ_TIPUS;
    }
}
